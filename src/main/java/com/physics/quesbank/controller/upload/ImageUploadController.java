package com.physics.quesbank.controller.upload;

import com.physics.quesbank.util.Base64Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.PrintWriter;
import java.util.*;

/**
 * @ClassName ImageUploadController
 * @Description TODO
 * @Author aron
 * @Date 2020/9/24 13:33
 **/
@Controller
@RequestMapping("imgUploadCtl")
public class ImageUploadController {

    protected final static Logger logger = LoggerFactory.getLogger(ImageUploadController.class);

    @Value("${imageUpload.path}")
    private String path;

    /**
     * 公式上传
     * @param base64
     * @return
     * @throws Exception
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(String base64) throws Exception {
        String fileName = UUID.randomUUID().toString().replace("-", "");
        Base64Util.GenerateImage(base64, path + fileName + ".png");
        return fileName;
    }

    /**
     * 题目录入时检索
     * @param upload
     * @param request
     * @param out
     */
    @RequestMapping(value = "/uploadPhoto", method = RequestMethod.POST)
    @ResponseBody
    public void uploadPhoto(MultipartFile upload, HttpServletRequest request, PrintWriter out) {
        Map<String,String> params = new HashMap();
        //获取参数进行操作
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() != 0) {
                    params.put(paramName, paramValue);
                }
            }
        }
        System.out.println(params.get("CKEditorFuncNum"));
        Map<String, String> ret = new HashMap<String, String>();
        if (upload == null) {
            ret.put("type", "error");
            ret.put("msg", "选择要上传的文件！");
//            return ret;
        }
        if (upload.getSize() > 1024 * 1024 * 10) {
            ret.put("type", "error");
            ret.put("msg", "文件大小不能超过10M！");
//            return ret;
        }
        //获取文件后缀
        String suffix = upload.getOriginalFilename().substring(upload.getOriginalFilename().lastIndexOf(".") + 1, upload.getOriginalFilename().length());
        if (!"jpg,jpeg,gif,png".toUpperCase().contains(suffix.toUpperCase())) {
            ret.put("type", "error");
            ret.put("msg", "请选择jpg,jpeg,gif,png格式的图片！");
//            return ret;
        }
        //获取项目根目录加上图片目录 webapp/static/imgages/upload/
        String savePath = path;
        File savePathFile = new File(savePath);
        if (!savePathFile.exists()) {
            //若不存在该目录，则创建目录
            savePathFile.mkdir();
        }
        String filename = new Date().getTime() + "." + suffix;
        try {
            //将文件保存指定目录
            upload.transferTo(new File(savePath + filename));
        } catch (Exception e) {
            ret.put("type", "error");
            ret.put("msg", "保存文件异常！");
            e.printStackTrace();
//            return ret;
        }
        ret.put("type", "success");
        ret.put("msg", "上传图片成功！");
        ret.put("filepath", request.getSession().getServletContext().getContextPath() + "/static/images/upload/");
        ret.put("filename", filename);
//        return ret;
        out.println("<script type=\"text/javascript\">");
        out.println("window.parent.CKEDITOR.tools.callFunction("+ params.get("CKEditorFuncNum") + ",'" +"../image/"+ filename + "','')");
        out.println("</script>");
    }

}

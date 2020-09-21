package com.physics.quesbank.controller;

import com.physics.quesbank.controller.base.BaseController;
import com.physics.quesbank.entity.highPhysicsInfo.*;
import com.physics.quesbank.entity.demo.Demo;
import com.physics.quesbank.service.demo.DemoService;
import com.physics.quesbank.util.Base64Util;
import com.physics.quesbank.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.PrintWriter;
import java.util.*;

/**
 * @ClassName demo
 * @Description TODO
 * @Author aron
 * @Date 2020/8/18 16:15
 **/
@CrossOrigin
@Controller
@RequestMapping("demo")
public class demo extends BaseController {

    protected final static Logger logger = LoggerFactory.getLogger(demo.class);

    @Autowired
    private DemoService demoService;

    @Autowired
    private HighPhysicsInfo highPhysicsInfo;

    @Value("${imageUpload.path}")
    private String path;

    @RequestMapping("test")
    public ModelAndView test(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("demo");
        return mv;
    }

    @RequestMapping("te")
    public ModelAndView te(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("te");
        return mv;
    }

    @RequestMapping("detail")
    public ModelAndView detail(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("quesPage/solve");
        return mv;
    }

    @RequestMapping("detail2")
    public ModelAndView detail2(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("quesPage/solve2");
        return mv;
    }

    @RequestMapping("quesMainPage")
    public ModelAndView quesMainPage(){
        ModelAndView mv = new ModelAndView();
        String userName = getUserInfo().getUser_name();
        mv.addObject("user_name", userName);
        mv.setViewName("quesPage/quesMainPage");
        return mv;
    }

    @RequestMapping("record")
    public ModelAndView record(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("quesPage/record");
        return mv;
    }

    @RequestMapping("login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login/login");
        return mv;
    }

    @RequestMapping("generate")
    public ModelAndView generate(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("quesPage/generate");
        return mv;
    }

    @RequestMapping("search")
    public ModelAndView search(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("quesPage/search");
        return mv;
    }

    @RequestMapping("question")
    public ModelAndView question(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("quesPage/question");
        return mv;
    }

    @RequestMapping("phy")
    @ResponseBody
    public String phy(String content){
        String h = null;
        try{
            List<HighGradeInfo> grades = highPhysicsInfo.getGrades();
            Map<String, List<HighChapterInfo>> chapters = highPhysicsInfo.getChapters();
            Map<String, List<HighChapterSubInfo>> chapterSubs = highPhysicsInfo.getChapterSubs();
            Map<String, List<HighChapterSubItemInfo>> chapterSubItems = highPhysicsInfo.getChapterSubItems();
        } catch (Exception e){
            e.printStackTrace();
        }
        return h;
    }

    @RequestMapping("save")
    @ResponseBody
    public String aaa(String content){
        try{
            Demo demo = new Demo(UUID.randomUUID().toString(), content,"1",DateUtil.getTime());
            demoService.saveInfo(demo);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "1";
    }

    @RequestMapping("save2")
    @ResponseBody
    public String aaa2(String content){
        try{
            String [] contents = content.split("<hr>");
            for (String s: contents) {
                Demo demo = new Demo(UUID.randomUUID().toString(), s,"1",DateUtil.getTime());
                demoService.saveInfo(demo);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return "1";
    }

    @RequestMapping("mainPage")
    public ModelAndView mainPage(){
        ModelAndView mv = new ModelAndView();
        List<Demo> demos = demoService.getInfo();
        mv.addObject("demos",demos);
        mv.setViewName("mainPage");
        return mv;
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String  upload(String base64) throws Exception{
        String fileName = UUID.randomUUID().toString().replace("-", "");
        Base64Util.GenerateImage(base64, path+fileName+".png");

        return fileName;


    }

    @RequestMapping("list")
    @ResponseBody
    public Object list(){
        List<Demo> demo = null;
        Map<String,Object> map = new HashMap<>();
        try{
            demo = demoService.getInfo();
            map.put("demo", demo);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("list2")
    @ResponseBody
    public Object list2(Demo demos){
        List<Demo> demo = null;
        Map<String,Object> map = new HashMap<>();
        try{
            demo = demoService.getAnswer(demos);
            map.put("demo", demo);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping(value = "/uploadPhoto", method = RequestMethod.POST)
    @ResponseBody
    public void uploadPhoto(MultipartFile upload, HttpServletRequest request,PrintWriter out) {
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

//    @RequestMapping("te")
//    @ResponseBody
//    public void te(){
//        try{
//            List<Demo> demo = demoService.getInfo();
//            StringBuilder demo1 = QuesTemplate.initQuesPage(demo);
//            PrintStream printStream = new PrintStream(new FileOutputStream("D:/test.html"));
//            printStream.println(demo1.toString());
//            te.createPDF("d:/testoone2.pdf", demo1.toString(), "aaa");
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}

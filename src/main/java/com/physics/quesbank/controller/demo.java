package com.physics.quesbank.controller;

import com.physics.quesbank.entity.demo.Demo;
import com.physics.quesbank.quesTemplate.QuesTemplate;
import com.physics.quesbank.service.demo.DemoService;
import com.physics.quesbank.util.Base64Util;
import com.physics.quesbank.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
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
public class demo {

    protected final static Logger logger = LoggerFactory.getLogger(demo.class);

    @Autowired
    private DemoService demoService;

    @RequestMapping("test")
    public ModelAndView test(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("demo");
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
        mv.setViewName("quesPage/quesMainPage");
        return mv;
    }

    @RequestMapping("record")
    public ModelAndView record(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("quesPage/record");
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
        Base64Util.GenerateImage(base64, "D:\\Idea\\workspace\\quesbank\\src\\main\\resources\\static\\demo\\aaa.png");

        return "1";


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
    public Map<String, String> uploadPhoto(MultipartFile photo, HttpServletRequest request) {
        Map<String, String> ret = new HashMap<String, String>();
        if (photo == null) {
            ret.put("type", "error");
            ret.put("msg", "选择要上传的文件！");
            return ret;
        }
        if (photo.getSize() > 1024 * 1024 * 10) {
            ret.put("type", "error");
            ret.put("msg", "文件大小不能超过10M！");
            return ret;
        }
        //获取文件后缀
        String suffix = photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf(".") + 1, photo.getOriginalFilename().length());
        if (!"jpg,jpeg,gif,png".toUpperCase().contains(suffix.toUpperCase())) {
            ret.put("type", "error");
            ret.put("msg", "请选择jpg,jpeg,gif,png格式的图片！");
            return ret;
        }
        //获取项目根目录加上图片目录 webapp/static/imgages/upload/
        String savePath = "D:/";
        File savePathFile = new File(savePath);
        if (!savePathFile.exists()) {
            //若不存在该目录，则创建目录
            savePathFile.mkdir();
        }
        String filename = new Date().getTime() + "." + suffix;
        try {
            //将文件保存指定目录
            photo.transferTo(new File(savePath + filename));
        } catch (Exception e) {
            ret.put("type", "error");
            ret.put("msg", "保存文件异常！");
            e.printStackTrace();
            return ret;
        }
        ret.put("type", "success");
        ret.put("msg", "上传图片成功！");
        ret.put("filepath", request.getSession().getServletContext().getContextPath() + "/static/images/upload/");
        ret.put("filename", filename);
        return ret;
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

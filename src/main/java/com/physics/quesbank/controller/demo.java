package com.physics.quesbank.controller;

import com.physics.quesbank.entity.demo.Demo;
import com.physics.quesbank.service.demo.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName demo
 * @Description TODO
 * @Author aron
 * @Date 2020/8/18 16:15
 **/
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

    @RequestMapping("quesMainPage")
    public ModelAndView quesMainPage(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/quesPage/quesMainPage");
        return mv;
    }

    @RequestMapping("record")
    public ModelAndView record(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/quesPage/record");
        return mv;
    }

    @RequestMapping("generate")
    public ModelAndView generate(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/quesPage/generate");
        return mv;
    }

    @RequestMapping("question")
    public ModelAndView question(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/quesPage/question");
        return mv;
    }

    @RequestMapping("save")
    @ResponseBody
    public String aaa(String content){
        try{
            Demo demo = new Demo(UUID.randomUUID().toString(), content);
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
}

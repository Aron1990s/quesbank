package com.physics.quesbank.controller.teacherRecord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TeacherRecordController
 * @Description TODO
 * @Author aron
 * @Date 2020/9/3 10:22
 **/
@Controller
@RequestMapping("teacherRecordCtl")
public class TeacherRecordController {

    protected final static Logger logger = LoggerFactory.getLogger(TeacherRecordController.class);

    @RequestMapping("goToTeacherRecord")
    public ModelAndView goToTeacherRecord(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("teacherRecord/teacherRecord");
        return mv;
    }

    /**
     * 题目录入
     * @return
     */
    @RequestMapping("questionRecord")
    @ResponseBody
    public Object questionRecord(){
        Map<String, Object> map = new HashMap<>();
        try{

            map.put("code", "1");
        } catch (Exception e){
            e.printStackTrace();
            map.put("code", "-1");
        }
        return map;
    }

}

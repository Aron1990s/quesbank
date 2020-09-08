package com.physics.quesbank.controller.highPhysicsQuestion;

import com.physics.quesbank.dao.highPhysicsQuestion.HighPhysicsQuestionDao;
import com.physics.quesbank.entity.highPhysicsQuestion.HighPhysicsQuestion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName HighPhysicsQuestionController
 * @Description TODO
 * @Author aron
 * @Date 2020/9/8 10:34
 **/
@Controller
@RequestMapping("highPhyQuesCtl")
public class HighPhysicsQuestionController {

    protected final static Logger logger = LoggerFactory.getLogger(HighPhysicsQuestionController.class);

    @Autowired
    private HighPhysicsQuestionDao highPhysicsQuestionDao;

    /**
     * 保存数据
     * @return
     */
    @RequestMapping(value = "saveHighPhysicsQuestion", method=RequestMethod.POST)
    @ResponseBody
    public Object saveHighPhysicsQuestion(HighPhysicsQuestion highPhysicsQuestion){
        Map<String, Object> map = new HashMap<>();
        try{
            highPhysicsQuestionDao.saveInfo(highPhysicsQuestion);
            map.put("code", "1");
        } catch (Exception e){
            e.printStackTrace();
            map.put("code", "-1");
        }
        return map;
    }

    /**
     * 列表获取数据
     * @param highPhysicsQuestion
     * @return
     */
    @RequestMapping(value = "listInfo", method=RequestMethod.GET)
    public ModelAndView listInfo(HighPhysicsQuestion highPhysicsQuestion){
        ModelAndView mv = new ModelAndView();
        try{

        } catch (Exception e){
            e.printStackTrace();
        }

        return mv;
    }
}

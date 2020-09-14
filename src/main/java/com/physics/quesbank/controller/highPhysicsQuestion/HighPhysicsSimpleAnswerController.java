package com.physics.quesbank.controller.highPhysicsQuestion;

import com.physics.quesbank.controller.base.BaseController;
import com.physics.quesbank.entity.highPhysicsQuestion.HighPhysicsSimpleAnswer;
import com.physics.quesbank.service.highPhysiscQuestion.HighPhysicsSimpleAnswerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName HighPhysicsSimpleAnswerController
 * @Description TODO
 * @Author aron
 * @Date 2020/9/8 11:11
 **/
@Controller
@RequestMapping("highPhySimAnswerCtl")
public class HighPhysicsSimpleAnswerController extends BaseController {

    protected final static Logger logger = LoggerFactory.getLogger(HighPhysicsSimpleAnswerController.class);

    @Autowired
    private HighPhysicsSimpleAnswerService highPhysicsSimpleAnswerService;

    /**
     * 保存数据
     * @return
     */
    @RequestMapping(value = "saveHighPhysicsSimpleAnswer", method=RequestMethod.POST)
    @ResponseBody
    public Object saveInfo(HighPhysicsSimpleAnswer highPhysicsSimpleAnswer){
        Map<String, Object> map = new HashMap<>();
        try{
            highPhysicsSimpleAnswerService.delInfo(highPhysicsSimpleAnswer);
            highPhysicsSimpleAnswer.setId(getUUID());
            highPhysicsSimpleAnswerService.saveInfo(highPhysicsSimpleAnswer);
            map.put("code", "1");
        } catch (Exception e){
            e.printStackTrace();
            map.put("code", "-1");
        }
        return map;
    }

}

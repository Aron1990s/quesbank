package com.physics.quesbank.controller.highPhysicsQuestion;

import com.physics.quesbank.controller.base.BaseController;
import com.physics.quesbank.entity.highPhysicsQuestion.HighPhysicsSimpleAnswer;
import com.physics.quesbank.entity.highPhysicsQuestion.HighPhysicsStepAnswer;
import com.physics.quesbank.service.highPhysiscQuestion.HighPhysicsStepAnswerService;
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
 * @ClassName HighPhysicsStepAnswerController
 * @Description TODO
 * @Author aron
 * @Date 2020/9/8 11:16
 **/
@Controller
@RequestMapping("highPhyStepAnswerCtl")
public class HighPhysicsStepAnswerController extends BaseController {

    protected final static Logger logger = LoggerFactory.getLogger(HighPhysicsStepAnswerController.class);

    @Autowired
    private HighPhysicsStepAnswerService highPhysicsStepAnswerService;

    /**
     * 保存数据
     * @return
     */
    @RequestMapping(value = "saveHighPhysicsStepAnswer", method=RequestMethod.POST)
    @ResponseBody
    public Object saveInfo(HighPhysicsStepAnswer highPhysicsStepAnswer){
        Map<String, Object> map = new HashMap<>();
        try{
            int step = 1;
            String [] stepAnswers = highPhysicsStepAnswer.getDetail_answer().split("<hr>");
            for (String sub : stepAnswers) {
                HighPhysicsStepAnswer subHighStepAnswer = new HighPhysicsStepAnswer();
                subHighStepAnswer.setId(getUUID());
                subHighStepAnswer.setQuestion_id(highPhysicsStepAnswer.getQuestion_id());
                subHighStepAnswer.setDetail_answer(sub);
                subHighStepAnswer.setStep(step);
                step++;
                highPhysicsStepAnswerService.saveInfo(highPhysicsStepAnswer);
            }
            map.put("code", "1");
        } catch (Exception e){
            e.printStackTrace();
            map.put("code", "-1");
        }
        return map;
    }

}

package com.physics.quesbank.controller.questionSelectInfo;

import com.physics.quesbank.controller.base.BaseController;
import com.physics.quesbank.entity.questionSelectInfo.QuestionSelectInfo;
import com.physics.quesbank.service.questionSelectInfo.QuestionSelectInfoService;
import com.physics.quesbank.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName QuestionSelectInfoController
 * @Description TODO
 * @Author aron
 * @Date 2020/12/17 16:24
 **/
@Controller
@RequestMapping("quesSelectInfoCtl")
public class QuestionSelectInfoController extends BaseController {

    protected final static Logger logger = LoggerFactory.getLogger(QuestionSelectInfoController.class);

    @Autowired
    private QuestionSelectInfoService questionSelectInfoService;

    /**
     * 保存当前选择的题目
     * @param questionSelectInfo
     * @return
     */
    @RequestMapping("saveInfo")
    @ResponseBody
    public Object saveInfo(QuestionSelectInfo questionSelectInfo){
        Map<String, Object> map = new HashMap<>();
        try{
            if (getCurrQuesSelectInfo().getMap().containsKey(questionSelectInfo.getQuestion_id())) {
                map.put("code", "-1");
                return map;
            }
            questionSelectInfo.setId(generateSnowFlakerId());
            questionSelectInfo.setUser_id(getUserInfo().getId());
            questionSelectInfo.setAdd_time(DateUtil.getTime());
            questionSelectInfoService.saveInfo(questionSelectInfo);
            map.put("code", "1");
        } catch (Exception e){
            e.printStackTrace();
            map.put("code", "-1");
        }
        return map;
    }

}

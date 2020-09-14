package com.physics.quesbank.controller.highPhysicsMajor;

import com.physics.quesbank.entity.highPhysicsMajor.HighPhysicsMajorSubItem;
import com.physics.quesbank.service.highPhysicsMajor.HighPhysicsMajorSubItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName HighPhysicsMajorSubItemController
 * @Description TODO
 * @Author aron
 * @Date 2020/9/11 17:15
 **/
@CrossOrigin
@Controller
@RequestMapping("highPhyMaSubItemCtl")
public class HighPhysicsMajorSubItemController {

    protected final static Logger logger = LoggerFactory.getLogger(HighPhysicsMajorSubItemController.class);

    @Autowired
    private HighPhysicsMajorSubItemService highPhysicsMajorSubItemService;

    @RequestMapping("saveInfo")
    @ResponseBody
    public Object saveInfo(HighPhysicsMajorSubItem highPhysicsMajorSubItem){
        Map<String, Object> map = new HashMap<>();
        try{
            highPhysicsMajorSubItemService.saveInfo(highPhysicsMajorSubItem);
            map.put("code", "1");
        } catch (Exception e){
            e.printStackTrace();
            map.put("code", "-1");
        }
        return map;
    }

}

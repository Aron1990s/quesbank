package com.physics.quesbank.controller.highPhysicsMajor;

import com.physics.quesbank.controller.base.BaseController;
import com.physics.quesbank.entity.highPhysicsMajor.HighPhysicsMajor;
import com.physics.quesbank.entity.highPhysicsMajor.HighPhysicsMajorInfo;
import com.physics.quesbank.entity.highPhysicsMajor.HighPhysicsMajorSub;
import com.physics.quesbank.entity.highPhysicsMajor.HighPhysicsMajorSubItem;
import com.physics.quesbank.service.highPhysicsMajor.HighPhysicsMajorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName HighPhysicsMajorController
 * @Description TODO
 * @Author aron
 * @Date 2020/9/14 10:44
 **/
@RestController
@RequestMapping("highPhyMajorCtl")
public class HighPhysicsMajorController extends BaseController {

    protected final static Logger logger = LoggerFactory.getLogger(HighPhysicsMajorController.class);

    @Autowired
    private HighPhysicsMajorInfo highPhysicsMajorInfo;

    /**
     * 获取major
     * @return
     */
    @RequestMapping("getMajor")
    public Object getMajor(){
        Map<String, Object> map = new HashMap<>();
        try{
            List<HighPhysicsMajor> list = highPhysicsMajorInfo.getHighPhysicsMajors();
            map.put("highPhysicsMajors", list);
            map.put("code", "1");
        } catch (Exception e){
            e.printStackTrace();
            map.put("code", "-1");
        }
        return map;
    }

    /**
     * 获取子项
     * @param highPhysicsMajor
     * @return
     */
    @RequestMapping("getMajorSub")
    public Object getMajorSub(HighPhysicsMajor highPhysicsMajor){
        Map<String, Object> map = new HashMap<>();
        try{
            List<HighPhysicsMajorSub> highPhysicsMajorSubs = highPhysicsMajorInfo.getHighPhysicsMajorSubs().get(highPhysicsMajor.getId()+"");
            map.put("highPhysicsMajorSubs", highPhysicsMajorSubs);
            map.put("code", "1");
        } catch (Exception e){
            e.printStackTrace();
            map.put("code", "-1");
        }
        return map;
    }

    /**
     * 获取子项知识点
     * @param highPhysicsMajorSub
     * @return
     */
    @RequestMapping("getMajorSubItem")
    public Object getMajorSubItem(HighPhysicsMajorSub highPhysicsMajorSub){
        Map<String, Object> map = new HashMap<>();
        try{
            List<HighPhysicsMajorSubItem> highPhysicsMajorSubItems = highPhysicsMajorInfo.getHighPhysicsMajorSubItems().get(highPhysicsMajorSub.getId()+"");
            map.put("highPhysicsMajorSubItems", highPhysicsMajorSubItems);
            map.put("code", "1");
        } catch (Exception e){
            e.printStackTrace();
            map.put("code", "-1");
        }
        return map;
    }

}

package com.physics.quesbank.controller.system.LeftNav;

import com.physics.quesbank.entity.highPhysicsInfo.HighPhysicsInfo;
import com.physics.quesbank.entity.highPhysicsMajor.HighPhysicsMajor;
import com.physics.quesbank.entity.highPhysicsMajor.HighPhysicsMajorInfo;
import com.physics.quesbank.entity.highPhysicsMajor.HighPhysicsMajorSub;
import com.physics.quesbank.entity.leftNav.BaseNav;
import com.physics.quesbank.entity.leftNav.BaseNavElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName LeftNavController
 * @Description TODO
 * @Author aron
 * @Date 2020/9/15 10:13
 **/
@RestController
@RequestMapping("leftNavCtl")
public class LeftNavController {

    protected final static Logger logger = LoggerFactory.getLogger(LeftNavController.class);

    @Autowired
    private HighPhysicsMajorInfo highPhysicsMajorInfo;

    /**
     * 初始化学科菜单
     * @return
     */
    @RequestMapping("initNavByMajor")
    public Object initNavByMajor(){
        Map<String, Object> map = new HashMap<>();
        List<BaseNavElement> baseNavElements = new ArrayList<>();
        try{
            List<HighPhysicsMajor> highPhysicsMajors = highPhysicsMajorInfo.getHighPhysicsMajors();
            for (HighPhysicsMajor subHighPhysicsMajor : highPhysicsMajors) {
                BaseNavElement baseNavElement = new BaseNavElement();
                baseNavElement.setMenuId("01");
                baseNavElement.setMenuCode("RR1234");
                baseNavElement.setMenuName(subHighPhysicsMajor.getMajor());
                baseNavElement.setMenuAction("#");
                List<BaseNav> children = new ArrayList<>();
                List<HighPhysicsMajorSub> highPhysicsMajorSubs = highPhysicsMajorInfo.getHighPhysicsMajorSubs().get(subHighPhysicsMajor.getId()+"");
                for (HighPhysicsMajorSub subHighPhysicsMajorSub : highPhysicsMajorSubs) {
                    BaseNav baseNav = new BaseNav();
                    baseNav.setMenuId("001");
                    baseNav.setMenuCode("RR1234");
                    baseNav.setMenuName(subHighPhysicsMajorSub.getMajor_sub_name());
                    baseNav.setMenuAction("../highPhyQuesCtl/configQuestionSearch?major_sub_id="+subHighPhysicsMajorSub.getId());
                    children.add(baseNav);
                }
                baseNavElement.setChildren(children);
                baseNavElements.add(baseNavElement);
            }
            map.put("data", baseNavElements);
            map.put("code", "1");
        } catch (Exception e){
            e.printStackTrace();
            map.put("code", "-1");
        }
        return map;
    }
}

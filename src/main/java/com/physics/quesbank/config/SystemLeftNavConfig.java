package com.physics.quesbank.config;

import com.physics.quesbank.entity.highPhysicsMajor.HighPhysicsMajor;
import com.physics.quesbank.entity.highPhysicsMajor.HighPhysicsMajorInfo;
import com.physics.quesbank.entity.highPhysicsMajor.HighPhysicsMajorSub;
import com.physics.quesbank.entity.leftNav.BaseNav;
import com.physics.quesbank.entity.leftNav.BaseNavElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SystemLeftNavConfig
 * @Description TODO
 * @Author aron
 * @Date 2020/9/25 10:49
 **/
@Configuration
public class SystemLeftNavConfig {

    protected final static Logger logger = LoggerFactory.getLogger(SystemLeftNavConfig.class);

    @Autowired
    private HighPhysicsMajorInfo highPhysicsMajorInfo;

    @Bean
    public List<BaseNavElement> initSystemLeftNavConfig(){
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
        } catch (Exception e){
            e.printStackTrace();
        }
        return baseNavElements;
    }

}

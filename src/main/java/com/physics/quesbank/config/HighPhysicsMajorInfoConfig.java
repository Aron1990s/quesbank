package com.physics.quesbank.config;

import com.physics.quesbank.entity.highPhysicsMajor.HighPhysicsMajor;
import com.physics.quesbank.entity.highPhysicsMajor.HighPhysicsMajorInfo;
import com.physics.quesbank.entity.highPhysicsMajor.HighPhysicsMajorSub;
import com.physics.quesbank.entity.highPhysicsMajor.HighPhysicsMajorSubItem;
import com.physics.quesbank.service.highPhysicsMajor.HighPhysicsMajorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName HighPhysicsMajorConfig
 * @Description TODO
 * @Author aron
 * @Date 2020/9/14 10:27
 **/
@Configuration
public class HighPhysicsMajorInfoConfig {

    protected final static Logger logger = LoggerFactory.getLogger(HighPhysicsMajorInfoConfig.class);

    @Autowired
    private HighPhysicsMajorService highPhysicsMajorService;

    @Bean
    public HighPhysicsMajorInfo intiHighPhysicsMajorInfoConfig(){
        HighPhysicsMajorInfo highPhysicsMajorInfo = new HighPhysicsMajorInfo();
        List<HighPhysicsMajor> highPhysicsMajors = new ArrayList<>();
        Map<String, List<HighPhysicsMajorSub>> highPhysicsMajorSubs = new HashMap<>();
        Map<String, List<HighPhysicsMajorSubItem>> highPhysicsMajorSubItems = new HashMap<>();
        try{

        } catch (Exception e){
            e.printStackTrace();
        }
        highPhysicsMajorInfo.setHighPhysicsMajors(highPhysicsMajors);
        highPhysicsMajorInfo.setHighPhysicsMajorSubs(highPhysicsMajorSubs);
        highPhysicsMajorInfo.setHighPhysicsMajorSubItems(highPhysicsMajorSubItems);
        return highPhysicsMajorInfo;
    }

}

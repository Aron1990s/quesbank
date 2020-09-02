package com.physics.quesbank.config;

import com.physics.quesbank.entity.HighPhysicsInfo.HighGradeInfo;
import com.physics.quesbank.entity.HighPhysicsInfo.HighPhysicsInfo;
import com.physics.quesbank.service.highPhysicsInfo.HighPhysicsInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

/**
 * @ClassName HighPhysicsInfoConfig
 * @Description TODO
 * @Author aron
 * @Date 2020/9/2 16:37
 **/
@Configuration
public class HighPhysicsInfoConfig {

    protected final static Logger logger = LoggerFactory.getLogger(HighPhysicsInfoConfig.class);

    @Autowired
    private HighPhysicsInfoService highPhysicsInfoService;

    @Bean
    public HighPhysicsInfo initHighPhysicsInfoConfig(){
        HighPhysicsInfo highPhysicsInfo = new HighPhysicsInfo();
        try{
            List<HighGradeInfo> highGradeInfos = highPhysicsInfoService.listHighGradeInfo();
            highPhysicsInfo.setGrades(highGradeInfos);
            for (HighGradeInfo highGradeInfo: highGradeInfos) {
                
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return highPhysicsInfo;
    }

}

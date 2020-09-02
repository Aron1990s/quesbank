package com.physics.quesbank.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

    @Bean
    public HighPhysicsInfoConfig initHighPhysicsInfoConfig(){
        HighPhysicsInfoConfig highPhysicsInfoConfig = new HighPhysicsInfoConfig();
        try{

        } catch (Exception e){
            e.printStackTrace();
        }
        return highPhysicsInfoConfig;
    }

}

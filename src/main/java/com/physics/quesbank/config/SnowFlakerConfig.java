package com.physics.quesbank.config;

import com.physics.quesbank.util.SnowflakeIdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName SnowFlakerConfig
 * @Description TODO
 * @Author aron
 * @Date 2020/12/17 16:15
 **/
@Configuration
public class SnowFlakerConfig {

    protected final static Logger logger = LoggerFactory.getLogger(SnowFlakerConfig.class);

    @Bean
    public SnowflakeIdWorker snowflakeIdWorker(){
        SnowflakeIdWorker snowflakeIdWorker = null;
        try{
            snowflakeIdWorker = new SnowflakeIdWorker(0, 1);
        } catch (Exception e){
            e.printStackTrace();
        }
        return snowflakeIdWorker;
    }

}

package com.physics.quesbank.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName Log4jHeartSchedule
 * @Description TODO
 * @Author aron
 * @Date 2019/7/12 9:34
 **/
@Component
public class Log4jHeartSchedule {

    protected final static Logger logger = LoggerFactory.getLogger(Log4jHeartSchedule.class);

    /**
     * 准点输出log保证日志正常打包
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void log4jHeartForPacket() {
        logger.info("this is for log4j2 heart beat");
    }
}

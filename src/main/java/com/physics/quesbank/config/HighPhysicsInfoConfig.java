package com.physics.quesbank.config;

import com.physics.quesbank.entity.HighPhysicsInfo.*;
import com.physics.quesbank.service.highPhysicsInfo.HighPhysicsInfoService;
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
        List<HighGradeInfo> highGradeInfos;
        Map<String, List<HighChapterInfo>> chapters = new HashMap<>();
        Map<String, List<HighChapterSubInfo>> chapterSubs = new HashMap<>();
        Map<String, List<HighChapterSubItemInfo>> chapterSubItems = new HashMap<>();
        logger.info("saasssss");
        try{
            highGradeInfos = highPhysicsInfoService.listHighGradeInfo();
            for (HighGradeInfo highGradeInfo: highGradeInfos) {
                List<HighChapterInfo> highChapterInfos = highPhysicsInfoService.listHighChapterInfo(highGradeInfo);
                chapters.put(highGradeInfo.getId()+"", highChapterInfos);

                for (HighChapterInfo highChapterInfo:highChapterInfos) {
                    List<HighChapterSubInfo> highChapterSubInfos = highPhysicsInfoService.listHighChapterSubInfo(highChapterInfo);
                    chapterSubs.put(highChapterInfo.getId()+"", highChapterSubInfos);

                    for (HighChapterSubInfo highChapterSubInfo:highChapterSubInfos) {
                        List<HighChapterSubItemInfo> highChapterSubItemInfos = highPhysicsInfoService.listHighChapterSubItemInfo(highChapterSubInfo);
                        chapterSubItems.put(highChapterSubInfo.getId()+"", highChapterSubItemInfos);
                    }
                }
            }
            highPhysicsInfo.setGrades(highGradeInfos);
            highPhysicsInfo.setChapters(chapters);
            highPhysicsInfo.setChapterSubs(chapterSubs);
            highPhysicsInfo.setChapterSubItems(chapterSubItems);
        } catch (Exception e){
            e.printStackTrace();
        }
        return highPhysicsInfo;
    }

}

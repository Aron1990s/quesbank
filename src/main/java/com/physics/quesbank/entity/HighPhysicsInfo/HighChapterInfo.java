package com.physics.quesbank.entity.HighPhysicsInfo;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName HighChapterInfo
 * @Description TODO
 * @Author aron
 * @Date 2020/9/2 16:55
 **/
@Data
public class HighChapterInfo {

    protected final static Logger logger = LoggerFactory.getLogger(HighChapterInfo.class);

    private int id;
    private String chapter_name;
    private int grade_id;


}

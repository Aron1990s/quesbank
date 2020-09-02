package com.physics.quesbank.entity.HighPhysicsInfo;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName HighChapterSubInfo
 * @Description TODO
 * @Author aron
 * @Date 2020/9/2 16:55
 **/
@Data
public class HighChapterSubInfo {

    protected final static Logger logger = LoggerFactory.getLogger(HighChapterSubInfo.class);

    private int id;
    private String chapter_sub_name;
    private int chapter_id;

}

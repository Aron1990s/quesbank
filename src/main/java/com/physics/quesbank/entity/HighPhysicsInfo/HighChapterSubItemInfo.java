package com.physics.quesbank.entity.HighPhysicsInfo;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName HighChapterSubItemInfo
 * @Description TODO
 * @Author aron
 * @Date 2020/9/2 16:55
 **/
@Data
public class HighChapterSubItemInfo {

    protected final static Logger logger = LoggerFactory.getLogger(HighChapterSubItemInfo.class);
    private int id;
    private String chapter_sub_item;
    private int chapter_sub_id;


}

package com.physics.quesbank.entity.highPhysicsMajor;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName HighPhysicsMajorSubItem
 * @Description TODO
 * @Author aron
 * @Date 2020/9/11 17:05
 **/
@Data
public class HighPhysicsMajorSubItem {

    protected final static Logger logger = LoggerFactory.getLogger(HighPhysicsMajorSubItem.class);

    private int id;
    private String major_sub_item_name;
    private int major_sub_id;


}

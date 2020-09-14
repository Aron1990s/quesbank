package com.physics.quesbank.entity.highPhysicsMajor;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName HighPhysicsMajorSub
 * @Description TODO
 * @Author aron
 * @Date 2020/9/14 10:17
 **/
@Data
public class HighPhysicsMajorSub {

    protected final static Logger logger = LoggerFactory.getLogger(HighPhysicsMajorSub.class);
    private int id;
    private int major_id;
    private String major_sub_name;


}

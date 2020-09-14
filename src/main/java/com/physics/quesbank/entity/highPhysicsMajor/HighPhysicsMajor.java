package com.physics.quesbank.entity.highPhysicsMajor;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName HighPhysicsMajorService
 * @Description TODO
 * @Author aron
 * @Date 2020/9/14 10:16
 **/
@Data
public class HighPhysicsMajor {

    protected final static Logger logger = LoggerFactory.getLogger(HighPhysicsMajor.class);

    private int id;
    private String major;

}

package com.physics.quesbank.entity.HighPhysicsInfo;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName HighGradeInfo
 * @Description TODO
 * @Author aron
 * @Date 2020/9/2 16:55
 **/
@Data
public class HighGradeInfo {

    protected final static Logger logger = LoggerFactory.getLogger(HighGradeInfo.class);

    private int id;
    private String grade;

}

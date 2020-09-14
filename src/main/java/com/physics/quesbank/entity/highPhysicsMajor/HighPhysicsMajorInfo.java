package com.physics.quesbank.entity.highPhysicsMajor;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName HighPhysicsMajorInfo
 * @Description TODO
 * @Author aron
 * @Date 2020/9/14 10:29
 **/
@Data
public class HighPhysicsMajorInfo {

    protected final static Logger logger = LoggerFactory.getLogger(HighPhysicsMajorInfo.class);

    List<HighPhysicsMajor> highPhysicsMajors = new ArrayList<>();
    Map<String, List<HighPhysicsMajorSub>> highPhysicsMajorSubs = new HashMap<>();
    Map<String, List<HighPhysicsMajorSubItem>> highPhysicsMajorSubItems = new HashMap<>();

}

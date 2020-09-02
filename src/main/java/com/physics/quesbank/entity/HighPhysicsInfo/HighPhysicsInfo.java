package com.physics.quesbank.entity.HighPhysicsInfo;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName HighPhysicsInfo
 * @Description TODO
 * @Author aron
 * @Date 2020/9/2 16:39
 **/
@Data
public class HighPhysicsInfo {

    protected final static Logger logger = LoggerFactory.getLogger(HighPhysicsInfo.class);

    private List<String> grades = new ArrayList<>();

    private Map<String, List<String>> chapters = new HashMap<>();

    private Map<String, List<String>> chapterSubs = new HashMap<>();

    private Map<String, List<String>> chapterSubItems = new HashMap<>();

}

package com.physics.quesbank.entity.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName Demo
 * @Description TODO
 * @Author aron
 * @Date 2020/8/18 16:48
 **/
@Data
@AllArgsConstructor
public class Demo {

    protected final static Logger logger = LoggerFactory.getLogger(Demo.class);
    private String id;
    private String content;

}

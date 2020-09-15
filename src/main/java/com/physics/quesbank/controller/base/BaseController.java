package com.physics.quesbank.controller.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * @ClassName BaseController
 * @Description TODO
 * @Author aron
 * @Date 2020/9/3 9:56
 **/
public class BaseController {

    protected final static Logger logger = LoggerFactory.getLogger(BaseController.class);

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }


}

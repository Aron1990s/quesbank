package com.physics.quesbank.controller.base;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
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

    /**
     * 获取UUID
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 获取session
     * @return
     */
    public static Session getSession(){
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        return session;
    }
}

package com.physics.quesbank.controller.base;

import com.physics.quesbank.constant.SessionConstant;
import com.physics.quesbank.entity.highPhysicsQuestion.HighPhysicsQuestionSearchCondition;
import com.physics.quesbank.entity.systemUser.SystemUser;
import com.physics.quesbank.util.SnowflakeIdWorker;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.UUID;

/**
 * @ClassName BaseController
 * @Description TODO
 * @Author aron
 * @Date 2020/9/3 9:56
 **/
public class BaseController {

    protected final static Logger logger = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

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

    /**
     * 获取用户信息
     * @return
     */
    public static SystemUser getUserInfo(){
        Subject currentUser = SecurityUtils.getSubject();
        SystemUser systemUser = (SystemUser) currentUser.getPrincipal();
        return systemUser;
    }

    /**
     * 获取高中物理检索
     * @return
     */
    public static HighPhysicsQuestionSearchCondition getHighPhysicsSearchCondition(){
        return (HighPhysicsQuestionSearchCondition)getSession().getAttribute(SessionConstant.HIGH_PHYSICS_QUESTION_SEARCH_CONDITION);
    }

    /**
     * 生成snowflakerId
     */
    public BigInteger generateSnowFlakerId() throws Exception{
        return new BigInteger(String.valueOf(snowflakeIdWorker.nextId()));
    }
}

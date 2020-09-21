package com.physics.quesbank.entity.systemUser;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName SystemUser
 * @Description TODO
 * @Author aron
 * @Date 2020/9/21 10:17
 **/
@Data
public class SystemUser {

    protected final static Logger logger = LoggerFactory.getLogger(SystemUser.class);

    private String id;
    private String user_name;
    private String password;
}

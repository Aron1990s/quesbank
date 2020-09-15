package com.physics.quesbank.entity.leftNav;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName BaseNav
 * @Description TODO
 * @Author aron
 * @Date 2020/9/15 10:01
 **/
@Data
public class BaseNav {

    protected final static Logger logger = LoggerFactory.getLogger(BaseNav.class);

    private String menuId;
    private String menuName;
    private String menuCode;
    private String menuAction;
}

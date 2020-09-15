package com.physics.quesbank.entity.leftNav;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @ClassName BaseNavElement
 * @Description TODO
 * @Author aron
 * @Date 2020/9/15 10:05
 **/
@Data
public class BaseNavElement {

    protected final static Logger logger = LoggerFactory.getLogger(BaseNavElement.class);

    private String menuId;
    private String menuName;
    private String menuCode;
    private String menuAction;
    private List<BaseNav> children;

}

package com.physics.quesbank.controller.system.index;

import com.physics.quesbank.controller.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author aron
 * @Date 2020/9/24 13:22
 **/
@Controller
@RequestMapping("mainCtl")
public class IndexController extends BaseController {

    protected final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    /**
     * 登录跳转的主页面
     * @return
     */
    @RequestMapping("index")
    public ModelAndView quesMainPage(){
        ModelAndView mv = new ModelAndView();
        String userName = getUserInfo().getUser_name();
        mv.addObject("user_name", userName);
        mv.setViewName("index/quesMainPage");
        return mv;
    }

}

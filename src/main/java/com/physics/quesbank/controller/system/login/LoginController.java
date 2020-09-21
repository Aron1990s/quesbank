package com.physics.quesbank.controller.system.login;

import com.physics.quesbank.entity.systemUser.SystemUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author aron
 * @Date 2020/9/21 11:05
 **/
@Controller
public class LoginController {

    protected final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login/loginTemp");
        return mv;
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(SystemUser user) {
        user.setPassword("123456");
        if (StringUtils.isEmpty(user.getUser_name()) || StringUtils.isEmpty(user.getPassword())) {
            return "请输入用户名和密码！";
        }
        //用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUser_name(),  user.getPassword());
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
        } catch (UnknownAccountException e) {
            logger.error("用户名不存在！", e);
            return "用户名不存在！";
        } catch (AuthenticationException e) {
            logger.error("账号或密码错误！", e);
            return "账号或密码错误！";
        } catch (AuthorizationException e) {
            logger.error("没有权限！", e);
            return "没有权限";
        }
        return "login success";
    }

}

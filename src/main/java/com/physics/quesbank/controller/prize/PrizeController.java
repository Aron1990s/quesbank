package com.physics.quesbank.controller.prize;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName PrizeController
 * @Description TODO
 * @Author aron
 * @Date 2020/9/24 10:01
 **/
@Controller
@RequestMapping("prizeCtl")
public class PrizeController {

    protected final static Logger logger = LoggerFactory.getLogger(PrizeController.class);

    public ModelAndView goToPrize(){
        ModelAndView mv = new ModelAndView();
        try{

        } catch (Exception e){
            e.printStackTrace();
        }
        mv.setViewName("prize/prize");
        return mv;
    }

}

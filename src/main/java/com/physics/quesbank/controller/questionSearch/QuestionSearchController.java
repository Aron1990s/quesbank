package com.physics.quesbank.controller.questionSearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName QuestionSearchController
 * @Description TODO
 * @Author aron
 * @Date 2020/9/24 13:28
 **/
@Controller
@RequestMapping("quesSearchCtl")
public class QuestionSearchController {

    protected final static Logger logger = LoggerFactory.getLogger(QuestionSearchController.class);

    /**
     * 物理题库检索
     * @return
     */
    @RequestMapping("highPhySearch")
    public ModelAndView search(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("questionSearch/questionSearch");
        return mv;
    }

}

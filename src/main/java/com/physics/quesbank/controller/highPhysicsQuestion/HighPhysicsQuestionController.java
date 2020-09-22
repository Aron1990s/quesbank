package com.physics.quesbank.controller.highPhysicsQuestion;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.physics.quesbank.constant.SessionConstant;
import com.physics.quesbank.controller.base.BaseController;
import com.physics.quesbank.dao.highPhysicsQuestion.HighPhysicsQuestionDao;
import com.physics.quesbank.entity.PagePlugin;
import com.physics.quesbank.entity.highPhysicsQuestion.HighPhysicsQuestion;
import com.physics.quesbank.entity.highPhysicsQuestion.HighPhysicsQuestionSearchCondition;
import com.physics.quesbank.service.highPhysiscQuestion.HighPhysicsQuestionService;
import com.physics.quesbank.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName HighPhysicsQuestionController
 * @Description TODO
 * @Author aron
 * @Date 2020/9/8 10:34
 **/
@Controller
@RequestMapping("highPhyQuesCtl")
public class HighPhysicsQuestionController extends BaseController {

    protected final static Logger logger = LoggerFactory.getLogger(HighPhysicsQuestionController.class);

    @Autowired
    private HighPhysicsQuestionService highPhysicsQuestionService;

    /**
     * 保存数据
     * @return
     */
    @RequestMapping(value = "saveHighPhysicsQuestion", method=RequestMethod.POST)
    @ResponseBody
    public Object saveHighPhysicsQuestion(HighPhysicsQuestion highPhysicsQuestion){
        Map<String, Object> map = new HashMap<>();
        try{
            highPhysicsQuestion.setQuestion_content(highPhysicsQuestion.getQuestion_content().replace("</em>", "</em>&nbsp;"));
            if (highPhysicsQuestion.getId() != null && !highPhysicsQuestion.getId().trim().equals("")) {
                highPhysicsQuestionService.editInfo(highPhysicsQuestion);
                map.put("code", "2");
            } else {
                highPhysicsQuestion.setId(getUUID());
                highPhysicsQuestion.setRecommend_count(0);
                highPhysicsQuestion.setRecord_time(DateUtil.getTime());
                highPhysicsQuestion.setRecord_teacher_id(getUserInfo().getId());
                highPhysicsQuestionService.saveInfo(highPhysicsQuestion);
                map.put("questionId", highPhysicsQuestion.getId());
                map.put("code", "1");
            }
        } catch (Exception e){
            e.printStackTrace();
            map.put("code", "-1");
        }
        return map;
    }

    /**
     * 设置session用以问题检索
     * @return
     */
    @RequestMapping("configQuestionSearch")
    @ResponseBody
    public Object configQuestionSearch(HighPhysicsQuestionSearchCondition condition){
        Map<String, Object> map = new HashMap<>();
        try{
            //初始化检索条件
            condition.setCurrent(1);
            //=初始化结束=
            //获取分页总页数
            PagePlugin pagePlugin = new PagePlugin(condition.getCurrent());
            Map<String, Object> pagePd = new HashMap<>();
            pagePlugin.setPd(pagePd);
            List<HighPhysicsQuestion> lists = highPhysicsQuestionService.listInfoByPage(pagePlugin);
            //==获取结束==
            map.put("code", "1");
            map.put("totalPages", pagePlugin.getPages());
            //=将查询条件存入session=
            getSession().setAttribute(SessionConstant.HIGH_PHYSICS_QUESTION_SEARCH_CONDITION, condition);
            //========存入结束======
        } catch (Exception e){
            e.printStackTrace();
            map.put("code", "-1");
        }
        return map;
    }

    /**
     * 调取分页数据
     * @param condition
     * @return
     */
    @RequestMapping("highPhysicsPagePlugin")
    @ResponseBody
    public Object highPhysicsPagePlugin(HighPhysicsQuestionSearchCondition condition){
        Map<String, Object> map = new HashMap<>();
        try{
            getHighPhysicsSearchCondition().setCurrent(condition.getCurrent());
            map.put("code", "1");
        } catch (Exception e){
            e.printStackTrace();
            map.put("code", "-1");
        }
        return map;
    }

    /**
     * 列表获取数据
     * @param highPhysicsQuestion
     * @return
     */
    @RequestMapping(value = "listInfo", method=RequestMethod.GET)
    public ModelAndView listInfo(HighPhysicsQuestion highPhysicsQuestion){
        ModelAndView mv = new ModelAndView();
        try{
            PagePlugin pagePlugin = new PagePlugin(getHighPhysicsSearchCondition().getCurrent());
            Map<String, Object> pagePd = new HashMap<>();
            pagePlugin.setPd(pagePd);
            List<HighPhysicsQuestion> lists = highPhysicsQuestionService.listInfoByPage(pagePlugin);
            for (HighPhysicsQuestion sub : lists) {
                if (sub.getSimple_answer() == null || sub.getSimple_answer().trim().equals("")) {
                    sub.setSimple_answer("<p>暂无解析</p>");
                }
            }
            mv.addObject("questionList", lists);
        } catch (Exception e){
            e.printStackTrace();
        }
        mv.setViewName("highPhysicsQuestion/highPhysicsQuestion");
        return mv;
    }
}

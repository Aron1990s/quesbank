package com.physics.quesbank.service.highPhysiscQuestion;

import com.physics.quesbank.dao.highPhysicsQuestion.HighPhysicsQuestionDao;
import com.physics.quesbank.entity.highPhysicsQuestion.HighPhysicsQuestion;
import com.physics.quesbank.service.baseService.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName HighPhysicsQuestionService
 * @Description TODO
 * @Author aron
 * @Date 2020/9/8 10:08
 **/
@Service
public class HighPhysicsQuestionService implements BaseService<HighPhysicsQuestion> {

    protected final static Logger logger = LoggerFactory.getLogger(HighPhysicsQuestionService.class);

    @Autowired
    private HighPhysicsQuestionDao highPhysicsQuestionDao;

    @Override
    public List<HighPhysicsQuestion> listInfo(HighPhysicsQuestion highPhysicsQuestion) {
        return highPhysicsQuestionDao.listInfo(highPhysicsQuestion);
    }

    @Override
    public int saveInfo(HighPhysicsQuestion highPhysicsQuestion) {
        return highPhysicsQuestionDao.saveInfo(highPhysicsQuestion);
    }

    @Override
    public int editInfo(HighPhysicsQuestion highPhysicsQuestion) {
        return 0;
    }

    @Override
    public HighPhysicsQuestion findById(HighPhysicsQuestion highPhysicsQuestion) {
        return null;
    }

    @Override
    public int delInfo(HighPhysicsQuestion highPhysicsQuestion) {
        return 0;
    }
}

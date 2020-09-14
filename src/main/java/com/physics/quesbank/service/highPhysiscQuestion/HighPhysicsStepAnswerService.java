package com.physics.quesbank.service.highPhysiscQuestion;

import com.physics.quesbank.dao.highPhysicsQuestion.HighPhysicsStepAnswerDao;
import com.physics.quesbank.entity.highPhysicsQuestion.HighPhysicsStepAnswer;
import com.physics.quesbank.service.baseService.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName HighPhysicsStepAnswerService
 * @Description TODO
 * @Author aron
 * @Date 2020/9/8 10:20
 **/
@Service
public class HighPhysicsStepAnswerService implements BaseService<HighPhysicsStepAnswer> {

    protected final static Logger logger = LoggerFactory.getLogger(HighPhysicsStepAnswerService.class);

    @Autowired
    private HighPhysicsStepAnswerDao dao;

    @Override
    public List<HighPhysicsStepAnswer> listInfo(HighPhysicsStepAnswer highPhysicsStepAnswer) {
        return dao.listInfo(highPhysicsStepAnswer);
    }

    @Override
    public int saveInfo(HighPhysicsStepAnswer highPhysicsStepAnswer) {
        return dao.saveInfo(highPhysicsStepAnswer);
    }

    @Override
    public int editInfo(HighPhysicsStepAnswer highPhysicsStepAnswer) {
        return 0;
    }

    @Override
    public HighPhysicsStepAnswer findById(HighPhysicsStepAnswer highPhysicsStepAnswer) {
        return null;
    }

    @Override
    public int delInfo(HighPhysicsStepAnswer highPhysicsStepAnswer) {
        return dao.delInfo(highPhysicsStepAnswer);
    }
}

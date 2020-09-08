package com.physics.quesbank.service.highPhysiscQuestion;

import com.physics.quesbank.dao.highPhysicsQuestion.HighPhysicsSimpleAnswerDao;
import com.physics.quesbank.entity.highPhysicsQuestion.HighPhysicsSimpleAnswer;
import com.physics.quesbank.service.baseService.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName HighPhysicsSimpleAnswerService
 * @Description TODO
 * @Author aron
 * @Date 2020/9/8 10:16
 **/
@Service
public class HighPhysicsSimpleAnswerService implements BaseService<HighPhysicsSimpleAnswer> {

    protected final static Logger logger = LoggerFactory.getLogger(HighPhysicsSimpleAnswerService.class);

    @Autowired
    private HighPhysicsSimpleAnswerDao dao;

    @Override
    public List<HighPhysicsSimpleAnswer> listInfo(HighPhysicsSimpleAnswer highPhysicsSimpleAnswer) {
        return dao.listInfo(highPhysicsSimpleAnswer);
    }

    @Override
    public int saveInfo(HighPhysicsSimpleAnswer highPhysicsSimpleAnswer) {
        return dao.saveInfo(highPhysicsSimpleAnswer);
    }

    @Override
    public int editInfo(HighPhysicsSimpleAnswer highPhysicsSimpleAnswer) {
        return 0;
    }

    @Override
    public HighPhysicsSimpleAnswer findById(HighPhysicsSimpleAnswer highPhysicsSimpleAnswer) {
        return null;
    }

    @Override
    public int delInfo(HighPhysicsSimpleAnswer highPhysicsSimpleAnswer) {
        return 0;
    }
}

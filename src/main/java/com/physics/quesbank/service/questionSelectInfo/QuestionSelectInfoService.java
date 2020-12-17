package com.physics.quesbank.service.questionSelectInfo;

import com.physics.quesbank.dao.questionSelectInfo.QuestionSelectInfoDao;
import com.physics.quesbank.entity.questionSelectInfo.QuestionSelectInfo;
import com.physics.quesbank.service.baseService.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName QuestionSelectInfoService
 * @Description TODO
 * @Author aron
 * @Date 2020/12/17 16:19
 **/
@Service
public class QuestionSelectInfoService implements BaseService<QuestionSelectInfo> {

    protected final static Logger logger = LoggerFactory.getLogger(QuestionSelectInfoService.class);

    @Autowired
    private QuestionSelectInfoDao dao;

    @Override
    public List<QuestionSelectInfo> listInfo(QuestionSelectInfo questionSelectInfo) {
        return dao.listInfo(questionSelectInfo);
    }

    @Override
    public int saveInfo(QuestionSelectInfo questionSelectInfo) {
        return dao.saveInfo(questionSelectInfo);
    }

    @Override
    public int editInfo(QuestionSelectInfo questionSelectInfo) {
        return 0;
    }

    @Override
    public QuestionSelectInfo findById(QuestionSelectInfo questionSelectInfo) {
        return dao.findById(questionSelectInfo);
    }

    @Override
    public int delInfo(QuestionSelectInfo questionSelectInfo) {
        return dao.delInfo(questionSelectInfo);
    }
}

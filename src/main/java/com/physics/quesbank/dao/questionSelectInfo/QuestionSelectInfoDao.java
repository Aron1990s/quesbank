package com.physics.quesbank.dao.questionSelectInfo;

import com.physics.quesbank.dao.baseMapper.BaseMapper;
import com.physics.quesbank.entity.highPhysicsQuestion.HighPhysicsQuestion;
import com.physics.quesbank.entity.questionSelectInfo.CurrentQuestionSelectInfo;
import com.physics.quesbank.entity.questionSelectInfo.QuestionSelectInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionSelectInfoDao extends BaseMapper<QuestionSelectInfo> {
    List<HighPhysicsQuestion> listCurrentQuestion(QuestionSelectInfo currentQuestionSelectInfo);
}

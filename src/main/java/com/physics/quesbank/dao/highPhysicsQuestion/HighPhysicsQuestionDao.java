package com.physics.quesbank.dao.highPhysicsQuestion;

import com.physics.quesbank.dao.baseMapper.BaseMapper;
import com.physics.quesbank.entity.PagePlugin;
import com.physics.quesbank.entity.highPhysicsQuestion.HighPhysicsQuestion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HighPhysicsQuestionDao extends BaseMapper<HighPhysicsQuestion> {

    List<HighPhysicsQuestion> listInfoByPage(PagePlugin page);
}

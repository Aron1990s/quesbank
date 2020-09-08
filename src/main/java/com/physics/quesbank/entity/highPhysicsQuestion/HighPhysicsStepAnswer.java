package com.physics.quesbank.entity.highPhysicsQuestion;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName HighPhysicsStepAnswerDao
 * @Description TODO
 * @Author aron
 * @Date 2020/9/8 9:52
 **/
@Data
public class HighPhysicsStepAnswer {

    protected final static Logger logger = LoggerFactory.getLogger(HighPhysicsStepAnswer.class);

    private String id;
    private String question_id;
    private int step;
    private String detail_answer;


}

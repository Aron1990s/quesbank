package com.physics.quesbank.entity.highPhysicsQuestion;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName HighPhysicsSimpleAnswer
 * @Description TODO
 * @Author aron
 * @Date 2020/9/8 9:52
 **/
@Data
public class HighPhysicsSimpleAnswer {

    protected final static Logger logger = LoggerFactory.getLogger(HighPhysicsSimpleAnswer.class);

    private String id;
    private String simple_answer;
    private String question_id;


}

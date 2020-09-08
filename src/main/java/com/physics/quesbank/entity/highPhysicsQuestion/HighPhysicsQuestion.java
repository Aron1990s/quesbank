package com.physics.quesbank.entity.highPhysicsQuestion;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName HighPhysicsQuestion
 * @Description TODO
 * @Author aron
 * @Date 2020/9/8 9:52
 **/
@Data
public class HighPhysicsQuestion {

    protected final static Logger logger = LoggerFactory.getLogger(HighPhysicsQuestion.class);

    private String id;
    private String question_type;
    private String question_content;
    private int grade_id;
    private int chapter_id;
    private int chapter_sub_id;
    private int chapter_sub_item_id;
    private String status;
    private int recommend_count;
    private String record_time;
    private String record_teacher_id;


}

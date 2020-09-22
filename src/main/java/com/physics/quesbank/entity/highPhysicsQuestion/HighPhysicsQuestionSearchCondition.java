package com.physics.quesbank.entity.highPhysicsQuestion;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName HighPhysicsQuestionSearchCondition
 * @Description TODO
 * @Author aron
 * @Date 2020/9/22 9:56
 **/
@Data
public class HighPhysicsQuestionSearchCondition {

    //当前页码
    private int current;
    //当前检索总页数
    private int total;
    //章节ID
    private int major_sub_id;
    //章节知识点
    private int major_sub_item_id;
    //题目类型
    private String question_type;


}

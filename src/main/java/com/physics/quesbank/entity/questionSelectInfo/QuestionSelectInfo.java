package com.physics.quesbank.entity.questionSelectInfo;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;

/**
 * @ClassName QuestionSelectInfo
 * @Description TODO
 * @Author aron
 * @Date 2020/12/17 16:17
 **/
@Data
public class QuestionSelectInfo {

    protected final static Logger logger = LoggerFactory.getLogger(QuestionSelectInfo.class);

    private BigInteger id;
    private String user_id;
    private String question_type;
    private String question_id;
    private String add_time;
    private String question_content;

}

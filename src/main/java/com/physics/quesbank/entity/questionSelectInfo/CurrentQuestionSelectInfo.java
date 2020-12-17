package com.physics.quesbank.entity.questionSelectInfo;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName CurrentQuestionSelectInfo
 * @Description TODO
 * @Author aron
 * @Date 2020/12/17 16:50
 **/
@Data
public class CurrentQuestionSelectInfo {

    private int currentCount;

    private Map<BigInteger, Object> map = new HashMap<>();
}

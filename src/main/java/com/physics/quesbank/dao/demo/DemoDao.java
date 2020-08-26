package com.physics.quesbank.dao.demo;

import com.physics.quesbank.entity.demo.Demo;
import org.apache.ibatis.annotations.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @ClassName DemoDao
 * @Description TODO
 * @Author aron
 * @Date 2020/8/18 16:50
 **/
@Mapper
public interface DemoDao {

    int saveInfo(Demo demo);

    List<Demo> getInfo();

    public List<Demo> getAnswer(Demo demo);

}

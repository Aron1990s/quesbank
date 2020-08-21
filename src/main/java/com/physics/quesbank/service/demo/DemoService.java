package com.physics.quesbank.service.demo;

import com.physics.quesbank.dao.demo.DemoDao;
import com.physics.quesbank.entity.demo.Demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DemoService
 * @Description TODO
 * @Author aron
 * @Date 2020/8/18 16:51
 **/
@Service
public class DemoService {

    protected final static Logger logger = LoggerFactory.getLogger(DemoService.class);


    @Autowired
    private DemoDao dao;

    public int saveInfo(Demo demo){
        return dao.saveInfo(demo);
    }

    public List<Demo> getInfo(){
        return dao.getInfo();
    }
}

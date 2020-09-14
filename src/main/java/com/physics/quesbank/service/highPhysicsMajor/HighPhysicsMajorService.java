package com.physics.quesbank.service.highPhysicsMajor;

import com.physics.quesbank.dao.highPhysicsMajor.HighPhysicsMajorDao;
import com.physics.quesbank.entity.highPhysicsMajor.HighPhysicsMajor;
import com.physics.quesbank.entity.highPhysicsMajor.HighPhysicsMajorSub;
import com.physics.quesbank.entity.highPhysicsMajor.HighPhysicsMajorSubItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName HighPhysicsMajorService
 * @Description TODO
 * @Author aron
 * @Date 2020/9/14 10:21
 **/
@Service
public class HighPhysicsMajorService {

    protected final static Logger logger = LoggerFactory.getLogger(HighPhysicsMajorService.class);

    @Autowired
    private HighPhysicsMajorDao dao;

    public List<HighPhysicsMajor> listHighPhysicsMajor(){
        return dao.listHighPhysicsMajor();
    }

    public List<HighPhysicsMajorSub> listHighPhysicsMajorSub(HighPhysicsMajor highPhysicsMajor){
        return dao.listHighPhysicsMajorSub(highPhysicsMajor);
    }

    public List<HighPhysicsMajorSubItem> listHighPhysicsMajorSubItem(HighPhysicsMajorSubItem highPhysicsMajorSubItem){
        return dao.listHighPhysicsMajorSubItem(highPhysicsMajorSubItem);
    }

}

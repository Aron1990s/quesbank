package com.physics.quesbank.service.highPhysicsMajor;

import com.physics.quesbank.dao.highPhysicsMajor.HighPhysicsMajorSubItemDao;
import com.physics.quesbank.entity.highPhysicsMajor.HighPhysicsMajorSubItem;
import com.physics.quesbank.service.baseService.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName HighPhysicsMajorSubItemService
 * @Description TODO
 * @Author aron
 * @Date 2020/9/11 17:08
 **/
@Service
public class HighPhysicsMajorSubItemService implements BaseService<HighPhysicsMajorSubItem> {

    protected final static Logger logger = LoggerFactory.getLogger(HighPhysicsMajorSubItemService.class);

    @Autowired
    private HighPhysicsMajorSubItemDao dao;

    @Override
    public List<HighPhysicsMajorSubItem> listInfo(HighPhysicsMajorSubItem highPhysicsMajorSubItem) {
        return null;
    }

    @Override
    public int saveInfo(HighPhysicsMajorSubItem highPhysicsMajorSubItem) {
        return dao.saveInfo(highPhysicsMajorSubItem);
    }

    @Override
    public int editInfo(HighPhysicsMajorSubItem highPhysicsMajorSubItem) {
        return 0;
    }

    @Override
    public HighPhysicsMajorSubItem findById(HighPhysicsMajorSubItem highPhysicsMajorSubItem) {
        return null;
    }

    @Override
    public int delInfo(HighPhysicsMajorSubItem highPhysicsMajorSubItem) {
        return 0;
    }
}

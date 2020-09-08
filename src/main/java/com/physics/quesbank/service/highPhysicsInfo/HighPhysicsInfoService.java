package com.physics.quesbank.service.highPhysicsInfo;

import com.physics.quesbank.dao.highPhysicsInfo.HighPhysicsInfoDao;
import com.physics.quesbank.entity.highPhysicsInfo.HighChapterInfo;
import com.physics.quesbank.entity.highPhysicsInfo.HighChapterSubInfo;
import com.physics.quesbank.entity.highPhysicsInfo.HighChapterSubItemInfo;
import com.physics.quesbank.entity.highPhysicsInfo.HighGradeInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName highPhysicsInfo
 * @Description TODO
 * @Author aron
 * @Date 2020/9/2 17:03
 **/
@Service
public class HighPhysicsInfoService {

    protected final static Logger logger = LoggerFactory.getLogger(HighPhysicsInfoService.class);

    @Autowired
    private HighPhysicsInfoDao highPhysicsInfoDao;

    public List<HighGradeInfo> listHighGradeInfo(){
        return highPhysicsInfoDao.listHighGradeInfo();
    }

    public List<HighChapterInfo> listHighChapterInfo(HighGradeInfo highGradeInfo){
        return highPhysicsInfoDao.listHighChapterInfo(highGradeInfo);
    }

    public List<HighChapterSubInfo> listHighChapterSubInfo(HighChapterInfo highChapterInfo){
        return highPhysicsInfoDao.listHighChapterSubInfo(highChapterInfo);
    }

    public List<HighChapterSubItemInfo> listHighChapterSubItemInfo(HighChapterSubInfo highChapterSubInfo){
        return highPhysicsInfoDao.listHighChapterSubItemInfo(highChapterSubInfo);
    }
}

package com.physics.quesbank.dao.highPhysicsInfo;

import com.physics.quesbank.entity.HighPhysicsInfo.*;
import org.apache.ibatis.annotations.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @ClassName HighPhysicsInfoDao
 * @Description TODO
 * @Author aron
 * @Date 2020/9/2 16:54
 **/
@Mapper
public interface HighPhysicsInfoDao {

    List<HighGradeInfo> listHighGradeInfo();

    List<HighChapterInfo> listHighChapterInfo(HighGradeInfo highGradeInfo);

    List<HighChapterSubInfo> listHighChapterSubInfo(HighChapterInfo highChapterInfo);

    List<HighChapterSubItemInfo> listHighChapterSubItemInfo(HighChapterSubInfo highChapterSubInfo);

}

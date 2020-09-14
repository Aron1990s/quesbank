package com.physics.quesbank.dao.highPhysicsMajor;

import com.physics.quesbank.entity.highPhysicsMajor.HighPhysicsMajor;
import com.physics.quesbank.entity.highPhysicsMajor.HighPhysicsMajorSub;
import com.physics.quesbank.entity.highPhysicsMajor.HighPhysicsMajorSubItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HighPhysicsMajorDao {

    List<HighPhysicsMajor> listHighPhysicsMajor();

    List<HighPhysicsMajorSub> listHighPhysicsMajorSub(HighPhysicsMajor highPhysicsMajor);

    List<HighPhysicsMajorSubItem> listHighPhysicsMajorSubItem(HighPhysicsMajorSubItem highPhysicsMajorSubItem);
}

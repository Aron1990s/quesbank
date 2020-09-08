package com.physics.quesbank.dao.baseMapper;

import java.util.List;

/**
 * @ClassName BaseMapper
 * @Description TODO
 * @Author aron
 * @Date 2020/9/8 9:57
 **/
public interface BaseMapper<E> {

    List<E> listInfo(E e);
    int saveInfo(E e);
    int editInfo(E e);
    E findById(E e);
    int delInfo(E e);

}

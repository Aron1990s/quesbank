package com.physics.quesbank.service.baseService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @ClassName BaseService
 * @Description TODO
 * @Author aron
 * @Date 2020/9/8 10:04
 **/
public interface BaseService<E> {

    List<E> listInfo(E e);
    int saveInfo(E e);
    int editInfo(E e);
    E findById(E e);
    int delInfo(E e);

}

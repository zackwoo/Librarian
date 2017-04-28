package com.github.librarian.service.convert;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by zack.wu on 2017/4/28.
 */
public interface IBeanConvert {
    Object Convert(Object source,Class targetClass) throws IllegalAccessException, InstantiationException, InvocationTargetException;
    List Convert(List source, Class targetClass) throws IllegalAccessException, InstantiationException, InvocationTargetException;
}

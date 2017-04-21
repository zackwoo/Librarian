package com.github.librarian.service.convert;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zack.wu on 2017/4/20.
 */
@Component("GeneralConvert")
public class GeneralBeanConvert {
    public  Object Convert(Object source,Class targetClass) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object target = targetClass.newInstance();
        BeanUtils.copyProperties(target,source);
        return  target;
    }

    public List Convert(List source, Class targetClass) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        ArrayList arrayList = new ArrayList();
        for (Object item : source){
            arrayList.add(Convert(item,targetClass));
        }
        return  arrayList;
    }
}

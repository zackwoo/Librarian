package com.github.librarian.service.convert;

import com.github.librarian.model.entity.Borrower;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by zachary on 2017/4/21.
 */
@Component("BorrowerDto2EntityConvert")
public class BorrowerDto2EntityConvert extends GeneralBeanConvert {
    @Override
    public Object Convert(Object source, Class targetClass) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Borrower target =(Borrower) super.Convert(source, targetClass);
        target.setPassword("5566");
        return target;
    }
}

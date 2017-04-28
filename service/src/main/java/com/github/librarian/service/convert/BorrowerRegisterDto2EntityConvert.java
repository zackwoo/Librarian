package com.github.librarian.service.convert;

import com.github.librarian.model.entity.Borrower;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by zachary on 2017/4/21.
 */
@Component
public class BorrowerRegisterDto2EntityConvert extends BeanConvertAbs {
    @Override
    public Object Convert(Object source, Class targetClass) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Borrower borrower = (Borrower) super.Convert(source, targetClass);
         borrower.setStatus(1);
         return borrower;
    }
}

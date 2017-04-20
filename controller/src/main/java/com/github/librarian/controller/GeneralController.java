package com.github.librarian.controller;

import com.github.librarian.config.SpringContextUtils;
import com.github.librarian.model.entity.BorrowerExample;
import com.github.librarian.model.mapper.BookMapper;
import com.github.librarian.model.mapper.BorrowerMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.apache.commons.beanutils.MethodUtils;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by zack.wu on 2017/4/19.
 */
@RestController
@RequestMapping("/api/general")
@Api(value = "通用服务类",description = "通用服务controller")
public class GeneralController {

    @GetMapping("/")
    private Object GetItem(@ApiParam(defaultValue = "Borrower") @RequestParam String mapperClass, @ApiParam(defaultValue = "{IdEqualTo:1}") Map<String,Object> map)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String mapperClassName = "com.github.librarian.model.mapper."+mapperClass+"Mapper";
        String exampleClassName = "com.github.librarian.model.entity."+mapperClass+"Example";
        Class<?> aClass = Class.forName(mapperClassName);
        Object mapper = SpringContextUtils.getBeanByClass(aClass);

        Object example = Class.forName(exampleClassName).newInstance();
        Object criteria = MethodUtils.invokeMethod(example,"or",null);
        MethodUtils.invokeMethod(criteria,"andMap",map);
        return MethodUtils.invokeMethod(mapper,"selectByExample",example);
        
    }
}

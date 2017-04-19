package com.github.librarian.controller;

import com.github.librarian.config.SpringContextUtils;
import com.github.librarian.model.entity.BookExample;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zack.wu on 2017/4/19.
 */
@RestController
@RequestMapping("/api/general")
@Api(value = "通用服务类",description = "通用服务controller")
public class GeneralController {

    @GetMapping("/")
    private void GetItem(String mapperClass,Object id) throws ClassNotFoundException {
        String className = "com.github.librarian.model.mapper."+mapperClass+"Mapper";
        Class<?> aClass = Class.forName(className);
        Object mapper = SpringContextUtils.getBeanByClass(aClass);

        BookExample bookExample = new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
         //criteria.andMap();
        
    }
}

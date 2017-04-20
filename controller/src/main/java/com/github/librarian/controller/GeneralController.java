package com.github.librarian.controller;

import com.alibaba.fastjson.JSON;
import com.github.librarian.service.common.GeneralService;
import com.github.librarian.service.common.SpringContextUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.apache.commons.beanutils.MethodUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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

    @Autowired
    private GeneralService generalService;
    @GetMapping("/")
    private Object GetItem(@ApiParam(defaultValue = "borrower") @RequestParam String mapperClass, @RequestParam @ApiParam(defaultValue = "{IdEqualTo:1,pageNumber:1}") String map)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return  generalService.selectByExample(mapperClass, JSON.parseObject(map));
    }
}

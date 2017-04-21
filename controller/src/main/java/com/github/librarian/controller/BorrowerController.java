package com.github.librarian.controller;

import com.alibaba.fastjson.JSON;
import com.github.librarian.service.common.GeneralService;
import com.github.librarian.service.dto.BorrowerDto;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by zachary on 2017/4/20.
 */

@RestController
@RequestMapping("/api/Borrower")
@Api(value = "借阅者管理类")
public class BorrowerController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GeneralService generalService;


    @GetMapping("/")
    private PageInfo<BorrowerDto> queryBorrower(@RequestParam @ApiParam(defaultValue = "{pageNumber:1,NameLike:'%a%'}") String mapJson)
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        logger.info("controller 参数："+ mapJson);
        Map map = JSON.parseObject(mapJson, Map.class);

        return (PageInfo<BorrowerDto>) generalService.selectByExample("borrower", map);
    }

    @PostMapping("/")
    private int addBorrower(@RequestBody BorrowerDto dto) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return  generalService.insert("borrower", dto,"BorrowerDto2EntityConvert");
    }


}

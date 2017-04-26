package com.github.librarian.controller;

import com.alibaba.fastjson.JSON;
import com.github.librarian.service.common.GeneralService;
import com.github.librarian.service.dto.BorrowerDto;
import com.github.librarian.service.dto.BorrowerRegisterDto;
import com.github.librarian.service.interfaces.IBorrowerService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @Autowired
    private IBorrowerService borrowerService;


    @GetMapping("/")
    @ApiOperation(value = "管理员查看当前借阅者借阅状态")
    private PageInfo<BorrowerDto> queryBorrower(@RequestParam @ApiParam(defaultValue = "{pageNumber:1,NameLike:\"%a%\"}") String mapJson)
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        logger.info("controller 参数："+ mapJson);
        Map map = JSON.parseObject(mapJson, Map.class);

        return (PageInfo<BorrowerDto>) generalService.selectByExample("borrower", map,BorrowerDto.class);

    }

    @PostMapping("/register")
    @ApiOperation(value = "借阅者注册")
    private int addBorrower(@RequestBody BorrowerRegisterDto dto) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return  generalService.insert("borrower", dto,"BorrowerRegisterDto2EntityConvert");
    }

    @PutMapping("/ban")
    @ApiOperation(value = "冻结借阅者")
    private boolean ban(@RequestBody Integer borrowerId){
        return borrowerService.ban(borrowerId);
    }

    @PutMapping("/enable")
    @ApiOperation(value = "解冻借阅者")
    private boolean enable(@RequestBody Integer borrowerId){
        return borrowerService.enable(borrowerId);
    }

}

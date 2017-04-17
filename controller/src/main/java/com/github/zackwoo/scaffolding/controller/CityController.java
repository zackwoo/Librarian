package com.github.zackwoo.scaffolding.controller;

import com.github.pagehelper.PageInfo;
import com.github.zackwoo.scaffolding.service.dto.CityDto;
import com.github.zackwoo.scaffolding.service.interfaces.ICityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zack.wu on 2017/4/11.
 */
@RestController()
@RequestMapping(path = "/api/city", produces = "application/json")
@Api(description = "城市相关业务逻辑")
public class CityController {
    @Autowired
    private ICityService _service;

    @ApiOperation(value = "根据国家编号查城市列表", notes = "pageNum从1开始")
    @GetMapping("cityByCountryCode")
    public PageInfo cityByCountryCode(@RequestParam String code ,@RequestParam int pageNum,@RequestParam int pageSize){
        return  _service.queryCityByCountryCode(code,pageNum,pageSize);
    }
}

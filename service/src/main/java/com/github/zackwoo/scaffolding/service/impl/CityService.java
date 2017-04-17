package com.github.zackwoo.scaffolding.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.zackwoo.scaffolding.entity.City;
import com.github.zackwoo.scaffolding.entity.CityExample;
import com.github.zackwoo.scaffolding.mapper.CityMapper;
import com.github.zackwoo.scaffolding.service.interfaces.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zack.wu on 2017/4/11.
 */
@Component
public class CityService implements ICityService {
    @Autowired
    private CityMapper _cityMapper;

    public PageInfo queryCityByCountryCode(String code, int pageNumber, int pageSize) {
        CityExample cityExample = new CityExample();
        cityExample.createCriteria().andCountrycodeEqualTo(code);


        PageHelper.startPage(pageNumber,pageSize);//设置分页信息
        List<City> cities = _cityMapper.selectByExample(cityExample);
       return new PageInfo(cities); // 获取分页信息
    }
}

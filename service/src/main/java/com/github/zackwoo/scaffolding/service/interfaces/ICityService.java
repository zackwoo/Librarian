package com.github.zackwoo.scaffolding.service.interfaces;

import com.github.pagehelper.PageInfo;
import com.github.zackwoo.scaffolding.service.dto.CityDto;

import java.util.List;

/**
 * Created by zack.wu on 2017/4/11.
 */
public interface ICityService {
    PageInfo<CityDto> queryCityByCountryCode(String code, int pageNumber, int pageSize);
}

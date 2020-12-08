package com.sxp.service;


import com.sxp.entity.City;

import java.util.List;

/**
 * @Author: likang
 * @Date: 2019/11/7 10:46
 * @Description: 城市信息接口--服务层
 */
public interface ICityService {

    /**
     * @Description: 查询所有的城市
     * @Author: likang
     * @Date: 2019/11/7 10:53
     * @Param: []
     * @Return: java.util.List<com.xdl.entity.City>
     * @Exception:
     */
    List<City> supportCities();

    /**
     * @Description: 根据城市简称，查询城市下对应的区县
     * @Author: likang
     * @Date: 2019/11/7 15:21
     * @Param: [city_name]
     * @Return: java.util.List<com.xdl.entity.City>
     * @Exception:
     */
    List<City> queryRegionBycname(String city_name);
}

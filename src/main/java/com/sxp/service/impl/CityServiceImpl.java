package com.sxp.service.impl;

import com.sxp.dao.CityDAO;
import com.sxp.entity.City;
import com.sxp.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements ICityService {

    @Autowired
    CityDAO cityDAO;


    @Override
    public List<City> supportCities() {
        return cityDAO.supportCities();
    }

    @Override
    public List<City> queryRegionBycname(String city_name) {
        return cityDAO.queryRegionBycname(city_name);
    }
}

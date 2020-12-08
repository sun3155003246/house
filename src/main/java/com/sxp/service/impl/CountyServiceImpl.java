package com.sxp.service.impl;

import com.sxp.dao.CountyDAO;
import com.sxp.entity.City;
import com.sxp.service.CountyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountyServiceImpl implements CountyService {

    @Autowired
    CountyDAO countyDAO;
    @Override
    public List<City> supportCounty(String city_name) {
        return countyDAO.supportCounty(city_name);
    }
}

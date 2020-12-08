package com.sxp.dao;

import com.sxp.entity.City;

import java.util.List;

public interface CountyDAO {
    List<City> supportCounty(String city_name);
}

package com.sxp.entity;

import lombok.Data;

/**
 * @Author: likang
 * @Date: 2019/5/22 11:42
 * @Description: 城市
 */
@Data
public class City {

    private int cityId;//城市ID
    private String belongTo;//上一级行政单位名
    private String enName;//行政单位英文名缩写
    private String cnName;//行政单位中文名
    private String level;//行政级别 市-city 地区-region
    private double baidu_map_lng;//百度地图经度
    private double baidu_map_lat;//百度地图纬度

}

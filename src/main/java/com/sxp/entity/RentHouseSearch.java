package com.sxp.entity;

import lombok.Data;

/**
 * @Author: likang
 * @Date: 2019/9/27 8:52
 * @Description: 封装租房信息筛选条件
 */
@Data
public class RentHouseSearch {

    private String cityEnName;//城市
    private String regionEnName;//区域
    private String priceBlock;//价格区间
    private String areaBlock;//面积区间
    private int room;//卧室数量
    private int direction;//房屋朝向
    private String keywords;//关键词
    private int rentWay = -1;//地铁线路
    private String orderBy = "lastUpdateTime";//默认排序字段
    private String orderDirection = "asc";//排序方式

    //默认分页条件
    private int start = 0;
    private int size = 5;

}

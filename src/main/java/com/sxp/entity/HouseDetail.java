package com.sxp.entity;

import lombok.Data;

/**
 * @Author: likang
 * @Date: 2019/5/21 17:58
 * @Description: 房屋详细信息
 */
@Data
public class HouseDetail {

    private int houseDetailId;//房屋详细ID
    private String description;//详细描述
    private String layoutDesc;//户型介绍
    private String traffic;//交通出行
    private String roundService;//周边配套
    private int rentWay;//租赁方式
    private String address;//详细地址
    private int subwayId;//附近地铁线id
    private String subwayName;//附近地铁线名称
    private int subwayStationId;//地铁站id
    private String subwayStationName;//地铁站名
    private Long houseId;//对应house的id

}

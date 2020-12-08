package com.sxp.entity;

import lombok.Data;

/**
 * @Author: likang
 * @Date: 2019/8/26 9:03
 * @Description: 地铁站实体对象
 */
@Data
public class Subway_station {

    private Long subwayStationId;//主键ID
    private Long subwayId;//所属地铁线id
    private String subwayStationName;//站点名称


}

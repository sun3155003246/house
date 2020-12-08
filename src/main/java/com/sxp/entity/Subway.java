package com.sxp.entity;


import lombok.Data;
/**
 * @Author: likang
 * @Date: 2019/8/26 8:57
 * @Description: 地铁线实体对象
 */
@Data
public class Subway {

    private Long subwayId;//地铁线主键ID
    private String subwayName;//地铁线名称
    private String cityEnName;//所属城市简称
}

package com.sxp.entity;

import lombok.Data;

/**
 * @Author: likang
 * @Date: 2019/5/22 11:40
 * @Description: 房屋标签
 */
@Data
public class HouseTag {

    private int housetagId;//标签id
    private Long houseId;//房屋id
    private String tagName;//标签名称


}

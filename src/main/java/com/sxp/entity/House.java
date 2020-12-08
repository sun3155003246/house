package com.sxp.entity;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @Author: likang
 * @Date: 2019/5/21 17:34
 * @Description: 房屋信息
 */

@Data
public class House {

    private Long houseId;//房屋ID

    //NotNull：当前对象在数据封装的时候，当前带有此注解，则不能为空,如果为空，则提示message信息
    @NotNull(message = "大标题不允许为空!")
    //Size：字段长度限制
    @Size(min = 1, max = 30, message = "标题长度必须在1~30之间")
    private String title;//大标题

    @NotNull(message = "必须填写租赁价格")
    @Min(value = 1)
    private int price;//价格

    @NotNull(message = "必须填写面积")
    private float area;//面积

    @NotNull(message = "必须填写卧室数量")
    @Min(value = 1, message = "非法的卧室数量")
    private int room;//卧室数量

    @NotNull(message = "必须填写所属楼层")
    private int floor;//楼层

    @NotNull(message = "必须填写总楼层")
    private int totalFloor;//总楼层
    private int watchTimes;//被看次数

    @NotNull(message = "必须填写建筑起始时间")
    @Min(value = 1900, message = "非法的建筑起始时间")
    private int buildYear;//建立年限
    private int status;//房屋状态 0-未审核 1-审核通过 2-已出租 3-逻辑删除
    private Date createTime;//创建时间
    private Date lastUpdateTime;//最近数据更新时间

    @NotNull(message = "必须选中一个城市")
    @Size(min = 1, message = "非法的城市")
    private String cityEnName;//城市标记缩写 如:bj

    @NotNull(message = "必须选中一个地区")
    @Size(min = 1, message = "非法的地区")
    private String regionEnName;//地区英文简写 如:昌平区 cpq
    private String cover;//封面

    @NotNull(message = "必须填写房屋朝向")
    private int direction;//房屋朝向
    private int distanceToSubway;//距地铁距离 默认-1 附近无地铁
    private int parlour;//客厅数量

    @NotNull(message = "必须填写小区")
    private String district;//所在小区
    private String adminId;//所属管理员id
    private int bathroom;

    @NotNull(message = "必须填写街道")
    @Size(min = 1, message = "非法的街道")
    private String street;//街道
    private String houseCode;//房本(唯一认证标识)


//    private HouseDetail houseDetail;//房屋详细信息

    @Size(max = 255)
    private String description;//详细描述
    private String layoutDesc;//户型介绍
    private String traffic;//交通出行
    private String roundService;//周边配套

    @NotNull(message = "必须选中一个租赁方式")
    @Min(value = 0)
    @Max(value = 1)
    private int rentWay;//租赁方式

    @NotNull(message = "详细地址不允许为空!")
    @Size(min = 1, max = 30, message = "详细地址长度必须在1~30之间")
    private String address;//详细地址
    private int subwayId;//附近地铁线id
    private String subwayName;//附近地铁线名称
    private int subwayStationId;//地铁站id
    private String subwayStationName;//地铁站名


    private HouseDetail houseDetail;

    private List<HousePicture> photos;//房屋图片

    private List<HouseTag> houseTags;

    private List<String> tags;//房屋标签名称


    private int subscribeStatus;//预约状态 1-加入待看清单 2-已预约看房时间 3-看房完成



}

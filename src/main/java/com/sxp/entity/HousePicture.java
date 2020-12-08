package com.sxp.entity;

import lombok.Data;

/**
 * @Author: likang
 * @Date: 2019/5/21 18:02
 * @Description: 房屋图片
 */
@Data
public class HousePicture {

    private int housePictureId;//房屋图片ID
    private Long houseId;//所属房屋ID
    private String cdnPrefix;//图片路径
    private int width;//宽
    private int height;//高
    private String location;//所属房屋位置
    private String path;//文件名

}

package com.sxp.entity;

import lombok.Data;

/**
 * @Author: likang
 * @Date: 2019/9/24 14:27
 * @Description: 封装七牛上传之后的对象数据,json格式
 */
@Data
public class QiNiuPutRet {

    public String hash;
    public String key;
    public String bucket;

    public int width;
    public int height;


}

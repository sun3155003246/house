package com.sxp.service;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;

import java.io.InputStream;

/**
 * 七牛云服务层
 */
public interface IQiNiuService {

    Response uploadImages(InputStream fileInputStream) throws QiniuException;
}

package com.sxp.service.impl;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.sxp.service.IQiNiuService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
@Service
public class QiNiuServiceImpl implements IQiNiuService,InitializingBean {

    @Autowired
    UploadManager uploadManager;

    @Autowired
    Auth auth;

    @Value("${qiniu.bucket}")
    String bucket;
    StringMap putPolicy;
    @Override
    public Response uploadImages(InputStream fileInputStream) throws QiniuException {
        //获取连接、上传文件
        // String key = null;//默认不指定key的情况下，以文件内容的hash值作为文件名
        Response response = uploadManager.put(fileInputStream,null,getToken(),null, null);
        //安全规则：
        //建立的都是第三方调用服务---http请求---网络---连接超时问题---本系统、第三方
        //needRetry:七牛云安全调用API，目的：判断是否继续发生下一次
        int n = 0;
        while (response.needRetry() &&  n++ < 3){
            response = uploadManager.put(fileInputStream,null,getToken(),null, null);
        }

        return response;
    }
    public String getToken() {
        return  auth.uploadToken(bucket);
    }
    /**
     * @Description: 只要是实现了InitializingBean接口，则执行完当前类中任意一个方法，则必须执行以下API
     * @Author: likang
     * @Date: 2019/11/7 16:45
     * @Param: []
     * @Return: void
     * @Exception:
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        putPolicy = new StringMap();
        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"width\":$(imageInfo.width), \"height\":${imageInfo.height}}");
    }
}

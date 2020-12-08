package com.sxp.utils;

import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HouseBeanUits {

    @Value("${qiniu.accessKey}")
    String accessKey;//公钥
    @Value("${qiniu.secretKey}")
    String secretKey;//私钥

    /**
     * @Description: 初始化七牛云连接
     * @Author: likang
     * @Date: 2019/11/7 16:17
     * @Param: []
     * @Return: com.qiniu.storage.UploadManager
     * @Exception:
     */
    @Bean
    public UploadManager uploadManager(){
        return new UploadManager(configuration());
    }

    /**
     * @Description: 七牛云机房信息
     * @Author: likang
     * @Date: 2019/11/7 16:20
     * @Param: []
     * @Return: com.qiniu.storage.Configuration
     * @Exception:
     */
    @Bean
    public com.qiniu.storage.Configuration configuration(){
        return new com.qiniu.storage.Configuration(Region.region2());
    }


    @Bean
    public Auth auth(){
        return Auth.create(accessKey, secretKey);
    }

}

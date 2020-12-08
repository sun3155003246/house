package com.sxp.service;


import com.sxp.entity.House;
import com.sxp.utils.ServiceResult;


/**
 * @Author: likang
 * @Date: 2019/11/8 10:51
 * @Description: 房屋信息接口---服务层
 */

public interface IHouseService {


    /**
    * @Description: 保存房屋信息
    * @Author: likang
    * @Date: 2019/11/8 10:57
    * @Param: [house]
    * @Return: com.xdl.utils.ServiceResult
    * @Exception:
    */
    ServiceResult saveHouse(House house);


}

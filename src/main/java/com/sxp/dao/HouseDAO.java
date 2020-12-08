package com.sxp.dao;

import com.sxp.entity.House;
import com.sxp.entity.HouseDetail;
import com.sxp.entity.HousePicture;
import com.sxp.entity.HouseTag;


import java.util.List;

/**
 * @Author: likang
 * @Date: 2019/11/8 11:04
 * @Description: 房屋信息---持久化层
 */
public interface HouseDAO {

    /**
    * @Description: 保存房屋信息
    * @Author: likang
    * @Date: 2019/11/8 11:06
    * @Param: [house]
    * @Return: void
    * @Exception:
    */
    void saveHouse(House house);

    /**
    * @Description: 保存房屋详情信息
    * @Author: likang
    * @Date: 2019/11/8 11:55
    * @Param: [houseDetail]
    * @Return: void
    * @Exception:
    */
    void saveHouseDetail(HouseDetail houseDetail);

    /**
    * @Description: 保存房屋标签信息
    * @Author: likang
    * @Date: 2019/11/8 14:09
    * @Param: [houseTagList]
    * @Return: void
    * @Exception:
    */
    void saveHouseTags(List<HouseTag> houseTagList);

    /**
    * @Description: 批量保存图片信息
    * @Author: likang
    * @Date: 2019/11/8 14:26
    * @Param: [housePhotos]
    * @Return: void
    * @Exception:
    */
    void saveHousePictures(List<HousePicture> housePhotos);
}

package com.sxp.service.impl;


import com.sxp.dao.HouseDAO;
import com.sxp.entity.House;
import com.sxp.entity.HouseDetail;
import com.sxp.entity.HousePicture;
import com.sxp.entity.HouseTag;
import com.sxp.service.IHouseService;
import com.sxp.utils.ServiceResult;
import com.sxp.utils.UserInfoUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class HouseServiceImpl implements IHouseService {

    @Autowired
    HouseDAO houseDAO;


    /*@Autowired
    ModelMapper modelMapper;*/

    @Value("${qiniu.cdnprefix}")
    String cdnprefix;

    @Override
    public ServiceResult saveHouse(House house) {

        //保存房屋信息--------house----------1
        house.setCreateTime(new Date());
        house.setLastUpdateTime(new Date());
        house.setAdminId(String.valueOf(UserInfoUtil.getUserId()));//当前操作人的ID
        houseDAO.saveHouse(house);


        //保存房屋详情信息----house_detail---1
        HouseDetail houseDetail = new HouseDetail();
        //将house对象中的字段，按照名称匹配到houseDetail中
        //modelMapper:在进行对象映射的时候
        /**
         *参数1：源
         *参数2：赋值的对象
         *  要求：对象中的所有的属性，都需要去源对象中进行寻找，houseDetail中有一个主键ID，但是这个主键ID，在House中不存在
         */

        /*modelMapper.getConfiguration().setAmbiguityIgnored(true);//屏蔽不存在的字段
        modelMapper.map(house, houseDetail);*/
        //保存房屋house之后，如何将主键返回并赋值到house中
        houseDetail.setHouseId(house.getHouseId());
        houseDAO.saveHouseDetail(houseDetail);

        //保存房屋标签信息----house_tag------n
        List<String> houseTags = house.getTags();//标签名称

        if(houseTags != null && houseTags.size() > 0){
            List<HouseTag> houseTagList = new ArrayList<>();
            for (String tag : houseTags) {
                HouseTag houseTag = new HouseTag();
                houseTag.setTagName(tag);
                houseTag.setHouseId(house.getHouseId());
                houseTagList.add(houseTag);
            }

            houseDAO.saveHouseTags(houseTagList);
        }

        /**
         *mapper对应的xml文件中：
         *  需求：进行批量操作的时候，参数只能接收以下几种类型：
         *  List----collection=list
         *  ArrayList ----collection=list/arrayList
         *  Map------collection=map
         */


        //保存房屋图片信息----house_picture--n
        List<HousePicture> housePhotos = house.getPhotos();

        if(housePhotos != null && housePhotos.size() > 0){
            for (HousePicture picture : housePhotos) {
                picture.setHouseId(house.getHouseId());
                picture.setCdnPrefix(cdnprefix);
            }
            houseDAO.saveHousePictures(housePhotos);
        }



        return new ServiceResult(true);
    }
}

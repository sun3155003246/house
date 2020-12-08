package com.sxp.controller;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.sxp.entity.City;
import com.sxp.entity.House;
import com.sxp.entity.QiNiuPutRet;
import com.sxp.service.CountyService;
import com.sxp.service.ICityService;
import com.sxp.service.IHouseService;
import com.sxp.service.IQiNiuService;
import com.sxp.utils.ApiResponse;
import com.sxp.utils.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.qiniu.http.Response;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
public class AdminHouseController {
   @Autowired
    ICityService cityService;
    @Autowired
    CountyService countyService;

    @Autowired
    IQiNiuService qiNiuService;
    @Autowired
    IHouseService houseService;

    @GetMapping("/address/supportCities")
    public @ResponseBody
    ApiResponse supportCities(){
        List<City> cityList = cityService.supportCities();
        if(cityList != null && cityList.size()>0){
            return ApiResponse.ofSuccess(cityList);
        }
       return ApiResponse.ofErrorMessage(ApiResponse.Status.RESULT_NULL.getCode(),ApiResponse.Status.RESULT_NULL.getMessage());
    }
    @GetMapping("/address/supportRegions")
    public @ResponseBody ApiResponse supportCounty(String city_name){
        List<City> cityList = countyService.supportCounty(city_name);
        if(cityList != null && cityList.size()>0){
            return ApiResponse.ofSuccess(cityList);
        }
        return ApiResponse.ofErrorMessage(ApiResponse.Status.RESULT_NULL.getCode(),ApiResponse.Status.RESULT_NULL.getMessage());
    }

    /**
     * 图片上传
     * @param file
     * @return
     */
    @PostMapping("/admin/uploadPhotos")
    public @ResponseBody ApiResponse uploadImages(@RequestParam("file") MultipartFile file){

        //判断参数是否为空
        if(file == null){
            return ApiResponse.ofErrorMessage(ApiResponse.Status.PARAMS_NULL.getCode(),ApiResponse.Status.PARAMS_NULL.getMessage());
        }
        //上传---数据流
        try {
            InputStream fileInputStream = file.getInputStream();

            Response response = qiNiuService.uploadImages(fileInputStream);
            //上传成功---提示信息---成功标识
            if(response.isOK()) {
                QiNiuPutRet putRet = new Gson().fromJson(response.bodyString(), QiNiuPutRet.class);
                return ApiResponse.ofSuccess(putRet);
            }
        }
        catch (QiniuException ex) {
            //失败---失败原因
            Response r = ex.response;
            try {
                return ApiResponse.ofErrorMessage(ApiResponse.Status.BAD_REQUST.getCode(), r.bodyString().toString());
            } catch (QiniuException ex2) {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ApiResponse.ofErrorMessage(ApiResponse.Status.BAD_REQUST.getCode(), ApiResponse.Status.BAD_REQUST.getMessage());



    }
    /**
     * @Description: 保存房屋信息
     * @Author: likang
     * @Date: 2019/11/8 10:45
     * @Param: [house, bindingResult]
     * @Return: com.xdl.utils.ApiResponse
     * @Exception:
     *
     * BindingResult:
     *  是将请求中的参数提示信息进行匹配，如果正确则取消校验，如果错误，则会提示message(注解)信息
     *
     *
     */
    @PostMapping("/admin/houseAdd")
    public @ResponseBody ApiResponse addHouse(House house, BindingResult bindingResult){

        //字符校验信息提示
        if(bindingResult.hasErrors()){
            return ApiResponse.ofErrorMessage(HttpStatus.BAD_REQUEST.value(), bindingResult.getAllErrors().toString());
        }

        //保存房屋信息
        ServiceResult result = houseService.saveHouse(house);
        //保存成功，则返回成功标识
        if(result.isSuccess()){
            return ApiResponse.ofSuccess(null);
        }
        //保存失败，则提示错误信息
        return ApiResponse.ofErrorMessage(ApiResponse.Status.BAD_REQUST.getCode(), ApiResponse.Status.BAD_REQUST.getMessage());
    }




}

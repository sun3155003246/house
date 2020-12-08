package com.sxp.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: likang
 * @Date: 2019/9/26 8:57
 * @Description:  搜索条件封装对象
 */
@Data
public class DataTableSerach {

    private String direction;//排序方式
    private String orderBy;//排序字段

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTimeMin;//创建时间--最小值
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTimeMax;//创建时间--最大值

    private int draw;//前端传输的特殊参数，无需做任何处理，直接传到后台即可
    private int start;//开始数据下标
    private int length;//请求个数


    private String city;//城市
    private String title;//标题
    private String status;//状态


}

package com.openlab.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author xjx
 * @create$2025-01 17-下午12:10
 */
//分页数据工具类
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
public class PageUtil <T> {
    private List<T> items; //分页数据
    private int page;  //当前页码
    private int total; //总记录数
    private int pages; //总页码
}


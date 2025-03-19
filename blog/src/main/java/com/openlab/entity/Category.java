package com.openlab.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xjx
 * @create$2025-01 16-下午3:15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    private Long cateId;
    private String cateName;
    private int cateNumber;
}

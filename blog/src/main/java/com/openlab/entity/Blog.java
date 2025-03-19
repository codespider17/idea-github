package com.openlab.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author xjx
 * @create$2025-01 16-下午3:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Blog {
    private Long blogId;
    private Long cateId;
    private String blogTitle;
    private String blogIntro;
    private String blogContent;
    private String blogThumb;
    private LocalDateTime blogCreateTime;
    private boolean blogTop;
    private boolean blogRead;
    private int blogOriginal;
    private Long blogOrdered;
    private int blogPraise;
    private int blogTread;
}

package com.openlab.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xjx
 * @create$2025-02 19-上午8:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tag {
    private Long tagId;
    private String tagName;
}

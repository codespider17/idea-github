package com.openlab.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xjx
 * @create$2025-02 19-上午8:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlogTag {
    private Long blogId;
    private Long tagId;

}

package com.openlab.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author xjx
 * @create$2025-02 19-上午8:15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Long id;
    private String username;
    private String nickname;
    private String password;
    private String account;
    private LocalDateTime regdate; // 注册日期
    private Integer logtime; // 登录次数
    private LocalDateTime lastLoginDate; // 最后一次登录时间
}

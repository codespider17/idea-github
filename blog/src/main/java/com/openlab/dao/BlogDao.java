package com.openlab.dao;

import com.openlab.entity.Blog;
import com.openlab.util.PageUtil;

import java.util.List;

/**
 * @author xjx
 * @create$2025-01 16-下午3:28
 */
public interface BlogDao {
    void insert(Blog blog);
    void update(Blog blog);
    void delete(Long blogId);
    Blog getById(Long blogId);
    //分页查询博客数据
    PageUtil<Blog> getByPage(int offset, int pageSize);
    //按照分类进行博客分页查询
    PageUtil<Blog> getByPage(Long cateId, int offset, Integer pageSize);
    //得到总记录数
    int getCount();
    //获取类别博客总数
    int getCount(Long cateId);
}

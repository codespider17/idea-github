package com.openlab.dao;

import com.openlab.entity.Category;

import java.util.List;

/**
 * @author xjx
 * @create$2025-01 16-下午3:23
 */
public interface CategoryDao {
    void insert(Category category);
    void update(Category category);
    void delete( Long cateid );
    Category getById(Long cateid);
    List<Category> getAll();
}

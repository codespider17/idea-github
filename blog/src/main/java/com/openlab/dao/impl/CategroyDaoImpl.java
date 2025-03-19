package com.openlab.dao.impl;

import com.openlab.dao.CategoryDao;
import com.openlab.entity.Category;
import com.openlab.util.JdbcUtil;

import java.util.List;

/**
 * @author xjx
 * @create$2025-01 16-下午7:39
 */
public class CategroyDaoImpl implements CategoryDao {
    @Override
    public void insert(Category category) {
        JdbcUtil.update("insert into tb_category(cate_name,cate_number) values(?,?)",category.getCateName(),category.getCateNumber());
    }

    @Override
    public void update(Category category) {
        JdbcUtil.update("update tb_category set cate_name=? ,cate_number=? where cate_id=?",category.getCateName(),category.getCateNumber(),category.getCateId());
    }

    @Override
    public void delete(Long cateid) {
        JdbcUtil.update("delete from tb_category where cate_id=?",cateid);
    }

    @Override
    public Category getById(Long cateid) {
        List<Category> categoryList = JdbcUtil.query(Category.class,
                "select cate_id cateId, cate_name cateName, cate_number cateNumber from tb_category where cate_id=?",cateid);
        return categoryList.isEmpty() ? null : categoryList.get(0);
    }

    @Override
    public List<Category> getAll() {
        return JdbcUtil.query(Category.class,
                "select cate_id cateId, cate_name cateName, cate_number cateNumber from tb_category");
    }
}

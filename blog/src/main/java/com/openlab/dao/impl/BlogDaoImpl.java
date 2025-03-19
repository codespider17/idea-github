package com.openlab.dao.impl;

import com.openlab.dao.BlogDao;
import com.openlab.entity.Blog;
import com.openlab.util.JdbcUtil;
import com.openlab.util.PageUtil;

import java.util.List;

/**
 * @author xjx
 * @create$2025-01 17-下午12:23
 */
public class BlogDaoImpl implements BlogDao {
    @Override
    public void insert(Blog blog) {
        JdbcUtil.update(
                "insert into tb_blog(cate_id,blog_title,blog_intro,blog_content,blog_thumb,blog_create_time,blog_top,blog_read,blog_original,blog_ordered,blog_praise,blog_tread) values(?,?,?,?,?,?,?,?,?,?,?,?)",
                blog.getCateId(), blog.getBlogTitle(), blog.getBlogIntro(),
                blog.getBlogContent(), blog.getBlogThumb(), blog.getBlogCreateTime(),
                blog.isBlogTop(), blog.isBlogRead(), blog.getBlogOrdered(),
                blog.getBlogOrdered(), blog.getBlogPraise(), blog.getBlogTread()
        );
    }

    @Override
    public void update(Blog blog) {
        JdbcUtil.update(
                "update tb_blog set cate_id=?,blog_title=?,blog_intro=?,blog_content=?,blog_thumb=?,blog_create_time=?,blog_top=?,blog_read=?,blog_original=?,blog_ordered=?,blog_praise=?,blog_tread=? where blog_id=?",
                blog.getCateId(), blog.getBlogTitle(), blog.getBlogIntro(),
                blog.getBlogContent(), blog.getBlogThumb(), blog.getBlogCreateTime(),
                blog.isBlogTop(), blog.isBlogRead(), blog.getBlogOrdered(),
                blog.getBlogOrdered(), blog.getBlogPraise(), blog.getBlogTread(), blog.getBlogId()
        );
    }

    @Override
    public void delete(Long blogId) {
        JdbcUtil.update("delete from tb_blog where blog_id=?", blogId);
    }

    @Override
    public Blog getById(Long blogId) {
        List<Blog> blogs = JdbcUtil.query(Blog.class,
                "select blog_id blogId, cate_id cateId,blog_title blogTitle,blog_intro blogIntro,blog_content blogContent,blog_thumb blogThumb,blog_create_time blogCreateTime,blog_top blogTop,blog_read blogRead,blog_original blogOriginal,blog_ordered blogOrdered,blog_praise blogPraise,blog_tread blogTread from tb_blog where blog_id=?",
                blogId);
        return blogs.isEmpty() ? null : blogs.get(0);
    }

    @Override
    public PageUtil<Blog> getByPage(int offset, int pageSize) {
        if (offset <= 1) offset = 1;
        // 总数
        int count = getCount();
        // 总页数
        int pages = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
        if (offset >= pages) offset = pages;
        if (offset <= 1) offset = 1;

        List<Blog> blogs = JdbcUtil.query(Blog.class,
                "select blog_id blogId, cate_id cateId,blog_title blogTitle,blog_intro blogIntro,blog_content blogContent,blog_thumb blogThumb,blog_create_time blogCreateTime,blog_top blogTop,blog_read blogRead,blog_original blogOriginal,blog_ordered blogOrdered,blog_praise blogPraise,blog_tread blogTread from tb_blog order by blog_id desc limit ?, ?",
                (offset - 1) * pageSize, pageSize);

        return new PageUtil<Blog>(blogs,offset,count,pages);
    }

    @Override
    public PageUtil<Blog> getByPage(Long cateId, int offset, Integer pageSize) {
        if (offset <= 1) offset = 1;
        // 总数
        int count = getCount(cateId);
        // 总页数
        int pages = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
        if (offset >= pages) offset = pages;
        if (offset <= 1) offset = 1;

        List<Blog> blogs = JdbcUtil.query(Blog.class,
                "select blog_id blogId, cate_id cateId,blog_title blogTitle,blog_intro blogIntro,blog_content blogContent,blog_thumb blogThumb,blog_create_time blogCreateTime,blog_top blogTop,blog_read blogRead,blog_original blogOriginal,blog_ordered blogOrdered,blog_praise blogPraise,blog_tread blogTread from tb_blog where cate_id=? order by blog_id desc limit ?, ?",
                cateId, (offset - 1) * pageSize, pageSize);
        return new PageUtil<Blog>(blogs, offset, count, pages);
    }

    @Override
    public int getCount() {
        return JdbcUtil.queryForObject(Integer.class, "select count(*) from tb_blog");
    }

    @Override
    public int getCount(Long cateId) {
        return JdbcUtil.queryForObject(Integer.class, "select count(*) from tb_blog where cate_id=?", cateId);
    }
}

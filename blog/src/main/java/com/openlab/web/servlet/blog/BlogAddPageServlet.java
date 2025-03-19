package com.openlab.web.servlet.blog;

import com.openlab.dao.CategoryDao;
import com.openlab.dao.impl.CategroyDaoImpl;
import com.openlab.entity.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author xjx
 * @create$2025-01 19-上午10:46
 */
@WebServlet(name="blogAddPageServlet",urlPatterns = "/blog/add")
public class BlogAddPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用DAO方法来查询类别
        CategoryDao categoryDao=new CategroyDaoImpl();
        List<Category> cates = categoryDao.getAll();

        //添加到request 对象中
        request.setAttribute("cates", cates);
        //转发到/blog/add.jsp 页面
        request.getRequestDispatcher("/blog/add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
        System.out.println("我去");
        System.out.println("hot-fix");
        System.out.println("push-test");
    }
}

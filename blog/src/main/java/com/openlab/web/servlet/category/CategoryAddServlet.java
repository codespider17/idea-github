package com.openlab.web.servlet.category;

import com.openlab.dao.CategoryDao;
import com.openlab.dao.impl.CategroyDaoImpl;
import com.openlab.entity.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xjx
 * @create$2025-01 17-下午3:45
 */
@WebServlet(name="categoryAddServlet",urlPatterns = "/cate/add")
public class CategoryAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //接收参数
        String name = request.getParameter("cateName");
        String cateNumber = request.getParameter("cateNumber");

        int num=Integer.parseInt(cateNumber);
        //4.封装数据
        Category category=Category.builder().cateName(name).cateNumber(num).build();
        //创建Dao对象，并调用方法
        CategoryDao categoryDao=new CategroyDaoImpl();
        categoryDao.insert(category);
        //转页面
        response.sendRedirect(request.getContextPath()+"/cate/list");

    }
}

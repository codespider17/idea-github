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
import java.util.List;

/**
 * @author xjx
 * @create$2025-01 17-下午4:07
 */
@WebServlet(name="categoryListServlet",urlPatterns = "/cate/list")
public class CategoryListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询所有类别数据
        CategoryDao categoryDao=new CategroyDaoImpl();
        List<Category> categoryList = categoryDao.getAll();

        //2.将数据放到 Request 作用域
        request.setAttribute("cates", categoryList);
        //3.转发到类别列表页面
        request.getRequestDispatcher("/cate/list.jsp").forward(request, response); 
    }
}

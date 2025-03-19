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
 * @create$2025-01 17-下午4:31
 */
@WebServlet(name="categoryEditServlet",urlPatterns = "/cate/edit")
public class CategoryEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受要查询的类别编号
        String cateIdStr = request.getParameter("cateId");

        //2.类型转换
        Long cateId = Long.valueOf(cateIdStr);

        //3.查询数据
        CategoryDao categoryDao = new CategroyDaoImpl();
        Category category = categoryDao.getById(cateId);

        //4.将查询到的数据放到 request 对象中
        request.setAttribute("category", category);

        //5.转发到修改页面
        request.getRequestDispatcher("/cate/edit.jsp").forward(request, response);
    }
}

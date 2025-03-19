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
 * @create$2025-01 17-下午4:48
 */
@WebServlet(name="categoryEditHandleServlet",urlPatterns = "/cate/editHandle")
public class CategoryEditHandleServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //接收参数
        String name = request.getParameter("cateName");
        String num = request.getParameter("cateNumber");
        String cateIdStr = request.getParameter("cateId");

        int cateNumber = Integer.parseInt(num);
        Long  cateId = Long.valueOf(cateIdStr);

        Category category = Category.builder().cateName(name).cateNumber(cateNumber).cateId(cateId).build();

        CategoryDao categoryDao=new CategroyDaoImpl();
        categoryDao.update(category);

        response.sendRedirect(request.getContextPath()+"/cate/list");

    }
}

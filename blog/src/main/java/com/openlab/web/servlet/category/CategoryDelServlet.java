package com.openlab.web.servlet.category;

import com.openlab.dao.CategoryDao;
import com.openlab.dao.impl.CategroyDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xjx
 * @create$2025-01 17-下午5:00
 */
@WebServlet(name="categoryDelServlet",urlPatterns = "/cate/del")
public class CategoryDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cateIdStr = request.getParameter("cateId");

        //类型转换
        Long cateId = Long.valueOf(cateIdStr);

        CategoryDao categoryDao=new CategroyDaoImpl();
        categoryDao.delete(cateId);

        response.sendRedirect(request.getContextPath()+"/cate/list");
    }
}

package com.openlab.web.servlet.blog;

import com.openlab.dao.BlogDao;
import com.openlab.dao.CategoryDao;
import com.openlab.dao.impl.BlogDaoImpl;
import com.openlab.dao.impl.CategroyDaoImpl;
import com.openlab.entity.Blog;
import com.openlab.entity.Category;
import com.openlab.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author xjx
 * @create$2025-01 19-下午5:02
 */
@WebServlet(name="blogListServlet",urlPatterns = "/blog/list")
public class BlogListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受参数
        String cateIdStr = request.getParameter("cateId");
        String pageStr = request.getParameter("page");

        int pageSize=2;

        Long cateId = 0L;
        if(cateIdStr!=null&&!cateIdStr.isEmpty()){
            cateId = Long.valueOf(cateIdStr);
        }
        int page=1;
        if(pageStr!=null&&!pageStr.isEmpty()){
            page=Integer.parseInt(pageStr);
        }


        BlogDao blogDao=new BlogDaoImpl();
        PageUtil<Blog> blogs=null;
        if(cateId.equals(0L)){
            blogs = blogDao.getByPage(page, pageSize); //查询全部分页数据
        }
        else{
            blogs = blogDao.getByPage(cateId, page, pageSize); //查询指定类别下的分页数据
        }
        //查询类别列表数据
        CategoryDao categoryDao=new CategroyDaoImpl();
        List<Category> cates = categoryDao.getAll();

        //4.把数据放到 request 作用域
        request.setAttribute("blogs",blogs);
        request.setAttribute("cates", cates);

        request.getRequestDispatcher("/blog/list.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

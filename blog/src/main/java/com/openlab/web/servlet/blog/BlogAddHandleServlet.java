package com.openlab.web.servlet.blog;

import com.openlab.dao.BlogDao;
import com.openlab.dao.impl.BlogDaoImpl;
import com.openlab.entity.Blog;
import com.openlab.util.FileUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author xjx
 * @create$2025-01 19-上午11:17
 */
//处理博客添加功能，在这个功能中会涉及到文件上传操作。
//要实现文件上传，我们需要在 Servlet 这个类上添加 @MultipartConfig 来开启文件上传功能
//然后还需要创建 Part 对象，通过这个对象来实现文件上传
@WebServlet(name="blogAddHandleServlet",urlPatterns = "/blog/addHandle")
@MultipartConfig
public class BlogAddHandleServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");


        // 2. 接收参数
        String title = request.getParameter("title");
        String cateIdStr = request.getParameter("cateId");
        String blogIntro = request.getParameter("blogIntro");
        String blogContent = request.getParameter("blogContent");

        // 3. 类别转换
        Long cateId = Long.parseLong(cateIdStr);
        //4.创建文件上传的目录
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        File dir = new File(realPath);
        if(!dir.exists()){
            dir.mkdirs();
        }
        //创建part对象
        Part part = request.getPart("thumb");
        String header = part.getHeader("content-disposition");
        String ext= FileUtil.getExt(header);   //获取文件的扩展名

        //生成新的文件名称
        String fileName = System.currentTimeMillis() + ext;
        //实现文件上传
        part.write(realPath+"/"+fileName);
        //删除临时文件
        part.delete();

        //6.封装数据
        Blog blog = Blog.builder()
                .cateId(cateId)
                .blogTitle(title)
                .blogIntro(blogIntro)
                .blogThumb("upload/"+fileName)
                .blogContent(blogContent)
                .blogCreateTime(LocalDateTime.now())
                .blogOrdered(1L)
                .blogOriginal(1)
                .blogTop(false)
                .blogRead(false)
                .blogPraise(0)
                .blogTread(0)
                .build();

        //7.调用Dao方法
        BlogDao blogDao=new BlogDaoImpl();
        blogDao.insert(blog);
        //8.重定向到博客列表的selvlet
        response.sendRedirect(request.getContextPath()+"/blog/list");
    }
}

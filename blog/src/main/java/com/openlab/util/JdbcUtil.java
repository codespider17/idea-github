package com.openlab.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xjx
 * @create$2025-01 16-下午7:40
 */
public final class JdbcUtil {
    public static final String DRIVER="com.mysql.cj.jdbc.Driver";
    public static final String URL="jdbc:mysql://localhost:3306/blog?useSSL=false&characterEncoding=utf8&timeZone=UTC";
    public static final String USER="root";
    public static final String PASSWORD="123456";
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("加载驱动器类出错:"+e.getMessage());
        }
    }

    private static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("创建连接对象出错:"+e.getMessage());
        }
    }

    public static void update(String sql,Object... params){
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i+1,params[i]);
            }
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("更新数据出错:"+e.getMessage());
        } finally {
            release(conn,pst,null);
        }
    }

    public static <T> List<T> query(Class<T> clazz, String sql, Object...params) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<T> entities = null;

        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i + 1, params[i]);
            }
            rs = pst.executeQuery();

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            entities = new ArrayList<>();

            while (rs.next()) {
                T entity = clazz.getConstructor().newInstance();

                for (int i = 1; i <= columnCount; i++) {
                    String columnLabel = metaData.getColumnLabel(i);
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(entity, rs.getObject(i));
                }
                entities.add(entity);
            }
            return entities;
        } catch (Exception e) {
            throw new RuntimeException("查询数据出错：" + e.getMessage());
        } finally {
            release(conn, pst, rs);
        }
    }

    public static <T> T queryForObject(Class<T> clazz, String sql, Object...params) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        T entity = null;
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i + 1, params[i]);
            }
            rs = pst.executeQuery();
            while (rs.next()) {
                if (clazz == Integer.class) {
                    Constructor<T> constructor = clazz.getDeclaredConstructor(int.class);
                    entity = constructor.newInstance(rs.getInt(1));
                } else if (clazz == Long.class) {
                    Constructor<T> constructor = clazz.getDeclaredConstructor(long.class);
                    entity = constructor.newInstance(rs.getLong(1));
                } else {
                    throw new RuntimeException("参数中能传 int 类型或 long 类型。");
                }
            }
            return entity;
        } catch (Exception e) {
            throw new RuntimeException("查询数据出错：" + e.getMessage());
        } finally {
            release(conn, pst, rs);
        }
    }




    private static void release(Connection conn, PreparedStatement pst, ResultSet rs){
        try {
            if(rs != null) rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(pst!=null) pst.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    if(conn!=null) conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

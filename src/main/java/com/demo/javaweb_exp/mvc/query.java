package com.demo.javaweb_exp.mvc;

import com.alibaba.fastjson.JSON;
import com.demo.javaweb_exp.entity.book;
import com.demo.javaweb_exp.utils.jdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *book--query
 */
@WebServlet("/query")
public class query extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        //获取参数
        String bookid = req.getParameter("bookid");
        //查询信息
        //准备数据
        Connection connection = jdbc.getconnect();
        PreparedStatement statement=null;
        ResultSet result =null;
        String sql = "select * from books where bookid=?";
        book book = null;
        //连接数据库执行sql语句
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1,bookid);
            result=statement.executeQuery();
            //处理结果
            while(result.next()){
                String id = result.getNString("bookid");
                String title = result.getString("title");
                String author = result.getString("author");
                String publisher = result.getString("publisher");
                Double price = result.getDouble("price");
                book=new book(id,title,author,publisher,price);
            }
        } catch (SQLException e) {
            System.out.println("query error!");
            e.printStackTrace();
        } finally {
            jdbc.realse(connection,statement,result);
        }
        //返回结果
        String str = JSON.toJSONString(book);
        resp.getWriter().write(str);
//        System.out.println("query result:"+str);
    }
}

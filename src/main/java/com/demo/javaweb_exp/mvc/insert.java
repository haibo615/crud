package com.demo.javaweb_exp.mvc;

import com.alibaba.fastjson.JSON;
import com.demo.javaweb_exp.entity.book;
import com.demo.javaweb_exp.utils.jdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *book-insert
 */
@WebServlet("/insert")
public class insert extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        //获取参数
        String bookid = req.getParameter("bookid");
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String publisher = req.getParameter("publisher");
        Double price = Double.valueOf(req.getParameter("price"));
        //查询信息
        //准备数据
        Connection connection = jdbc.getconnect();
        PreparedStatement statement=null;
        ResultSet result =null;
        String sql = "INSERT into books (bookid,title,author,publisher,price) VALUES (?,?,?,?,?)";
        Integer flag=0;
        //连接数据库执行sql语句
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1,bookid);
            statement.setString(2,title);
            statement.setString(3,author);
            statement.setString(4,publisher);
            statement.setDouble(5,price);
            flag=statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("insert error!");
            e.printStackTrace();
        } finally {
            jdbc.realse(connection,statement,result);
        }
        //返回结果
        if(flag==1){
            resp.getWriter().write("success!");
        }else{
            resp.getWriter().write("error!");
        }
    }
}

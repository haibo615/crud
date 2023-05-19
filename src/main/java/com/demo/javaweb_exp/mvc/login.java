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
 *user--login
 */
@WebServlet("/login")
public class login extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        //获取参数
        String name = req.getParameter("name");
        String pswd = req.getParameter("pswd");
        //查询信息
        //准备数据
        Connection connection = jdbc.getconnect();
        PreparedStatement statement=null;
        ResultSet result =null;
        String sql = "select * from user where name=? and pswd=?";
        boolean flag = false;
        //连接数据库执行sql语句
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,pswd);
            result=statement.executeQuery();
            //处理结果
            if(result.next())flag=true;
        } catch (SQLException e) {
            System.out.println("query error!");
            e.printStackTrace();
        } finally {
            jdbc.realse(connection,statement,result);
        }
        //返回结果
        if(flag){
            resp.getWriter().write("success!");
        }else{
            resp.getWriter().write("fail！");
        }
    }
}

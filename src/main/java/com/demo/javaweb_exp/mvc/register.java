package com.demo.javaweb_exp.mvc;

import com.demo.javaweb_exp.utils.jdbc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *user--register
 */
public class register extends HttpServlet {
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
        String sql = "insert into user (name,pswd) VALUES (?,?) ";
        Integer flag =0;
        //连接数据库执行sql语句
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,pswd);
            flag=statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("register error!");
            e.printStackTrace();
        } finally {
            jdbc.realse(connection,statement,result);
        }
        //返回结果
        if(flag==1){
            resp.getWriter().write("success!");
        }else{
            resp.getWriter().write("fail！");
        }
    }
}

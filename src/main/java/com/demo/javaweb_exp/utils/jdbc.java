package com.demo.javaweb_exp.utils;
import java.sql.*;

/**
 *封装jdbc数据库连接
 */
public class jdbc {
    //    数据库连接功能
    public static Connection getconnect(){
        //      设置编码时区、开启sql预编译功能等等
        String url= "jdbc:mysql:///postgres?serverTimezone=GMT%2B8&useServerPrepStmts=true";
        String username = "root";
        String password = "pangbo128**";
        Connection conn = null;

        try {
            //        加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //        连接数据库
            conn=DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            System.out.println("Database fail!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
            e.printStackTrace();
        }
        return conn;
    }
    //    释放资源
    public static void realse(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
        try {
            if(resultSet!=null){
                resultSet.close();
            }
            if(preparedStatement!=null){
                preparedStatement.close();
            }
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void realse(Connection connection,PreparedStatement preparedStatement1,PreparedStatement preparedStatement2,ResultSet resultSet){
        try {
            if(resultSet!=null){
                resultSet.close();
            }
            if(preparedStatement2!=null){
                preparedStatement2.close();
            }
            if(preparedStatement1!=null){
                preparedStatement1.close();
            }
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

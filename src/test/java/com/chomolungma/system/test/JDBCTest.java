package com.chomolungma.system.test;

import com.chomolungma.system.user.pojo.User;

import java.sql.*;
import java.util.ArrayList;

public class JDBCTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.注册驱动(静态方法)(包名+类名）
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接对象(导包都导sql里面的，不导jdbc里的；多态！报异常是因为用户输入的串可能写错）后面设置下数据格式
        String url="jdbc:mysql://localhost:3306/cdp?serverTimezone=UTC&characterEncoding=utf-8&useSSL=false";
        String user="root";
        String password="123456";
        Connection conn=DriverManager.getConnection(url,user,password);
        //System.out.println(conn);报地址为正确sql服务关了可能报错
        //3.获取语句执行平台：
        Statement sta=conn.createStatement();
        //4.执行sql语句
        String sql="select * from sys_user";
        ResultSet rs=sta.executeQuery(sql);
        //5.处理结果集(括号里一般是第1列、第2列，但是可以写字段名)
        ArrayList<User> arr=new ArrayList<User>();
        while(rs.next()){
            //System.out.println(rs.getInt("sid")+"..."+rs.getString("sname"));
            User users =new User();
            users.setName(rs.getString("name"));
            users.setGender(rs.getString("gender"));
            arr.add(users);
        }
        System.out.println(arr);
        //6.释放资源
        rs.close();
        sta.close();
        conn.close();
    }
}

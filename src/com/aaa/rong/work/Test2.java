package com.aaa.rong.work;

import java.sql.*;
import java.util.Scanner;

/**
 * @Author:ryp
 * @Description:2.再写一个jdbc程序,通过控制台，模拟用户登录,使用查询验证登录是否成功
 * @Date: 2021/01/12/16:31
 */
public class Test2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("【用户登录】");
        System.out.println("请输入用户名：");
        String username = scan.next();
        System.out.println("请输入密 码：");
        String password = scan.next();

        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            //将数据库驱动类加载到JVM内存中
            Class.forName("com.mysql.jdbc.Driver");
            //得到连接对象
            String url = "jdbc:mysql:///employee";
            conn = DriverManager.getConnection(url, "root", "123456");
            //sql语句
            String sql = "select password from person where username=?";
            //得到预编译语句对象
            pstm = conn.prepareStatement(sql);
            //给问号赋值
            pstm.setString(1, username);
            //返回查询结果集
            ResultSet result = pstm.executeQuery();

            if (result.next()) {
                //获得查询的密码
                String pwd = result.getString(1);
                //判断用户输入的密码
                if (pwd.equals(password)) {
                    System.out.println("登录成功！");
                } else {
                    System.out.println("登录失败,用户名或密码不正确！");
                }
            } else {
                System.out.println("无此用户");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (null != pstm) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    if (null != conn) {
                        try {
                            conn.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }

    }

}

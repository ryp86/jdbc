package com.aaa.rong.work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @Author:ryp
 * @Description:
 *
 * 一、新建数据表person，有id username password三个字段.
 * 1.先写一个jdbc程序,通过控制台，批量新增几条数据
 * @Date: 2021/01/12/16:17
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("【新增用户】");
        System.out.println("请输入用户名：");
        String username = scan.next();
        System.out.println("请输入密 码：");
        String password = scan.next();

        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql:///employee";
            conn = DriverManager.getConnection(url, "root", "123456");

            String sql = "insert into person values(null,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,username);
            pstm.setString(2,password);

            int result = pstm.executeUpdate();
            if (result > 0) {
                System.out.println("添加成功，用户【"+ username + "," + password+"】");
            }else{
                System.out.println("添加失败");
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
                }finally {
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

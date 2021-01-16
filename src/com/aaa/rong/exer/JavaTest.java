package com.aaa.rong.exer;

import com.aaa.rong.bank.JDBCUtil;

import java.sql.*;
import java.util.Scanner;

/**
 * @Author:ryp
 * @Description:
 * @Date: 2021/01/11/14:24
 */
public class JavaTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("【新增部门】");
        System.out.println("请输入部门编号:");
        int deptno = scan.nextInt();
        System.out.println("请输入部门名称:");
        String dname = scan.next();
        System.out.println("请输入部门所在的城市:");
        String loc = scan.next();

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.将数据库驱动类加载到JVM内存中
            Class.forName("com.mysql.jdbc.Driver");

            //2.得到连接对象
            String url = "jdbc:mysql:///employee";
            conn = DriverManager.getConnection(url, "root", "123456");

            //3.得到预编译语句对象
            //4.准备好sql语句
            String sql = "insert into dept values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,deptno);
            ps.setString(2,dname);
            ps.setString(3,loc);

            //5.执行
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scan.close();
            //6.关闭资源
            JDBCUtil.closePsAndConn(ps,conn);
        }
    }
}

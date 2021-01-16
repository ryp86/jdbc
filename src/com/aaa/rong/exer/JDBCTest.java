package com.aaa.rong.exer;

import com.sun.corba.se.pept.transport.ConnectionCache;
import org.junit.Test;

import java.sql.*;
import java.util.Scanner;

/**
 * @Author:ryp
 * @Description:
 * @Date: 2021/01/11/19:05
 */
public class JDBCTest {

    public static void main(String[] args) {
        //add();
        //delete();
        //update();
        query();
    }

    /**
     * 添加
     */
    public static void add() {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("请输入要操作的数据库：");
            String db = scan.next();

            Connection conn = getConn(db);

            Statement st = conn.createStatement();

            System.out.println("请输入部门编号：");
            int deptno = scan.nextInt();
            System.out.println("请输入部门名称：");
            String dname = scan.next();
            System.out.println("请输入所在地址：");
            String loc = scan.next();

            String sql = String.format("insert into dept values(%d,'%s','%s')", deptno, dname, loc);

            int result = st.executeUpdate(sql);
            if (result > 0) {
                System.out.println("插入成功");

            } else {
                System.out.println("插入失败");
            }
            scan.close();

            closeAll(null,st,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除
     */
    public static void delete() {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("请输入要操作的数据库：");
            String db = scan.next();

            Connection conn = getConn(db);
            Statement st = conn.createStatement();

            System.out.println("请输入要删除的部门编号:");
            int deptno = scan.nextInt();
            String sql = "delete from dept where deptno=" + deptno;
            int result = st.executeUpdate(sql);

            if (result > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
            scan.close();

            closeAll(null,st,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改
     */
    public static void update(){
        try {
            Scanner scan = new Scanner(System.in);

            System.out.println("请输入要操作的数据库：");
            String db = scan.next();

            Connection conn = getConn(db);

            Statement st = conn.createStatement();

            System.out.println("请输入要修改的部门编号：");
            int deptno = scan.nextInt();
            System.out.println("请输入要修改的部门名称：");
            String dname = scan.next();
            System.out.println("请输入要修改的部门地址：");
            String loc = scan.next();

            String sql = String.format("update dept set dname='%s',loc='%s' where deptno=%d",dname,loc,deptno);
            int result = st.executeUpdate(sql);

            if (result > 0) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }
            scan.close();

            closeAll(null,st,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询
     */
    public static void query(){
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("请输入要操作的数据库:");
            String db = scan.next();

            Connection conn = getConn(db);

            Statement st = conn.createStatement();

            String sql = "select * from dept";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int deptno = rs.getInt(1);
                String dname = rs.getString(2);
                String loc = rs.getString(3);
                System.out.println("部门编号：" + deptno + ",部门名称：" + dname + ",部门地址" + loc);
            }
            scan.close();

            closeAll(rs,st,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 返回连接对象
     * @param db
     * @return
     */
    public static Connection getConn(String db){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/"+db;
            conn = DriverManager.getConnection(url, "root", "123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return conn;
        }
    }

    /**
     * 关闭资源
     * @param rs
     * @param st
     * @param conn
     */
    public static void closeAll(ResultSet rs,Statement st,Connection conn){
        if (null != rs) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                if (null != st) {
                    try {
                        st.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }finally {
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

package com.aaa.rong.exam;

import com.aaa.rong.exer.JDBCTest;

import java.sql.*;
import java.util.Scanner;

/**
 * @Author:ryp
 * @Description:
 * @Date: 2021/01/12/18:33
 */
public class StudentTest {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        queryAll();
        System.out.println("是否添加学生？(y/n)");
        String isFlag = scan.next().toUpperCase();
        System.out.println(isFlag);
        if (isFlag.equals("Y")) {
            while (true) {
                add();
                System.out.println("是否继续添加学生？(y/n)");
                isFlag = scan.next().toUpperCase();
                if (!isFlag.equals("Y")) {
                    break;
                }
            }
        }
        System.out.println("\n-----------------------【系统结束】-----------------------");

    }

    /**
     * 查询所有学生
     */
    public static void queryAll() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "select * from student";
        try {
            conn = getConn();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            System.out.println("-----------------------【学生信息表】-----------------------\n");
            System.out.println("姓名\t\t学号\t\t年龄\t\t性别\t\t入学时间\t\t毕业时间");
            while (rs.next()) {
                String stuname = rs.getString("stuname");
                int stuage = rs.getInt("stuage");
                String stuno = rs.getString("stuno");
                String stusex = rs.getString("stusex");
                Date rxtime = rs.getDate("rxtime");
                Date bytime = rs.getDate("bytime");

                String stu = String.format("%s\t\t%s\t%s\t\t%s\t\t%s\t%s", stuname,  stuno,stuage, stusex, rxtime, bytime);
                System.out.println(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, pstm, conn);
        }
    }

    /**
     * 添加学生信息
     */
    public static void add() {
        //用户输入

        System.out.println("【添加学生】");
        System.out.println("请输入姓名：");
        String stuname = scan.next();
        System.out.println("请输入年龄：");
        int stuage = scan.nextInt();

        String stuno;
        while (true) {
            System.out.println("请输入学号：");
            stuno = scan.next();
            if (!queryByStuno(stuno)) {
                break;
            }
            System.out.println("已有此学号");
        }


        System.out.println("请输入性别：");
        String stusex = scan.next();
        System.out.println("请输入入学时间：");
        Date rxtime = Date.valueOf(scan.next());
        System.out.println("请输入毕业时间：");
        Date bytime = Date.valueOf(scan.next());

        //数据库连接
        Connection conn = null;
        PreparedStatement pstm = null;

        String sql = "insert into student values(null,?,?,?,?,?,?)";

        try {
            conn = getConn();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, stuname);
            pstm.setInt(2, stuage);
            pstm.setString(3, stuno);
            pstm.setString(4, stusex);
            pstm.setDate(5, rxtime);
            pstm.setDate(6, bytime);
            //执行sql语句
            int i = pstm.executeUpdate();
            if (i > 0) {
                System.out.println("添加成功");
                System.out.println("学生信息为：" + stuname + "_" + stuage + "_" + stuno + "_" + stusex + "_" + rxtime + "_" + bytime);
            } else {
                System.out.println("添加失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(null, pstm, conn);
        }

    }

    /**
     * 根据学号查询
     * @param stuno
     * @return
     */
    public static boolean queryByStuno(String stuno){
        Connection conn = null;
        PreparedStatement pstm = null;

        boolean isTrue = false;
        try {
            conn = getConn();
            String sql = "select id from student where stuno = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,stuno);

            ResultSet rs = pstm.executeQuery();
            isTrue = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(null,pstm,conn);
        }

        return isTrue;
    }

    /**
     * 获取连接对象
     *
     * @return
     */
    public static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql:///exam";
            conn = DriverManager.getConnection(url, "root", "123456");
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭所有资源
     *
     * @param rs
     * @param pstm
     * @param conn
     */
    public static void closeAll(ResultSet rs, PreparedStatement pstm, Connection conn) {
        try {
            if (null != rs) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != pstm) {
                    pstm.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

package com.aaa.rong.exer1;

import java.sql.*;

/**
 * @Author:ryp
 * @Description:
 * @Date: 2021/01/12/14:25
 */
public class QueryTest {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            //将数据库驱动类加载到JVM中
            Class.forName("com.mysql.jdbc.Driver");
            //得到连接对象
            String url = "jdbc:mysql:///employee?charecterEncoding=utf-8";
            conn = DriverManager.getConnection(url, "root", "123456");
            //sql语句
            String sql = "select deptno,dname,loc from dept";

            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int deptno = rs.getInt(1);
                String dname = rs.getString(2);
                String loc = rs.getString(3);
                System.out.println(String.format("deptno:%s, dname:%s, loc:%s",deptno,dname,loc));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (null != rs) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally {
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
    }

}

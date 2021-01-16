package com.aaa.rong.test;

import java.sql.*;

/**
 * @Author:ryp
 * @Description:
 * @Date: 2021/01/12/8:20
 */
public class JDBCTest {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            //数据库驱动类加载到jvm
            Class.forName("com.mysql.jdbc.Driver");
            //得到连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///employee","root","123456");

            //sql语句
            String sql = "select * from emp limit 2,2";
            //得到预编译语句对象
            pstm = conn.prepareStatement(sql);

            //得到结果集
            rs = pstm.executeQuery();
            while (rs.next()) {
                int empno = rs.getInt("empno");
                String ename = rs.getString("ename");
                String job = rs.getString("job");
                int mgr = rs.getInt("mgr");
                Date hiredate = rs.getDate("hiredate");
                double sal = rs.getDouble("sal");
                double comm = rs.getDouble("comm");
                int deptno = rs.getInt("deptno");
                System.out.println(empno + "_" +ename + "_" +job + "_" +mgr + "_" +hiredate + "_" +sal + "_" +comm + "_" +deptno);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (null != rs) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    if (null != pstm) {
                        try {
                            pstm.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }finally {
                            if (null!= conn) {
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

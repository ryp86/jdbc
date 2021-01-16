package com.aaa.rong.exer;

import com.aaa.rong.bank.JDBCUtil;

import java.sql.*;

/**
 * @Author:ryp
 * @Description:
 * @Date: 2021/01/12/11:45
 */
public class QueryTest {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql:///employee","root","123456");

            String sql = "select deptno,dname,loc from dept";
            PreparedStatement pstm = conn.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int deptno = rs.getInt(1);
                String dname = rs.getString(2);
                String loc = rs.getString(3);
                System.out.println("deptno:" + deptno + ", dname:" + dname + ", loc:" + loc);
            }

            JDBCUtil.closeAll(rs,pstm,conn);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

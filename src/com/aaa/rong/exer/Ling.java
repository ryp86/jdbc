package com.aaa.rong.exer;

import java.sql.*;
import java.util.Arrays;

/**
 * @Author:ryp
 * @Description:
 * @Date: 2021/01/11/18:50
 */
public class Ling {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost/studb";
            Connection conn = DriverManager.getConnection(url, "root", "123456");

            Statement st = conn.createStatement();

            String sql = "select * from student";

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sno = rs.getString(2);
                String sname = rs.getString(3);
                String cno = rs.getString(4);
                String cname = rs.getString(5);
                double fs = rs.getDouble(6);
                System.out.println(id + "_" + sno + "_" + sname + "_" + cno + "_" + cname + "_" + fs);
            }

            st.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

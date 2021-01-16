package com.aaa.rong.work;

import java.sql.*;

/**
 * @Author:ryp
 * @Description:
 * @Date: 2021/01/14/8:28
 */
public class BaseDBUtil {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql:///employee";
    private static String username = "root";
    private static String password = "123456";

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int executeUpdate(String sql,Object[] arr){
        int result = 0;

        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = getConn();
            pstm = conn.prepareStatement(sql);
            if (null != arr) {
                for (int i = 0; i < arr.length; i++) {
                    pstm.setObject(i+1,arr[i]);
                }
            }
            result = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(null,pstm,conn);
        }

        return result;
    }

    private static Connection getConn() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    private static void close(ResultSet rs, PreparedStatement pstm, Connection conn) {
        try {
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

}

package com.aaa.rong.bank;

import java.sql.*;

/**
 * @Author:ryp
 * @Description:
 * @Date: 2021/01/12/9:39
 */
public class JDBCUtil {

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
     * 关闭st和conn
     * @param pstm
     * @param conn
     */
    public static void closePsAndConn(PreparedStatement pstm, Connection conn){
        if (null != pstm) {
            try {
                pstm.close();
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

    /**
     * 关闭全部资源
     * @param rs
     * @param pstm
     * @param conn
     */
    public static void closeAll(ResultSet rs, PreparedStatement pstm, Connection conn){
        if (null != rs) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                closePsAndConn(pstm,conn);
            }
        }
    }

}

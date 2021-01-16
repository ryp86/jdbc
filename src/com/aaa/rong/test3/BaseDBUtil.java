package com.aaa.rong.test3;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:ryp
 * @Description:
 * @Date: 2021/01/13/19:12
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

    public static List<Map> executeQuery(String sql, Object[] arr) {
        List list = new ArrayList();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = getConn();
            pstm = conn.prepareStatement(sql);
            if (null != arr) {
                for (int i = 0; i < arr.length; i++) {
                    pstm.setObject(i + 1, arr[i]);
                }
            }
            rs = pstm.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int count = metaData.getColumnCount();
            while (rs.next()) {
                Map map = new HashMap();
                for (int i = 1; i <= count; i++) {
                    String columnName = metaData.getColumnName(i);
                    map.put(columnName,rs.getObject(columnName));
                }
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs,pstm,conn);
        }

        return list;
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

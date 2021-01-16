package com.aaa.rong.test1;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:ryp
 * @Description:
 * @Date: 2021/01/13/14:50
 */
public class BaseDBUitl {

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

    /**
     * 得到连接对象
     *
     * @return
     * @throws SQLException
     */
    private static Connection getConn() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * 增删改
     * @param sql
     * @param arr
     * @return
     */
    public static int executeUpdate(String sql, Object[] arr) {
        int result = 0;

        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = getConn();
            pstm = conn.prepareStatement(sql);
            if (null != arr) {
                for (int i = 0; i < arr.length; i++) {
                    pstm.setObject(i + 1, arr[i]);
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

    /**
     * 查询
     * @param sql
     * @param arr
     * @return
     */
    public static List<Map> executeQuery(String sql, Object[] arr){
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
            //取出所有的字段名
            ResultSetMetaData metaData = rs.getMetaData();
            //得到字段的总数
            int count = metaData.getColumnCount();

            while (rs.next()) {
                Map map = new HashMap();
                for (int i = 1; i <= count ; i++) {
                    String columnName = metaData.getColumnName(i);
                    map.put(columnName,rs.getObject(columnName));
                }
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(null,pstm,conn);
        }

        return list;
    }

    /**
     * 关闭资源
     *
     * @param rs
     * @param pstm
     * @param conn
     */
    private static void close(ResultSet rs, PreparedStatement pstm, Connection conn) {
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
                    if (null != conn) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

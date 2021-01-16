package com.aaa.rong.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:ryp
 * @Description:
 * @Date: 2021/01/13/9:21
 */
public class BaseDB {

    private static String dirver = "com.mysql.jdbc.Driver";

    private static String url = "jdbc:mysql:///exam";

    private static String username = "root";

    private static String password = "123456";

    /**
     静态块：里面的代码只会执行一次
     */
    static {
        try {
            Class.forName(dirver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得连接对象的方法
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConn() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * 增删改
     *
     * @param sql
     * @param arr
     * @return
     * @throws SQLException
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
            close(null, pstm, conn);
        }

        return result;
    }

    /**
     * 查询
     * @param sql
     * @param arr
     * @return
     */
    public static List<Map> executeQuery(String sql, Object[] arr) {
        List list = new ArrayList();

        ResultSet rs = null;
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
            rs = pstm.executeQuery();

            //取出所有的字段名
            ResultSetMetaData metaData = rs.getMetaData();
            //得到字段的总数
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
            close(rs, pstm, conn);
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
    public static void close(ResultSet rs, PreparedStatement pstm, Connection conn) {
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




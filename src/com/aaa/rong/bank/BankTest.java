package com.aaa.rong.bank;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author:ryp
 * @Description:
 * @Date: 2021/01/12/9:38
 */
public class BankTest {

    public static void main(String[] args) {

        Connection conn = JDBCUtil.getConn("employee");

        try {
            Statement st = conn.createStatement();

            conn.setAutoCommit(false);

            String sql = "update account set money=money-500 where id = 1001";
            st.executeUpdate(sql);

            sql = "update account set money=money+500 where id = 1002";
            st.executeUpdate(sql);

            //提交事务
            conn.commit();

        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}

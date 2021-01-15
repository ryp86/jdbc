package com.aaa.rong.emp;

/**
 * @Author:ryp
 * @Description:
 * @Date: 2021/01/15/8:37
 */
public class AccountDAOImpl implements IAccountDAO {
    @Override
    public int add(Account a) {
        int result = 0;
        String sql = "insert into account values(?,?,?)";
        Object[] arr = {a.getId(),a.getName(),a.getMoney()};
        return BaseDBUtil.executeUpdate(sql, arr);
    }
}

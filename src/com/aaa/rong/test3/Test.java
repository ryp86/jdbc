package com.aaa.rong.test3;

import java.util.List;
import java.util.Map;

/**
 * @Author:ryp
 * @Description:
 * @Date: 2021/01/13/19:55
 */
public class Test {

    public static void main(String[] args) {

        String sql = "select * from dept";
        List<Map> maps = BaseDBUtil.executeQuery(sql, null);
        System.out.println(maps);

        sql = "select * from dept where deptno = ?";
        Object[] arr = {33};
        List<Map> maps1 = BaseDBUtil.executeQuery(sql, arr);
        System.out.println(maps1);
    }

}

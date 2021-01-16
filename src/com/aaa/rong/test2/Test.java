package com.aaa.rong.test2;

import java.util.List;
import java.util.Map;

/**
 * @Author:ryp
 * @Description:
 * @Date: 2021/01/13/19:02
 */
public class Test {

    public static void main(String[] args) {
        String sql = "select * from dept";
        List<Map> maps = BaseDBUtil.executeQuery(sql, null);

        System.out.println(maps);

        sql = "select * from dept where deptno=?";
        Object[] arr = {30};
        List<Map> maps1 = BaseDBUtil.executeQuery(sql, arr);
        System.out.println(maps1);

        sql = "insert into dept values(?,?,?)";
        Object[] arr1 = {33,"林琦部","法国"};
        int result = BaseDBUtil.executeUpdate(sql, arr1);
        if (result > 0 ) {
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }
    }

}

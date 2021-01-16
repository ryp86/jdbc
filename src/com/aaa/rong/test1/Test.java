package com.aaa.rong.test1;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author:ryp
 * @Description:
 * @Date: 2021/01/13/16:03
 */
public class Test {

    public static void main(String[] args) {
        String sql = "select * from emp";
        List<Map> maps = BaseDBUitl.executeQuery(sql, null);
        System.out.println(maps);
        /*Iterator<Map> iterator = maps.iterator();
        while (iterator.hasNext()) {
            Map map = iterator.next();
            System.out.println(map);
        }*/

        for (int i = 0; i < maps.size(); i++) {
            Map map = maps.get(i);
            Set set = map.entrySet();
            for (Object o : set) {
                System.out.println(o);
            }
        }

        String sql2 = "insert into emp values(null,?,?,?,?,?,?,?)";
        Object[] arr = {"智高超1","销售员1",5,"2021-01-08",2200,3000,30};
        int result = BaseDBUitl.executeUpdate(sql2, arr);
        if (result > 0) {
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }
    }

}

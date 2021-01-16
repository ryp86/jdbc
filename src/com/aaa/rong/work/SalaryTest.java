package com.aaa.rong.work;

import com.aaa.rong.util.BaseDB;

import java.util.Map;
import java.util.Scanner;

/**
 * @Author:ryp
 * @Description:
 * @Date: 2021/01/13/20:01
 */
public class SalaryTest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入姓名：");
        String name = scan.next();
        System.out.println("请输入税前工资：");
        double sq = scan.nextDouble();

        System.out.println(name + "--" + sq);

        //个人缴纳的五险一金
        double wx = sq * 0.185;
        //全月应纳税所得额
        double yn = sq - wx - 3500;
        //税率
        double sl = 0;
        //速算扣除数
        int ss = 0;
        if (yn <= 0) {
        } else if (yn <= 1500) {
            sl = 0.03;
        } else if (yn <= 4500) {
            sl = 0.1;
            ss = 105;
        } else if (yn <= 9500) {
            sl = 0.2;
            ss = 555;
        } else if (yn <= 35000) {
            sl = 0.25;
            ss = 1005;
        } else if (yn <= 55000) {
            sl = 0.3;
            ss = 2755;
        } else if (yn <= 80000) {
            sl = 0.35;
            ss = 5505;
        } else {
            sl = 0.45;
            ss = 13505;
        }
        //应缴个人所得税
        double gs = yn * sl - ss;

        //税后金额
        double sh = sq - wx - gs;

        String sql = "insert into salary values(?,?,?,?,?)";
        Object[] arr = {name,sq,wx,gs,sh};
        int result = BaseDB.executeUpdate(sql, arr);
        if (result > 0) {
            System.out.println(String.format("添加成功,添加信息：{姓名：%s,税前工资：%s," +
                    "五险一金：%s,个人所得税：%s,税后金额：%s",name,sq,wx,gs,sh));
        }else{
            System.out.println("添加失败");
        }
    }

}

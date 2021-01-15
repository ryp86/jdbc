package com.aaa.rong.emp;

import java.util.Scanner;

/**
 * @Author:ryp
 * @Description:
 * @Date: 2021/01/15/8:40
 */
public class AccountView {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入账户id");
        int id = scan.nextInt();
        System.out.println("请输入姓名");
        String name = scan.next();
        System.out.println("请输入存款");
        double money = scan.nextDouble();

        IAccountDAO accountDAO = new AccountDAOImpl();
        int result = accountDAO.add(new Account(id, name, money));
        if (result>0) {
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }
    }
}

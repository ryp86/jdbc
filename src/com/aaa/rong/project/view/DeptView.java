package com.aaa.rong.project.view;

import com.aaa.rong.project.dao.DeptDAOImpl;
import com.aaa.rong.project.dao.IDeptDAO;
import com.aaa.rong.project.pojo.Dept;
import com.aaa.rong.project.util.BaseDBUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author:ryp
 * @Description:
 * @Date: 2021/01/14/9:20
 */
public class DeptView {

    private static IDeptDAO deptDAO = new DeptDAOImpl();

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            printView();
            System.out.println("请选择：(1~5)");
            int check = 0;
            while (true) {
                check = scan.nextInt();
                if (check == 1 || check == 2 || check == 3 || check == 4 || check == 5) {
                    break;
                }
                System.out.println("输入错误，请重试：");
            }

            if (check == 1) {
                queryAll();
            }
            if (check == 2) {
                add();
            }
            if (check == 3) {
                update();
            }
            if (check == 4) {
                delete();
            }
            if (check == 5) {
                if (exit()) {
                    System.out.println("退出成功");
                    scan.close();
                    return;
                }
            }
        }
    }

    private static void queryAll() {
        List list = deptDAO.queryAll();
        System.out.println("----【部门信息】----\n");
        System.out.println("部门编号\t\t部门名称\t\t所在地");
        for (Object o : list) {
            Map map = (HashMap) o;
            System.out.println(map.get("deptno") + "\t\t\t" + map.get("dname") + "\t\t" + map.get("loc"));
        }
    }

    private static void add() {
        System.out.println("----【新增部门】----\n");
        System.out.println("请输入部门编号:");
        int deptno = scan.nextInt();
        System.out.println("请输入部门名称:");
        String dname = scan.next();
        System.out.println("请输入部门所在的城市:");
        String loc = scan.next();

        //调用DAO层
        int result = deptDAO.add(new Dept(deptno, dname, loc));
        if (result > 0) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }

    private static void update() {
        System.out.println("----【修改部门】----\n");
        System.out.println("请输入要修改的部门编号:");
        int deptno = 0;
        List<Map> list = null;
        while (true) {
            deptno = scan.nextInt();
            list = deptDAO.queryById(deptno);
            if (list.size() > 0) {
                break;
            }
            System.out.println("无此部门,请重新输入：");
        }
        scan.nextLine();
        System.out.println("请输入部门名称:(不修改直接回车)");
        String dname = scan.nextLine();
        dname = readString(dname, list.get(0).get("dname").toString());
        System.out.println(dname);

        System.out.println("请输入部门所在的城市:(不修改直接回车)");
        String loc = scan.nextLine();
        loc = readString(loc, list.get(0).get("dname").toString());

        int result = deptDAO.update(new Dept(deptno, dname, loc));
        if (result > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    private static void delete() {

        System.out.println("----【删除部门】----\n");
        System.out.println("请输入要删除的部门编号:");

        int deptno = 0;
        List<Map> list = null;
        while (true) {
            deptno = scan.nextInt();
            list = deptDAO.queryById(deptno);
            if (list.size() > 0) {
                break;
            }
            System.out.println("无此部门,请重新输入：");
        }
        String dname = list.get(0).get("dname").toString();
        System.out.println("是否确定【" + dname + "】删除？(y/n)");
        String isFlag = scan.next().toUpperCase();
        if (isFlag.equals("Y")) {
            //调用DAO层
            int result = deptDAO.deleteById(deptno);
            if (result > 0) {
                System.out.println("成功");
            } else {
                System.out.println("失败");
            }
        }
    }

    public static boolean exit() {
        System.out.println("是否确定退出？(y/n)");
        String isFlag = scan.next().toUpperCase();
        if (isFlag.equals("Y")) {
            return true;
        }
        return false;
    }

    /**
     * 主界面
     */
    public static void printView() {
        System.out.println("\n----【部门管理】----");
        System.out.println("    1.查看部门");
        System.out.println("    2.新增部门");
        System.out.println("    3.修改部门");
        System.out.println("    4.删除部门");
        System.out.println("    5.退出");
    }

    /**
     * 从键盘读取一个字符，并将其作为方法的返回值。
     * 如果用户不输入字符而直接回车，方法将以defaultValue 作为返回值。
     */
    public static String readString(String str, String defaultValue) {
        return (str.length() == 0) ? defaultValue : str;
    }
}

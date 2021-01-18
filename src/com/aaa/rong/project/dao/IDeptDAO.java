package com.aaa.rong.project.dao;

import com.aaa.rong.project.pojo.Dept;

import java.util.List;

/**
 * @Author:ryp
 * @Description:
 * @Date: 2021/01/14/9:11
 */
public interface IDeptDAO {

    /**
     * 新增
     * @param dept 部门对象
     * @return 受影响的行数
     */
    int add(Dept dept);

    /**
     * 修改
     * @param dept 部门对象
     * @return 受影响的行数
     */
    int update(Dept dept);

    /**
     * 删除
     * @param deptno 部门编号
     * @return 受影响的行数
     */
    int deleteById(int deptno);

    /**
     * 根据主键查询
     * @param deptno 部门编号
     * @return 受影响的行数
     */
    List queryById(int deptno);

    /**
     * 根据地址查询
     * @param loc 部门地址
     * @return 受影响的行数
     */
    List queryByLoc(String loc);

    /**
     * 根据多字段查找
     * @param dept
     * @return
     */
    List queryByDept(Dept dept);

    /**
     * 查询所有
     * @return
     */
    List queryAll();

    /**
     * 分页查询
     * @param start 从第几位开始
     * @param size 查找多少个
     * @return
     */
    List queryLimit(int start, int size);
}

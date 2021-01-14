package com.aaa.rong.project.dao;

import com.aaa.rong.project.pojo.Dept;
import com.aaa.rong.project.util.BaseDBUtil;
import com.aaa.rong.util.BaseDB;

import java.util.List;
import java.util.Map;

/**
 * @Author:ryp
 * @Description:
 * @Date: 2021/01/14/9:14
 */
public class DeptDAOImpl implements IDeptDAO {

    /**
     * 新增
     *
     * @param dept 部门对象
     * @return 受影响的行数
     */
    @Override
    public int add(Dept dept) {
        String sql = "insert into dept values(?,?,?)";
        Object[] arr = {dept.getDeptno(), dept.getDname(), dept.getLoc()};
        return BaseDBUtil.executeUpdate(sql, arr);
    }

    /**
     * 修改
     *
     * @param dept 部门对象
     * @return 受影响的行数
     */
    @Override
    public int update(Dept dept) {
        String sql = "update dept set dname = ?,loc = ? where deptno = ?";
        Object[] arr = {dept.getDname(), dept.getLoc(), dept.getDeptno()};
        return BaseDBUtil.executeUpdate(sql, arr);
    }

    /**
     * 删除
     *
     * @param deptno 部门编号
     * @return 受影响的行数
     */
    @Override
    public int deleteById(int deptno) {
        String sql = "delete from dept where deptno = ?";
        Object[] arr = {deptno};
        return BaseDBUtil.executeUpdate(sql, arr);
    }

    /**
     * 根据主键查询
     *
     * @param deptno 部门编号
     * @return 受影响的行数
     */
    @Override
    public List queryById(int deptno) {
        String sql = "select deptno,dname,loc from dept where deptno = ?";
        Object[] arr = {deptno};
        List list = BaseDBUtil.executeQuery(sql, arr);
        return list;
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List queryAll() {
        String sql = "select deptno,dname,loc from dept";
        List list = BaseDBUtil.executeQuery(sql, null);
        return list;
    }

    /**
     * 分页查询
     *
     * @param start 从第几位开始
     * @param size  查找多少个
     * @return
     */
    @Override
    public List queryLimit(int start, int size) {
        String sql = "select deptno,dname,loc from dept limit ?,?";
        Object[] arr = {start, size};
        List list = BaseDBUtil.executeQuery(sql, arr);
        return list;
    }
}


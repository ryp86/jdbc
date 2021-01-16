package com.aaa.rong.emp;

import java.util.Date;

/**
 * @Description  
 * @Author  rong
 * @Date 2021-01-15 
 */

public class Emp {


	/**
	 * 员工编号
	 */
	private int empno;

	/**
	 * 员工姓名
	 */
	private String ename;

	/**
	 * 员工职位
	 */
	private String job;

	/**
	 * 员工对应的上级领导编号
	 */
	private int mgr;

	/**
	 * 入职日期
	 */
	private Date hiredate;

	/**
	 * 员工工资
	 */
	private double sal;

	/**
	 * 员工提成
	 */
	private double comm;

	/**
	 * 员工所在部门编号
	 */
	private int deptno;

	public int getEmpno() {
		return this.empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return this.mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public Date getHiredate() {
		return this.hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public double getSal() {
		return this.sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public double getComm() {
		return this.comm;
	}

	public void setComm(double comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return this.deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

}

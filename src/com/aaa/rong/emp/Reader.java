package com.aaa.rong.emp;


/**
 * @Description  
 * @Author  rong
 * @Date 2021-01-15 
 */

public class Reader {

	/**
	 * id
	 */
	private int readerId;

	/**
	 * 公司
	 */
	private String company;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 性别
	 */
	private String sex;

	private String grade;

	private String addr;

	public int getReaderId() {
		return this.readerId;
	}

	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}

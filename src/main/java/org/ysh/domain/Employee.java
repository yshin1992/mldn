package org.ysh.domain;

import java.util.Date;

/**
 * 雇员实体类
 * @author yshin1992
 *
 */
public class Employee implements Entity {
	/**
	 * 雇员号
	 */
	private int empNo;
	
	/**
	 * 雇员姓名
	 */
	private String empName;
	
	/**
	 * 雇员职位
	 */
	private String job;
	
	/**
	 * 雇佣日期
	 */
	private Date hireDate;
	
	/**
	 * 工资
	 */
	private Double sal;
	
	/**
	 * 奖金
	 */
	private Double comm;

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public Double getComm() {
		return comm;
	}

	public void setComm(Double comm) {
		this.comm = comm;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", job="
				+ job + ", hireDate=" + hireDate + ", sal=" + sal + ", comm="
				+ comm + "]";
	}
	
}

package org.ysh.domain;

public class Dept implements Entity {
	
	private int deptNo;
	
	private String deptName;
	
	private String deptLoc;

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptLoc() {
		return deptLoc;
	}

	public void setDeptLoc(String deptLoc) {
		this.deptLoc = deptLoc;
	}

	@Override
	public String toString() {
		return "Dept [deptNo=" + deptNo + ", deptName=" + deptName
				+ ", deptLoc=" + deptLoc + "]";
	}
	
}

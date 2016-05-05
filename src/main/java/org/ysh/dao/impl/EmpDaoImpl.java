package org.ysh.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.ysh.dao.AbstractDao;
import org.ysh.domain.Employee;
import org.ysh.util.DaoUtil;

public class EmpDaoImpl implements AbstractDao<Employee> {

	private static final String SQL_EMP_ADD = "insert into emp(empno,ename,job,hiredate,sal,comm) "
			+ "values(?,?,?,?,?,?)";
	
	public void batchCreate(List<Employee> empList){
		if(null == empList || empList.size() == 0)
			return;
		Connection con = DaoUtil.getConn();
		PreparedStatement pstm = null;
		
		try{
			con.setAutoCommit(false);
			pstm = con.prepareStatement(SQL_EMP_ADD);
			
			for(Employee emp : empList){
				pstm.setInt(1, emp.getEmpNo());
				pstm.setString(2, emp.getEmpName());
				pstm.setString(3, emp.getJob());
				pstm.setDate(4, new Date( emp.getHireDate().getTime()));
				pstm.setDouble(5, emp.getSal());
				pstm.setDouble(6, emp.getComm());
				pstm.addBatch();
				
			}
			pstm.executeBatch();
			con.commit();
		}catch(Exception e){
			e.printStackTrace();
			try{
				con.rollback();
			}catch(SQLException sq){
				sq.printStackTrace();
			}
		}finally{
			DaoUtil.closeStmt(pstm);
			DaoUtil.closeConn(con);
		}
	}
	
	@Override
	public void create(Employee emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Employee emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> reverse(Employee emp, boolean fuzzy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Employee emp) {
		// TODO Auto-generated method stub
		
	}

}

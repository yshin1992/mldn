package org.ysh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.ysh.dao.AbstractDao;
import org.ysh.domain.Dept;
import org.ysh.util.DaoUtil;

public class DeptDaoImpl implements AbstractDao<Dept> {

	private static final String SQL_QUERY_ALL = "select deptno,dname,loc from dept";
	
	public void create(Dept arg0) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Dept arg0) {
		// TODO Auto-generated method stub
		
	}

	public List<Dept> reverse(Dept dept, boolean fuzzy) {
		// TODO Auto-generated method stub
		if(null == dept)
		{
			ResultSet rs=null;
			PreparedStatement pstm = null;
			Connection conn = null;
			try{
				conn = DaoUtil.getConn();
				pstm = conn.prepareStatement(SQL_QUERY_ALL);
				rs = pstm.executeQuery();
				List<Dept> resList = new ArrayList<Dept>();
				while(rs.next()){
					Dept tmp = new Dept();
					tmp.setDeptNo(rs.getInt(1));
					tmp.setDeptName(rs.getString(2));
					tmp.setDeptLoc(rs.getString(3));
					resList.add(tmp);
				}
				return resList;
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DaoUtil.closeResultSet(rs);
				DaoUtil.closeStmt(pstm);
				DaoUtil.closeConn(conn);
			}
		}
		return null;
	}

	public void update(Dept arg0) {
		// TODO Auto-generated method stub
		
	}

}

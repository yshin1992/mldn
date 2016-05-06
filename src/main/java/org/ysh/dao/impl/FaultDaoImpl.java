package org.ysh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.ysh.dao.AbstractDao;
import org.ysh.domain.Fault;
import org.ysh.util.DaoUtil;

public class FaultDaoImpl implements AbstractDao<Fault> {

	private static final String QUERY_ALL = "select id,machinery_id,fault_code,begin_time,end_time,begin_longitude,"
			+ "begin_latitude,end_longitude,end_latitude from bs_fault_machinery_log order by id desc limit ?,?";
	
	@Override
	public void create(Fault arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Fault arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Fault> reverse(Fault fault, boolean fuzzy) {
		return null;
	}

	@Override
	public void update(Fault arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Fault> reverse(long startIndex,int count){
		Connection conn = DaoUtil.getConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			pstm = conn.prepareStatement(QUERY_ALL);
			pstm.setLong(1, startIndex);
			pstm.setInt(2, count);
			rs = pstm.executeQuery();
			List<Fault> faultList = new ArrayList<Fault>();
			while(rs.next()){
				Fault fault = new Fault();
				fault.setId(rs.getLong(1));
				fault.setMachineryId(rs.getLong(2));
				fault.setFaultCode(rs.getString(3));
				fault.setBeginTime(rs.getTimestamp(4));
				fault.setEndTime(rs.getTimestamp(5));
				fault.setBeginLongitude(rs.getDouble(6));
				fault.setBeginLatitude(rs.getDouble(7));
				fault.setEndLongitude(rs.getDouble(8));
				fault.setEndLatitude(rs.getDouble(9));
				faultList.add(fault);
			}
			return faultList;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DaoUtil.closeResultSet(rs);
			DaoUtil.closeStmt(pstm);
			DaoUtil.closeConn(conn);
		}
		return null;
	}

}

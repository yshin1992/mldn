package org.ysh.servlet.business;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.ysh.domain.Fault;
import org.ysh.util.DaoUtil;

public class TomcatDataSourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final static String DSNAME = "java:comp/env/jdbc/mldn";
	private static final String QUERY_ALL = "select id,machinery_id,fault_code,begin_time,end_time,begin_longitude,"
			+ "begin_latitude,end_longitude,end_latitude from bs_fault_machinery_log order by id desc limit ?,?";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup(DSNAME);
			Connection conn = ds.getConnection();
			PreparedStatement pstm = null;
			ResultSet rs = null;
			try{
				pstm = conn.prepareStatement(QUERY_ALL);
				pstm.setLong(1, 0);
				pstm.setInt(2,10);
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
				request.setAttribute("faultList", faultList);
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DaoUtil.closeResultSet(rs);
				DaoUtil.closeStmt(pstm);
				DaoUtil.closeConn(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("datasource/TomcatDataSource.jsp").forward(request, response);
		
	}

}

package org.ysh.restful;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.ysh.cache.dao.FaultCacheDao;
import org.ysh.cache.dao.impl.FaultCacheDaoImpl;
import org.ysh.domain.Fault;

@Path("/fault")
public class FaultAPI {
	
	private FaultCacheDao faultCacheDao = new FaultCacheDaoImpl();
	
	@POST
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Fault> queryFaultsByPage(@FormParam("page") Integer page)
	{
		page = page == null?1:page;
		return faultCacheDao.getFaultList(page);
	}
	
}

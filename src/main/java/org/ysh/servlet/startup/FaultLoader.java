package org.ysh.servlet.startup;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.ysh.cache.dao.FaultCacheDao;
import org.ysh.cache.dao.impl.FaultCacheDaoImpl;
import org.ysh.dao.impl.FaultDaoImpl;
import org.ysh.domain.Fault;
import org.ysh.enums.PushStrategy;

public class FaultLoader extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private FaultDaoImpl faultDao = new FaultDaoImpl();
	
	private FaultCacheDao faultCacheDao = new FaultCacheDaoImpl();
	
	private static long _init_index_start;
	
	private static int _init_count;
	
	private static int _page_size;
	
	private static long _period; //3 min
	
    @Override
	public void init(ServletConfig config) throws ServletException {
    	super.init(config);
		_init_index_start = Integer.parseInt(config.getInitParameter("init_index_start"));
        _init_count=Integer.parseInt(config.getInitParameter("init_count"));
        _page_size=Integer.parseInt(config.getInitParameter("page_size"));
        _period=Long.parseLong(config.getInitParameter("period"));
        
        loadFault(_init_index_start,_init_count,PushStrategy.RPUSH);
        new Timer().schedule(new FaultLoaderTimer(), _period , _period);
	}

	public FaultLoader() {
        super();
    }
    
    private void loadFault(long start,int end ,PushStrategy pushStrategy){
    	List<Fault> faultList = faultDao.reverse(start, end);
    	faultCacheDao.addFaultList(faultList,pushStrategy);
    }
    
    class FaultLoaderTimer extends TimerTask{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			loadFault(_init_index_start,_page_size,PushStrategy.LPUSH);
		}
    	
    }
}


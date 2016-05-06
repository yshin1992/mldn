package org.ysh.servlet.startup;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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
	
	private static final long _init_index_start = 0;
	
	private static final int _init_count = 100;
	
	private static final int _page_size = 10;
	
	private static final long _period = 3*60*1000; //3 min
	
    public FaultLoader() {
        super();
        loadFault(_init_index_start,_init_count,PushStrategy.RPUSH);
        new Timer().schedule(new FaultLoaderTimer(), _period , _period);
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


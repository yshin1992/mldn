package org.ysh.cache.dao;

import java.util.List;

import org.ysh.domain.Fault;
import org.ysh.enums.PushStrategy;

public interface FaultCacheDao {
	
	public void addFaultList(List<Fault> faultList, PushStrategy strategy);

	List<Fault> getFaultList(int page);
}

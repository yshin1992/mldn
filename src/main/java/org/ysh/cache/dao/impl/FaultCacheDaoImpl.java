package org.ysh.cache.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.ysh.cache.dao.FaultCacheDao;
import org.ysh.domain.Fault;
import org.ysh.enums.PushStrategy;
import org.ysh.redis.share.JedisSharedPoolUtil;

import redis.clients.jedis.ShardedJedis;

/**
 * 故障CacheDao
 * @author Administrator
 *
 */
public class FaultCacheDaoImpl implements FaultCacheDao{
	
	private static final String NAMESPACE_FAULT = "fault:";
	
	private static final String NAMESPACE_FAULT_LIST = "faultList";
	
	private static final int PAGE_SIZE = 10;
	
	private static final String[] fields = {"id","machineryId","faultCode","beginTime","endTime",
											"beginLongitude","beginLatitude","endLongitude","endLatitude"};
	
	private void abandonFaults(ShardedJedis jedis){
		List<String> keys = jedis.lrange(NAMESPACE_FAULT_LIST, 0, -1);
		if(null != keys && keys.size()> 90){
			int keySize = keys.size();
			for(int i = keySize-1,j = keySize-10;i>=j;i--){
				String key = jedis.rpop(NAMESPACE_FAULT_LIST);
				jedis.del(key);
			}
		}
	}
	
	@Override
	public void addFaultList(List<Fault> faultList , PushStrategy strategy) {
		// TODO Auto-generated method stub
		if(null != faultList && faultList.size() > 0){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ShardedJedis jedis = JedisSharedPoolUtil.getResource();
			abandonFaults(jedis);//丢弃一部分旧数据
			for(Fault fault : faultList){
				String key = NAMESPACE_FAULT + fault.getId();
				if(jedis.hexists(key, fields[0])){
					System.out.println(key+"已经存在");
					continue;
				}
				jedis.hset(key, fields[0],String.valueOf(fault.getId()));
				jedis.hset(key, fields[1], String.valueOf(fault.getMachineryId()));
				jedis.hset(key, fields[2], fault.getFaultCode());
				if(null != fault.getBeginTime()){
					jedis.hset(key, fields[3], sdf.format(fault.getBeginTime()));
				}
				if(null != fault.getEndTime()){
					jedis.hset(key, fields[4], sdf.format(fault.getEndTime()));
				}
				jedis.hset(key, fields[5], String.valueOf(fault.getBeginLongitude()));
				jedis.hset(key, fields[6], String.valueOf(fault.getBeginLatitude()));
				jedis.hset(key, fields[7], String.valueOf(fault.getEndLongitude()));
				jedis.hset(key, fields[8], String.valueOf(fault.getEndLatitude()));
				if(PushStrategy.LPUSH == strategy){
					jedis.lpush(NAMESPACE_FAULT_LIST, key);
				}
				else{
					jedis.rpush(NAMESPACE_FAULT_LIST, key);
				}
			}
			JedisSharedPoolUtil.returnResource(jedis);
		}
	}
	
	@Override
	public List<Fault> getFaultList(int page){
		ShardedJedis jedis = JedisSharedPoolUtil.getResource();
		List<String> keys = jedis.lrange(NAMESPACE_FAULT_LIST, (page-1)*PAGE_SIZE, page*PAGE_SIZE);
		if(null != keys && keys.size() > 0){
			List<Fault> faultList = new ArrayList<Fault>();	
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for(String key : keys){
				if(jedis.exists(key)){
					Fault fault = new Fault();
					fault.setId(Long.valueOf(jedis.hget(key, fields[0])));
					fault.setMachineryId(Long.valueOf(jedis.hget(key, fields[1])));
					fault.setFaultCode(jedis.hget(key, fields[2]));
					try {
						if(null != jedis.hget(key, fields[3])){
							fault.setBeginTime(sdf.parse(jedis.hget(key, fields[3])));
						}
						if(null != jedis.hget(key, fields[4])){
							fault.setEndTime(sdf.parse(jedis.hget(key, fields[4])));
						}
					} catch (ParseException e) {
						e.printStackTrace();
					}
					fault.setBeginLongitude(Double.valueOf(jedis.hget(key, fields[5])));
					fault.setBeginLatitude(Double.valueOf(jedis.hget(key, fields[6])));
					fault.setEndLongitude(Double.valueOf(jedis.hget(key, fields[7])));
					fault.setEndLatitude(Double.valueOf(jedis.hget(key, fields[8])));
					
					faultList.add(fault);
				}
			}
			JedisSharedPoolUtil.returnResource(jedis);
			return faultList;
		}
		return null;
	}

}

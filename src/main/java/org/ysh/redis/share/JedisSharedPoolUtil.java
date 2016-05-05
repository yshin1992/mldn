package org.ysh.redis.share;

import java.util.ArrayList;
import java.util.List;

import org.ysh.redis.PoolCfg;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Jedis分片连接池(分布式) 
 * @author Administrator
 *
 */
public class JedisSharedPoolUtil {

	private static ShardedJedisPool shardedPool;
	
	static{
		JedisPoolConfig config = new JedisPoolConfig();//Jedis池配置
		config.setMaxTotal(PoolCfg.REDIS_MAX_TOTAL);
		config.setMaxIdle(PoolCfg.REDIS_MAX_IDLE);
		config.setMaxWaitMillis(PoolCfg.REDIS_MAX_WAIT_TIME);
		config.setTestOnBorrow(PoolCfg.REDIS_TEST_ON_BORROW);
		
		List<JedisShardInfo> infoList = new ArrayList<JedisShardInfo>();
		JedisShardInfo info1 = new JedisShardInfo(PoolCfg.REDIS_HOST, PoolCfg.REDIS_PORT);
		info1.setPassword(PoolCfg.REDIS_AUTH);
		infoList.add(info1);
		JedisShardInfo info2 = new JedisShardInfo(PoolCfg.REDIS_HOST, PoolCfg.REDIS_PORT_2);
		info2.setPassword(PoolCfg.REDIS_AUTH);
		infoList.add(info2);
		
		shardedPool = new ShardedJedisPool(config, infoList);
	}
	
	public static ShardedJedis getResource()
	{
		return shardedPool.getResource();
	}
	
	public static void returnResource(ShardedJedis jedis)
	{
		if(null != jedis){
			jedis.close();
		}
	}
}

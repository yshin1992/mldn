package org.ysh.redis.pool;

import org.ysh.redis.PoolCfg;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis连接池
 * @author Administrator
 *
 */
public class JedisPoolUtil {
	
	private static JedisPool jedisPool;
	
	static{
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(PoolCfg.REDIS_MAX_IDLE);
		config.setMaxTotal(PoolCfg.REDIS_MAX_TOTAL);
		config.setMaxWaitMillis(PoolCfg.REDIS_MAX_WAIT_TIME);
		config.setTestOnBorrow(PoolCfg.REDIS_TEST_ON_BORROW);
		jedisPool = new JedisPool(config, PoolCfg.REDIS_HOST, PoolCfg.REDIS_PORT,PoolCfg.REDIS_TIME_OUT,PoolCfg.REDIS_AUTH);
	}
	
	public static synchronized Jedis getResource()
	{
		return jedisPool.getResource();
	}
	
	public static void returnResource(Jedis jedis)
	{
		if(null != jedis){
			jedis.close();
		}
	}
}

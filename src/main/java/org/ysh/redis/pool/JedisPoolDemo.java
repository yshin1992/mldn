package org.ysh.redis.pool;

import redis.clients.jedis.Jedis;

public class JedisPoolDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		for(int i=0;i<210000;i++){
			new Thread(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					Jedis jedis = JedisPoolUtil.getResource();
					jedis.sadd("thread", String.valueOf(Thread.currentThread().getId()));
					JedisPoolUtil.returnResource(jedis);
				}
				
			}.start();
		}*/
		Jedis jedis = JedisPoolUtil.getResource();
		jedis.del("thread");
		JedisPoolUtil.returnResource(jedis);
	}

}

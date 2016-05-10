package org.ysh.redis.share;

import redis.clients.jedis.ShardedJedis;

public class JedisShardedPoolDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShardedJedis jedis = JedisSharedPoolUtil.getResource();
//		jedis.set("book:java", "Think in Java");
//		jedis.set("book:c++", "Tink in C++");
//		System.out.println(jedis.get("book:java"));
//		System.out.println(jedis.get("book:c++"));
//		List<String> faultIds = jedis.lrange("faultList", 0, -1);
//		for(String id : faultIds){
//			Long i = jedis.del(id);
//			System.out.println(i);
//		}
		jedis.del("faultList");
		JedisSharedPoolUtil.returnResource(jedis);
	}

}

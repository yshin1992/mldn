package org.ysh.redis.share;

import redis.clients.jedis.ShardedJedis;

public class JedisShardedPoolDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShardedJedis jedis = JedisSharedPoolUtil.getResource();
//		jedis.set("book:java", "Think in Java");
//		jedis.set("book:c++", "Tink in C++");
		System.out.println(jedis.get("book:java"));
		System.out.println(jedis.get("book:c++"));
		JedisSharedPoolUtil.returnResource(jedis);
	}

}

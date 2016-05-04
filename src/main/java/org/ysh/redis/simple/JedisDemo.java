package org.ysh.redis.simple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class JedisDemo {
	
	private static final String HOST_JEDIS = "10.30.30.123";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		testString();
//		testMap();
//		testList();
		testSet();
	}
	
	static void testString(){
		Jedis jedis = new Jedis(HOST_JEDIS);
		jedis.auth("lion");//认证
		jedis.set("username", "gimis");
		jedis.mset("age","24","gender","female","qq","432332091");
		System.out.println(jedis.get("username"));
		System.out.println(jedis.mget("qq","gender"));
		System.out.println(jedis.exists("tel"));
		jedis.incr("age");//进行加1操作
		jedis.close();
	}
	
	static void testMap(){
		Jedis jedis = new Jedis(HOST_JEDIS);
		jedis.auth("lion");//认证
		Map<String,String> userMap = new HashMap<String,String>();
		userMap.put("username", "ysh");
		userMap.put("age", "23");
		userMap.put("qq", "165892220");
		String key = "user#"+userMap.get("username");
		jedis.hmset(key, userMap);
		List<String> userInfoList = jedis.hmget(key, "username","qq");
		System.out.println(userInfoList);
		jedis.close();
	}
	
	static void testList()
	{
		Jedis jedis = new Jedis(HOST_JEDIS);
		jedis.auth("lion");//认证
		//先向key java framework中存放三条数据  
		jedis.lpush("java framework","spring");  
		jedis.lpush("java framework","struts");  
		jedis.lpush("java framework","hibernate");  
		jedis.llen("java framework");
		//再取出所有数据jedis.lrange是按范围取出，  
		// 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有  
		System.out.println(jedis.lrange("java framework",0,-1));  
		jedis.close();
	}
	
	static void testHSet(){
		Jedis jedis = new Jedis(HOST_JEDIS);
		jedis.auth("lion");
		
		jedis.hset("book_j2ee", "bookName", "Java EE");
		jedis.hset("book_j2ee", "price", "56.5");
		
		jedis.hset("book_javaCore", "bookName", "Java Core");
		jedis.hset("book_javaCore", "price", "78.65");
		
		Map<String,String> bookJ2EE = jedis.hgetAll("book_j2ee");
		System.out.println(bookJ2EE.entrySet());
		
		jedis.close();
	}
	
	static void testSet(){
		Jedis jedis = new Jedis(HOST_JEDIS);
		jedis.auth("lion");
		
		jedis.sadd("user", "wangxiaoming");
		jedis.sadd("user", "xiaoying");
		jedis.sadd("user", "taoshi");
		jedis.sadd("user", "xuetu");
		
		boolean exits = jedis.sismember("user", "xuetu");
		System.out.println(exits);
		
		jedis.srem("user", "xuetu","taoshi");
		
		System.out.println(jedis.smembers("user"));
		System.out.println(jedis.srandmember("user"));
		System.out.println(jedis.scard("user"));
		
		jedis.close();
	}
}

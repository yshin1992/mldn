package org.ysh.redis;

public interface PoolCfg {
	public static final String REDIS_HOST = "10.30.30.123";
	
	public static final int REDIS_PORT = 6379;
	
	public static final int REDIS_PORT_2 = 6381;
	
	public static final String REDIS_AUTH = "lion";
	
	public static final int REDIS_MAX_IDLE = 10;
	
	public static final int REDIS_MAX_TOTAL = 200;
	
	public static final boolean REDIS_TEST_ON_BORROW = true;
	
	public static final int REDIS_TIME_OUT = 10000;
	
	public static final int REDIS_MAX_WAIT_TIME = 10000;
}

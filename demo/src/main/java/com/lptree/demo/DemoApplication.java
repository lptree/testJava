package com.lptree.demo;

import com.lptree.demo.ConsistentHash.TestHash;
import com.lptree.demo.dynamicProxyTest.MyDynamicProxyTest;
import com.lptree.demo.testRedis.RedisTestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

@SpringBootApplication
public class DemoApplication {



	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

		//MyDynamicProxyTest.testCgibl();
		//TestHash.testNormal();

		//Collections.synchronizedMap();

		//testDate.test();

		RedisTestUtil redisTestUtil=(RedisTestUtil)ctx.getBean("RedisTestUtil");
		redisTestUtil.test2();
	}
}

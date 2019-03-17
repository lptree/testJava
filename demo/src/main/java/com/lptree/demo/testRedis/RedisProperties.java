/*
 * Copyright ®2017 juneyaoair Group.
 *
 *
 *
 */
package com.lptree.demo.testRedis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * redis配置
 *
 * @author jx-air
 * @version 1.0
 * @date 2018年3月12日 下午1:33:15
 */
@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {
    // prefix+参数名 对应于配置文件config.properties中的spring.redis.*信息
    /**
     * IP
     */
    private String host;


    /**
     * 端口号
     */
    private int port;
    // 超时时间
    /**
     * 超时时间
     */
    private int timeout;

    private int database;

    /**
     * #b2c 机场航班等数据
     */
    private int database2;

//	/**
//	 * 哨兵
//	 * */
//	@Value("${spring.redis.sentinel.nodes}")
//	private String[] sentinelNodes;

//	/**
//	 *redis server name
//	 * */
//	@Value("${spring.redis.sentinel.master}")
//	private String sentinelMaster;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getDatabase() {
        return database;
    }

    public void setDatabase(int database) {
        this.database = database;
    }

    public int getDatabase2() {
        return database2;
    }

    public void setDatabase2(int database2) {
        this.database2 = database2;
    }
//
//	public String[] getSentinelNodes() {
//		return sentinelNodes;
//	}
//
//	public void setSentinelNodes(String[] sentinelNodes) {
//		this.sentinelNodes = sentinelNodes;
//	}
//
//	public String getSentinelMaster() {
//		return sentinelMaster;
//	}
//
//	public void setSentinelMaster(String sentinelMaster) {
//		this.sentinelMaster = sentinelMaster;
//	}
}

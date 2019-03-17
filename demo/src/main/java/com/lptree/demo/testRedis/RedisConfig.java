/*
 * Copyright ®2017 juneyaoair Group.
 *
 *
 *
 */
package com.lptree.demo.testRedis;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * redis配置
 *
 * @author jx-air
 * @version 1.0
 * @date 2018年3月12日 下午1:33:15
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
    @Autowired
    private RedisProperties redisProperties;

    /**
     * 生产key的策略
     *
     * @return
     */

    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {

            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };

    }

    /**
     * 管理缓存
     *
     * @param redisTemplate
     * @return
     */
//
//    @SuppressWarnings("rawtypes")
//    @Bean
//    public CacheManager CacheManager(RedisTemplate redisTemplate) {
//        RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
//        // 设置cache过期时间,时间单位是秒
//        rcm.setDefaultExpiration(60);
//        Map<String, Long> map = new HashMap<String, Long>();
//        map.put("test", 60L);
//        rcm.setExpires(map);
//        return rcm;
//    }

    /**
     * redis哨兵配置
     * @return
     */
//    @Bean
//    public RedisSentinelConfiguration redisSentinelConfiguration(){
//        RedisSentinelConfiguration configuration = new RedisSentinelConfiguration();
//        String[] host = redisProperties.getSentinelNodes();
//        for(String redisHost : host){
//            String[] item = redisHost.split(":");
//            String ip = item[0];
//            String port = item[1];
//            configuration.addSentinel(new RedisNode(ip, Integer.parseInt(port)));
//        }
//        configuration.setMaster(redisProperties.getSentinelMaster());
//        return configuration;
//    }

    /**
     * redis 数据库连接池
     *
     * @return
     */

    public JedisConnectionFactory redisConnectionFactory_myself() {
        //JedisConnectionFactory factory = new JedisConnectionFactory(redisSentinelConfiguration());
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(redisProperties.getHost());
        factory.setPort(redisProperties.getPort());
        // 设置连接超时时间
        factory.setTimeout(redisProperties.getTimeout());
        factory.setDatabase(redisProperties.getDatabase());
        // 初始化连接pool
        factory.afterPropertiesSet();
        return factory;
    }

    public JedisConnectionFactory redisConnectionFactory_common() {
        //JedisConnectionFactory factory = new JedisConnectionFactory(redisSentinelConfiguration());
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(redisProperties.getHost());
        factory.setPort(redisProperties.getPort());
        // 设置连接超时时间
        factory.setTimeout(redisProperties.getTimeout());
        factory.setDatabase(redisProperties.getDatabase2());
        // 初始化连接pool
        factory.afterPropertiesSet();
        return factory;
    }

    /**
     * redisTemplate配置
     *
     * @param
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean(name = "myself_data")
    public RedisTemplate<String, String> redisTemplate_myself() {
        RedisConnectionFactory factory = redisConnectionFactory_myself();
        StringRedisTemplate template = new StringRedisTemplate(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        //template.setValueSerializer(jackson2JsonRedisSerializer);


        template.setStringSerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());

        template.afterPropertiesSet();
        return template;
    }

    /**
     * redisTemplate配置
     *
     * @param
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean(name = "common_data")
    public RedisTemplate<String, String> redisTemplate_common() {
        RedisConnectionFactory factory = redisConnectionFactory_common();
        StringRedisTemplate template = new StringRedisTemplate(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }
}
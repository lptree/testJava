package com.lptree.demo.testRedis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description:
 * @Author: lptree
 * @Date: Created in 2018/10/27 13:33
 */
@Component
public class RedisTestUtil {

    @Bean("RedisTestUtil")
    public RedisTestUtil getRedisTestUtil() {
        return new RedisTestUtil();
    }

    @SuppressWarnings("rawtypes")
    @Autowired
    @Qualifier("myself_data")
    private RedisTemplate redisTemplate;

    public void test() {
        String key = "pipline_incr";
        List<Long> List = redisTemplate.executePipelined(new RedisCallback<Long>() {
            @Nullable
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {

                connection.openPipeline();
                for (int i = 0; i < 1000000; i++) {

                    connection.incrBy(key.getBytes(), 1);
                }
                return null;
            }
        });
    }

    public void test2() {
        String key = "pipline_incr";
        //byte[] key = "pipline_incr".getBytes();
        List<String> List = redisTemplate.executePipelined(new RedisCallback<String>() {
            @Nullable
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {

                connection.openPipeline();

                connection.set("a".getBytes(),"aaa".getBytes());

                connection.set("b".getBytes(),"bbb".getBytes());
                connection.get("a".getBytes());

                connection.set("c".getBytes(),"ccc".getBytes());
                connection.get("b".getBytes());

                return null;
            }
        });
    }

    public void test3(){

    }
}

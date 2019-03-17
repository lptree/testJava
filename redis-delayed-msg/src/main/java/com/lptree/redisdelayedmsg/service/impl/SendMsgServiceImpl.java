package com.lptree.redisdelayedmsg.service.impl;

import com.lptree.redisdelayedmsg.redis.RedisUtil;
import com.lptree.redisdelayedmsg.service.SendMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: lptree
 * @Date: Created in 2019/3/17 23:10
 */
@Service
public class SendMsgServiceImpl implements SendMsgService {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public String one(String msg) {

        //redisUtil.zAdd()
        return null;
    }
}

package com.lptree.demo.ConsistentHash;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: lptree
 * @Date: Created in 2018/9/23 15:14
 */
@Data
public class Node {

    private String domain;

    private String ip;

    public Node(String domain, String ip) {
        this.domain = domain;
        this.ip = ip;
        this.data= new HashMap<>();
    }

    private Map<String, Object> data;

    public <T> void put(String key, T value) {
        data.put(key, value);
    }

    public void remove(String key) {
        data.remove(key);
    }

    public <T> T get(String key) {
        return (T) data.get(key);
    }
}

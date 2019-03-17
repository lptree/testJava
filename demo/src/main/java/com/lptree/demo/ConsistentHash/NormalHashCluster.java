package com.lptree.demo.ConsistentHash;

import java.util.HashMap;
import java.util.LinkedHashMap;

import static java.util.Objects.hash;

/**
 * @Description:
 * @Author: lptree
 * @Date: Created in 2018/9/23 15:23
 */
public class NormalHashCluster extends Cluster {

    public NormalHashCluster() {
        super();
    }

    @Override
    public void addNode(Node node) {
        this.nodes.add(node);
    }

    @Override
    public void removeNode(Node node) {
        this.nodes.removeIf(o -> o.getIp().equals(node.getIp()) ||
                o.getDomain().equals(node.getDomain()));
    }

    @Override
    public Node get(String key) {
        long hash = hash(key)&0x7FFFFFFF;
        long index =  hash % nodes.size();
        if(index<0){
            int a=0;
        }
        return nodes.get((int)index);
    }
}

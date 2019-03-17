package com.lptree.demo.ConsistentHash;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: lptree
 * @Date: Created in 2018/9/23 15:22
 */
public abstract class Cluster {

    protected List<Node> nodes;

    public Cluster() {
        this.nodes = new ArrayList<>();
    }

    public abstract void addNode(Node node);

    public abstract void removeNode(Node node);

    public abstract Node get(String key);
}

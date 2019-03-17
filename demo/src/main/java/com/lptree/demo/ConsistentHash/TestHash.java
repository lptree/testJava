package com.lptree.demo.ConsistentHash;

import java.util.stream.IntStream;

/**
 * @Description:
 * @Author: lptree
 * @Date: Created in 2018/9/23 15:29
 */
public class TestHash {

    private final static int DATA_COUNT = 50000;

    private final static String PRE_KEY = "TestCacheKey";


    public static void  testNormal(){
        Cluster cluster = new NormalHashCluster();
        cluster.addNode(new Node("c1.yywang.info", "192.168.0.1"));
        cluster.addNode(new Node("c2.yywang.info", "192.168.0.2"));
        cluster.addNode(new Node("c3.yywang.info", "192.168.0.3"));
        cluster.addNode(new Node("c4.yywang.info", "192.168.0.4"));

        IntStream.range(0, DATA_COUNT)
                .forEach(index -> {
                    Node node = cluster.get(PRE_KEY + index);
                    node.put(PRE_KEY + index, "Test Data");
                });

        System.out.println("数据分布情况：");
        cluster.nodes.forEach(node -> {
            System.out.println("IP:" + node.getIp() + ",数据量:" + node.getData().size());
        });

       //缓存命中率
        long hitCount = IntStream.range(0, DATA_COUNT)
                .filter(index -> cluster.get(PRE_KEY + index).get(PRE_KEY + index) != null)
                .count();
        System.out.println("缓存命中率：" + hitCount * 1f / DATA_COUNT);

        //增加一个节点
        cluster.addNode(new Node("c5.yywang.info", "192.168.0.5"));
        //缓存命中率
        hitCount = IntStream.range(0, DATA_COUNT)
                .filter(index -> cluster.get(PRE_KEY + index).get(PRE_KEY + index) != null)
                .count();
        System.out.println("(增加一个节点)缓存命中率：" + hitCount * 1f / DATA_COUNT);

        //比原始删除一个节点变为3个
        cluster.removeNode(new Node("c5.yywang.info", "192.168.0.5"));
        cluster.removeNode(new Node("c4.yywang.info", "192.168.0.4"));
        //缓存命中率
        hitCount = IntStream.range(0, DATA_COUNT)
                .filter(index -> cluster.get(PRE_KEY + index).get(PRE_KEY + index) != null)
                .count();
        System.out.println("(删除一个节点)缓存命中率：" + hitCount * 1f / DATA_COUNT);
    }

    public <T> void  testNormal1(T a){

    }

}

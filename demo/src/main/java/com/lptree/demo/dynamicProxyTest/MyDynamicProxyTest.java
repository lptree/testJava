package com.lptree.demo.dynamicProxyTest;

import com.lptree.demo.dynamicProxyTest.cglibTest.Ship;
import com.lptree.demo.dynamicProxyTest.cglibTest.ShipProxy;

import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Author: lptree
 * @Date: Created in 2018/10/7 7:04
 */
public class MyDynamicProxyTest {

    private static void testJDKProxy() {
        //Proxy.newProxyInstance()
    }

    public static void testCgibl() {
        //创建我们的代理类
        ShipProxy Proxy = new ShipProxy();
        Ship ship = (Ship) Proxy.getProxy(Ship.class);
        ship.travel();
    }
}

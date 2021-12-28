package com.ty.demo.test.testAop;

import java.lang.reflect.Proxy;

public class TestAop2 {
    public static void main(String[] args) {
        Leader leader=new Leader();
        IWork proxy=(IWork) Proxy.newProxyInstance(Leader.class.getClassLoader(),
                new Class[]{IWork.class}, new WorkInvocationHandler(leader));
        proxy.meeting();
        proxy.evaluate("托尼");
        proxy.evaluate("汤姆");
    }
}

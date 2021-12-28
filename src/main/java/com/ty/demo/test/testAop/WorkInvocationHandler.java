package com.ty.demo.test.testAop;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class WorkInvocationHandler implements InvocationHandler {
    private  Object object;

    public  WorkInvocationHandler(Object object){
        this.object=object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(object.getClass().getSimpleName());
        System.out.println("proxy"+proxy.getClass().getSimpleName());
        if ("meeting".equals(method.getName())){
            System.out.println("代理准备材料...........");
            return  method.invoke(object,args);
        }else if ("evaluate".equals(method.getName())){
            if (args[0] instanceof String){
                if ("汤姆".equals(args[0])){
                    System.out.println("汤姆 犯过错误，所以考评分数较低...");
                    return 70;
                }
            }
            return method.invoke(object,args);
        }
        return null;
    }

}

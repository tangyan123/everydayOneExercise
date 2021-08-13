package com.ty.demo.TestAop;

public class Secretary implements IWork {
    private  Leader leader;

    public  Secretary(Leader leader){
        this.leader=leader;
    }
    @Override
    public void meeting() {
        System.out.println("秘书先给老板准备材料");
        leader.meeting();
    }

    @Override
    public int evaluate(String name) {
        return leader.evaluate(name);
    }
}

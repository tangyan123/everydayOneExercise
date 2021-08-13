package com.ty.demo.TestAop;

public class TestAop1 {
    public static void main(String[] args) {
        Leader leader=new Leader();
        Secretary secretary=new Secretary(leader);
        secretary.meeting();
        secretary.evaluate("托尼");
    }
}

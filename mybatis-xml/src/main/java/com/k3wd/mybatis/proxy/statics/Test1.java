package com.k3wd.mybatis.proxy.statics;

public class Test1 {

    public static void main(String[] args) {
        TargetInterface targetInterface = new TargetInterfaceImpl();
        targetInterface.sayHello("张无忌");
    }
}

package com.k3wd.mybatis.proxy.cglib;

public class TargetInterfaceImpl implements TargetInterface {

    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }

    @Override
    public String sayThanks(String name) {
        return "Thanks, " + name;
    }
}

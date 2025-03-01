package com.example.jdk8.proxy;

public interface IConfig {
    @Value("db.url")
    String dbUrl();

    @Value("db.validation")
    boolean isValidated();

    @Value("db.pool.size")
    int poolSize();
    /**
     * 动态代理的原理：
     * 用一个类加载器和真实类实现的一组接口，以及实现了InvocationHandler的处理器，生成一个代理类对象，
     * (生成类对象的过程中会让代理类$Proxy0实现真实类实现的那一组接口，并生成$Proxy0的构造方法，同时在类$Proxy0中实现该组接口的方法，在方法中会调用处理器的invoke方法)
     * 生成类对象结束时，会把类对象作为字节码保存到磁盘。
     * 然后利用反射获取动态代理类$Proxy0的构造方法，构造函数的参数时处理器。
     * 通过动态代理类的构造函数获取动态代理类的实例，构造时把处理器作为参数传入。
     *
     */
}

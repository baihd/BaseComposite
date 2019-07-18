package com.composite.ioc4.springTest;

import com.composite.ioc4.annotation.MyComponent;
import com.composite.ioc4.applicationContext.AnnotationConfigApplicationContext;
import com.composite.ioc4.entity.PrototypeUser;
import com.composite.ioc4.entity.SingletonUser;

@MyComponent
public class TestSpringIOC {

    public static void main(String[] args) {
        String entity = "com.composite.ioc4.entity";
        //创建AnnotationConfigApplicationContext对象
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(entity);
        //仅使用key作为参数获取对象，需要强转
        SingletonUser singletonUser1 = (SingletonUser) ctx.getBean("singletonUser");
        System.out.println("单例User对象:" + singletonUser1);
        //使用key和类对象作为参数获取对象，无需强转
        SingletonUser singletonUser2 = ctx.getBean("singletonUser", SingletonUser.class);
        System.out.println("单例User对象:" + singletonUser2);
        //仅使用key作为参数获取对象，需要强转
        PrototypeUser prototypeUser1 = (PrototypeUser) ctx.getBean("prototypeUser");
        System.out.println("多例User对象:" + prototypeUser1);
        //使用key和类对象作为参数获取对象，无需强转
        PrototypeUser prototypeUser2 = ctx.getBean("prototypeUser", PrototypeUser.class);
        System.out.println("多例User对象:" + prototypeUser2);
        //销毁资源
        ctx.close();
    }


}

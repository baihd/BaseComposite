package com.composite.di4.springTest;


import com.composite.di4.annotation.MyComponent;
import com.composite.di4.applicationContext.AnnotationConfigApplicationContext;
import com.composite.di4.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@MyComponent
public class TestSpringIOC {

    //创建AnnotationConfigApplicationContext对象
    AnnotationConfigApplicationContext context;
    //创建UserService对象
    UserService userService;

    @BeforeEach
    public void init() {
        String entity = "com.composite.di4.entity";
        String service = "com.composite.di4.service";
        String springTest = "com.composite.di4.springTest";
        //实例化工厂类，传入entity/service/springTest三个包路径进行扫描
        context = new AnnotationConfigApplicationContext(entity, service, springTest);
        //调用工厂的getBean方法动态获取对象
        userService = context.getBean("userService", UserService.class);
    }


    @Test
    public void testSpringDI() {
        userService.userLogin();
    }

    @AfterEach
    public void close() {
        context.close();
    }


}

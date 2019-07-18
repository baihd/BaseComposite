package com.composite.ioc2.annotation;

import java.lang.annotation.*;

/**
 * 自定义服务的依赖注入
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface IocService {
    String name() default "";
}

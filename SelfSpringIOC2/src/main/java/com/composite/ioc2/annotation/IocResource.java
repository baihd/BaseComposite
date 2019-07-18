package com.composite.ioc2.annotation;

import java.lang.annotation.*;

/**
 * 自定义属性的依赖注入
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface IocResource {

}

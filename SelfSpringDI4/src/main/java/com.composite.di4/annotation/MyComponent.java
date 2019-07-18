package com.composite.di4.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Target 属性用于注明此注解用在什么位置, ElementType.TYPE表示可用在类、接口、枚举上等
 * @Retention 属性表示所定义的注解何时有效, RetentionPolicy.RUNTIME表示在运行时有效
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyComponent {

    String scope() default "";
}

package net.felix.demo.simpledemo;

import java.lang.annotation.*;

/**
 * net.felix.demo.simpledemo <br>
 * <p>
 * Copyright: Copyright (c) 2017/5/26 12:56
 * <p>
 * Copyright: DEMO
 * <p>
 *
 * @version 1.0.0
 * @auther felixfeng086@hotmail.com
 *
 * 水果名称注解
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}

package net.felix.demo.simpledemo;

import java.lang.annotation.*;

/**
 * net.felix.demo.simpledemo <br>
 * <p>
 * Copyright: Copyright (c) 2017/5/26 13:03
 * <p>
 * Copyright: DEMO
 * <p>
 *
 * @version 1.0.0
 * @auther felixfeng086@hotmail.com
 *
 * 水果供应商注解
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    /**
     * 水果供应商编号
     * */
    public int id() default -1;

    /**
     * 供应商名称
     * */
    public String name() default "";

    /**
     * 供应商地址
     * */
    public String address() default "";
}

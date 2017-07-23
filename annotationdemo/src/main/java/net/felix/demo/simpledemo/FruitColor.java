package net.felix.demo.simpledemo;

import java.lang.annotation.*;

/**
 * net.felix.demo.simpledemo <br>
 * <p>
 * Copyright: Copyright (c) 2017/5/26 13:00
 * <p>
 * Copyright: DEMO
 * <p>
 *
 * @version 1.0.0
 * @auther felixfeng086@hotmail.com
 *
 * 水果颜色注解
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
    /**
     * 颜色枚举
     * */
    public enum Color {BLUE, RED, GREEN};

    /**
     * 颜色属性
     * */
    Color fruitColor() default Color.GREEN;

}

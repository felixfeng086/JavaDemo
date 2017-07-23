package net.felix.demo.repeatabledemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * net.felix.demo.repeatabledemo <br>
 * <p>
 * Copyright: Copyright (c) 2017/5/29 21:19
 * <p>
 * Copyright: DEMO
 * <p>
 *
 * @version 1.0.0
 * @auther felixfeng086@hotmail.com
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Filters {
    Filter[] value();
}

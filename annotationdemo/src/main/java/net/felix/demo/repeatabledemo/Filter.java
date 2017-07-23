package net.felix.demo.repeatabledemo;

import java.lang.annotation.*;

/**
 * net.felix.demo.repeatabledemo <br>
 * <p>
 * Copyright: Copyright (c) 2017/5/29 21:17
 * <p>
 * Copyright: DEMO
 * <p>
 *
 * @version 1.0.0
 * @auther felixfeng086@hotmail.com
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Filters.class)
public @interface Filter {
    String value();
}

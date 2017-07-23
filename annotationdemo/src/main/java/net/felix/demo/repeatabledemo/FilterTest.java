package net.felix.demo.repeatabledemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * net.felix.demo.repeatabledemo <br>
 * <p>
 * Copyright: Copyright (c) 2017/5/29 21:22
 * <p>
 * Copyright: DEMO
 * <p>
 *
 * @version 1.0.0
 * @auther felixfeng086@hotmail.com
 *
 * 使用@Repeatable时告诉编译器，使用@Filters来作为收集重复注解的容器，而每个@Filter存储各自指定的字符串值。
 * JDK1.8在AnnotatedElement接口新增了getDeclaredAnnotationsByType和getAnnotationsByType，
 * 在指定@Repeatable的注解时，会寻找重复的注解。
 * 相对于，getDeclaredAnnotation和getAnnotation就不会处理@Repeatable注解
 */
@Filter("/admin")
@Filter("/main")
public class FilterTest {
    public static void main(String[] args) {
//        Class<FilterTest> filterTestClass = FilterTest.class;
        Filter[] filters = FilterTest.class.getAnnotationsByType(Filter.class);
        if (filters != null) {
            for (Filter filter : filters) {
                System.out.println(filter.value() + "|"  + filter.annotationType() + "|" +  filter.toString());
            }
        }
    }
}

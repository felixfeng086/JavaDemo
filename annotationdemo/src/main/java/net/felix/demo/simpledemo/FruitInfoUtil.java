package net.felix.demo.simpledemo;

import java.lang.reflect.Field;

/**
 * net.felix.demo.simpledemo <br>
 * <p>
 * Copyright: Copyright (c) 2017/5/26 13:19
 * <p>
 * Copyright: DEMO
 * <p>
 *
 * @version 1.0.0
 * @auther felixfeng086@hotmail.com
 */
public class FruitInfoUtil {

    public static void getFruitInfo(Class<?> clazz) {

        String strFruitName = "水果名称： ";
        String strFruitColor = "水果颜色： ";
        String strFruitProvider = "水果供应商： ";

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                strFruitName = strFruitName + fruitName.value();
                System.out.println(strFruitName);
            } else if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                strFruitColor = strFruitColor + fruitColor.fruitColor();
                System.out.println(strFruitColor);
            } else if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                strFruitProvider = strFruitProvider
                        + "供应商编号 " + fruitProvider.id() + " "
                        + "供应商名称 " + fruitProvider.name() + " "
                        + "供应商地址 " + fruitProvider.address();
                System.out.println(strFruitProvider);
            }
        }
    }
}

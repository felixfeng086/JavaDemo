import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * PACKAGE_NAME <br>
 * <p>
 * Copyright: Copyright (c) 2017/6/14 12:29
 * <p>
 * Copyright: DEMO
 * <p>
 *
 * @version 1.0.0
 * @auther felixfeng086@hotmail.com
 *
 * A.具有相同维数和元素类型的数组属于同一个类型，即具有相同的Class实例对象。
 * B.代表数组的Class实例对象的getSuperClass()方法返回的父类为Object类对应的Class。
 * C.基本类型的一维数组可以被当做Object类型使用，不能当做Object[]类型使用；非基本类型的一维数组，既可以当做Object类型使用，又可以当做Object[]类型使用。
 */
public class ArrayReflectTest {

    public static void main(String[] args) {
        int[] ia = {1, 2, 3};
        String[] sa = {"a", "b", "c"};
        printObject(ia);
        printObject(sa);
        printObject(Arrays.asList(ia));
        printObject(Arrays.asList(sa));
    }

    private static void printObject(Object obj) {
        Class cls = obj.getClass();
        if (cls.isArray()) {
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                System.out.println(Array.get(obj, i));
            }
            System.out.println();
        } else {
            System.out.println(obj);
        }
    }
}

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * PACKAGE_NAME <br>
 * <p>
 * Copyright: Copyright (c) 2017/6/14 12:58
 * <p>
 * Copyright: DEMO
 * <p>
 *
 * @version 1.0.0
 * @auther felixfeng086@hotmail.com
 */
public class GetMethodTest {

    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String className = new Scanner(System.in).nextLine();
        Method mainMethod = Class.forName(className).getMethod("main", String[].class);
        mainMethod.invoke(null, (Object) new String[] {"aaa", "bbb", "ccc"});
    }
}

class CallMe {
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}
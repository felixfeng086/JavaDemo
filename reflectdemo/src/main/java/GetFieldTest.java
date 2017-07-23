import java.lang.reflect.Field;

/**
 * PACKAGE_NAME <br>
 * <p>
 * Copyright: Copyright (c) 2017/6/14 12:46
 * <p>
 * Copyright: DEMO
 * <p>
 *
 * @version 1.0.0
 * @auther felixfeng086@hotmail.com
 *
 * 利用反射访问某个字段的值：先得到类中的字段（Field对象），再取指定的对象所对应的该字段值。
 * Filed对象是对应到类上的成员变量，并不表示某个具体的对象的成员变量的值，
 * 此时可以利用Field类中的get()方法返回指定对象上此Field表示的字段的值。
 */
public class GetFieldTest {

    public int x;
    private int y;

    public GetFieldTest(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        GetFieldTest gft = new GetFieldTest(3, 5);
        //访问public字段x
        Field fieldx = gft.getClass().getField("x");
        System.out.println(fieldx.get(gft));

        //访问private字段y----暴力反射
        Field fieldy = gft.getClass().getDeclaredField("y");
        fieldy.setAccessible(true);
        System.out.println(fieldy.get(gft));
    }
}

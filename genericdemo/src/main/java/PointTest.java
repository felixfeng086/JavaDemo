/**
 * PACKAGE_NAME <br>
 * <p>
 * Copyright: Copyright (c) 2017/6/17 23:22
 * <p>
 * Copyright: DEMO
 * <p>
 *
 * @version 1.0.0
 * @auther felixfeng086@hotmail.com
 */
public class PointTest {

    public static void main(String[] args) {
        //实例化泛型类
        Point<Integer, Integer> p1 = new Point<Integer, Integer>();
        p1.setX(10);
        p1.setY(20);
        p1.printPoint(p1.getX(), p1.getY());

    }
}

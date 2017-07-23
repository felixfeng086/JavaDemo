/**
 * PACKAGE_NAME <br>
 * <p>
 * Copyright: Copyright (c) 2017/6/17 23:12
 * <p>
 * Copyright: DEMO
 * <p>
 *
 * @version 1.0.0
 * @auther felixfeng086@hotmail.com
 */
//定义泛型类
public class Point<T1, T2> {
    T1 x;
    T2 y;

    public T1 getX() {
        return x;
    }

    public void setX(T1 x) {
        this.x = x;
    }

    public T2 getY() {
        return y;
    }

    public void setY(T2 y) {
        this.y = y;
    }

    //定义泛型方法
    public <T1, T2> void printPoint(T1 x, T2 y) {
        System.out.println("This point is: " + x + "," + y);
    }

}

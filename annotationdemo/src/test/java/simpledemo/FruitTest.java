package simpledemo;

import net.felix.demo.simpledemo.Apple;
import net.felix.demo.simpledemo.FruitInfoUtil;
import org.junit.Test;

/**
 * simpledemo <br>
 * <p>
 * Copyright: Copyright (c) 2017/5/26 13:31
 * <p>
 * Copyright: DEMO
 * <p>
 *
 * @version 1.0.0
 * @auther felixfeng086@hotmail.com
 */
public class FruitTest {
    @Test
    public void fruitTest() {
        FruitInfoUtil.getFruitInfo(Apple.class);
    }
}

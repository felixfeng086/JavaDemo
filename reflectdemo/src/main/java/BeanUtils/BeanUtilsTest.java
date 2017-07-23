package BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.beanutils.*;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.apache.commons.beanutils.locale.converters.DecimalLocaleConverter;

/**
 * PACKAGE_NAME <br>
 * <p>
 * Copyright: Copyright (c) 2017/6/14 14:11
 * <p>
 * Copyright: DEMO
 * <p>
 *
 * @version 1.0.0
 * @auther felixfeng086@hotmail.com
 */
public class BeanUtilsTest {
    public static void main(String[] args)
            throws InvocationTargetException, IllegalAccessException {
        Student s = new Student();
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "fengzhi");
        map.put("age", "32");
        map.put("birthday", "1986-10-25");

        ConvertUtils.register(new DateLocaleConverter(), Date.class);
        BeanUtils.populate(s, map);

        System.out.println(s.getName());
        System.out.println(s.getAge());
        System.out.println(s.getBirthday());
    }
}



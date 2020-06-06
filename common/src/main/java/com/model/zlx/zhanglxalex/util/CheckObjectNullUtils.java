package com.model.zlx.zhanglxalex.util;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName CheckObjectNullUtils
 * @Author zhanglixin Alex
 * @Date 2020/6/7 下午4:21
 * @Version 1.0
 */
@Slf4j
public class CheckObjectNullUtils {

    /**
     * 检查T每一个属性，其中一个有值则返回true
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> boolean checkObjectNull(T t) {
        if (null == t) {
            return false;
        }
        Class<?> decrClass = t.getClass();
        Field[] declaredFields = decrClass.getDeclaredFields();
        List<Field> smFieldList = Collections.unmodifiableList(Arrays.asList(declaredFields));
        for (int i = 0; i < smFieldList.size(); i++) {
            Field field = smFieldList.get(i);
            field.setAccessible(true);
            try {
                Object o = field.get(t);
                if (o != null) {
                    return true;
                }

            } catch (IllegalAccessException e) {
                log.error("异常", e);
                e.printStackTrace();
            }
        }
        return false;
    }

}

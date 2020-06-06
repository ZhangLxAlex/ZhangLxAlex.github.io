package com.model.zlx.zhanglxalex.util;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName CopyListUtils
 * @Author zhanglixin Alex
 * @Date 2020/6/7 下午4:21
 * @Version 1.0
 */
@Slf4j
public class CopyListUtils {

    /**
     * 复制List
     *
     * @param obj
     * @param list2
     * @param classObj
     * @param <T>
     */
    public static <T> void copyList(Object obj, List<T> list2, Class<T> classObj) {
        if ((!Objects.isNull(obj)) && (!Objects.isNull(list2))) {
            List list1 = (List) obj;
            list1.forEach(item -> {
                T data = null;
                try {
                    data = classObj.newInstance();
                } catch (Exception e) {
                    log.error("异常", e);
                }
                org.springframework.beans.BeanUtils.copyProperties(item, data);
                list2.add(data);
            });
        }
    }

}

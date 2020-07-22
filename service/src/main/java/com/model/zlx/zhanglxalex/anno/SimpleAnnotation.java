package com.model.zlx.zhanglxalex.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName SimpleAnnotation
 * @Author zhang_lx
 * @Date 2020-07-22 15:54
 * @Version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SimpleAnnotation {

    String value();

    String msg() default "zlxTest";

}

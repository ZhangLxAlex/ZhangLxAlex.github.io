package com.model.zlx.zhanglxalex.service;

import com.model.zlx.zhanglxalex.anno.SimpleAnnotation;
import org.springframework.stereotype.Service;

/**
 * @ClassName SimpleAnnoTest
 * @Author zhang_lx
 * @Date 2020-07-22 16:07
 * @Version 1.0
 */
@Service
public class SimpleAnnoTestService {

    @SimpleAnnotation(value = "testAnnoValue")
    public void testMethod(){
        System.out.println("SimpleAnnoTestService.testMethod输出-----");
    }

}

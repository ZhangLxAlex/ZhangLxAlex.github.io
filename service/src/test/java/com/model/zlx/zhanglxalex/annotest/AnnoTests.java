package com.model.zlx.zhanglxalex.annotest;

import com.model.zlx.zhanglxalex.service.SimpleAnnoTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AnnoTests {

    @Autowired
    private SimpleAnnoTestService simpleAnnoTestService;

    @Test
    public void annotest(){
        simpleAnnoTestService.testMethod();
    }

}

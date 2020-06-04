package com.model.zlx.zhanglxalex;

import com.model.zlx.zhanglxalex.entity.TMyUserEntity;
import com.model.zlx.zhanglxalex.mapper.TMyUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ZhangLxAlexApplicationTests {

	@Test
	public void contextLoad() {
		System.out.println("123");
	}

	@Autowired
	private TMyUserMapper tMyUserMapper;

	@Test
	public void contextLoads() {
		TMyUserEntity userEntity = new TMyUserEntity();
		System.out.println(tMyUserMapper.findByCondition(userEntity).toString());
	}

}

package com.model.zlx.zhanglxalex.cputest;

import com.model.zlx.zhanglxalex.entity.TMyUserEntity;
import com.model.zlx.zhanglxalex.mapper.TMyUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CpuTests {

	@Test
	public void testCpu() {
		//dataMap设置为空，则死循环
		Map<String, Date> dataMap = new HashMap<>();

		Map<String, Object> paramMap = new HashMap<>();
		//初始化死值
		paramMap.put("1",new Date());
		paramMap.put("2",new Date());

		System.out.println(paramMap.toString());

		Iterator<String> iterator = paramMap.keySet().iterator();
		while (iterator.hasNext()) {
			for (String dataMapItem : dataMap.keySet()){
				if(iterator.next().equals(dataMapItem)){
					System.out.println("paramMap remove-->"+ dataMapItem);
					iterator.remove();
				}
			}
		}
	}

	@Test
	public void testCpuTure() {
		//dataMap设置为空，则死循环
		Map<String, Date> dataMap = new HashMap<>();

		Map<String, Object> paramMap = new HashMap<>();
		//初始化死值
		paramMap.put("1",new Date());
		paramMap.put("2",new Date());

		System.out.println(paramMap.toString());

		Iterator<String> iterator = paramMap.keySet().iterator();
		while (iterator.hasNext()) {
			String keyName = iterator.next();
			for (String dataMapItem : dataMap.keySet()){
				if(keyName.equals(dataMapItem)){
					System.out.println("paramMap remove-->"+ dataMapItem);
					iterator.remove();
				}
			}
		}
	}

}

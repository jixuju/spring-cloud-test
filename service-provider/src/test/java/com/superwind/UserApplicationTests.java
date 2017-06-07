package com.superwind;

import com.superwind.service.AESUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void test() {
		String content = "qieuradjfk?wenwenId=100096&token=213817238sadkfj&time=1238712839";
		String password = "12345678";
		// 加密
		System.out.println("加密前：" + content);
		String s = AESUtil.encrypt(content, password);
		System.out.println("加密后："+s);
		// 解密

		String s1 = AESUtil.decrypt(s, password);
		System.out.println("解密后：" +s1);

	}
}

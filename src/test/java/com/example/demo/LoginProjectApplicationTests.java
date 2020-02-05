package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;


import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

class LoginProjectApplicationTests {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private SqlSessionFactory sessionFactory;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testByApplicationContext() {
		try {
			System.out.println("===================================");
			System.out.println(context.getBean("sqlSessionFactory"));
			System.out.println("===================================");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testBySqlSessionFactory() {
		try {
			System.out.println("===================================");
			System.out.println(sessionFactory.toString());
			System.out.println("===================================");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}

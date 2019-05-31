package com.spring01.controller;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // 기존의 방식이 아닌 다른방식이라는것을 인식 시켜줘야함
// junit의 러너클래스를 확장해서 스프링과 관련된 기능을 제공.
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

public class MybatisTest {
	private static final Logger Logger = LoggerFactory.getLogger(MybatisTest.class);	
	
	
	// 의존관계 주입.
	@Inject	
	private SqlSessionFactory sqlFactory;
	
	public void testFactory() {
		Logger.info("sqlFactory: " + sqlFactory);
	}
	
	@Test 		
	public void testSession() {
		try(SqlSession sqlSession = sqlFactory.openSession()) {
			Logger.info("sqlSession" +sqlSession);
			Logger.info("mybatis 연결성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

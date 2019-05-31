package com.spring01.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OracleConnectionTest {
	// 로그 
	private static final Logger Logger = LoggerFactory.getLogger(OracleConnectionTest.class );	
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";	
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";	
	private static final String USER = "java";	
	private static final String PW = "1234";
	
	
	
	@Test 	
	// junit사용을 하기위한 t어노테이션.
	public void test() throws Exception {
		Class.forName(DRIVER); // 드라이버 로딩 
		
		// try ~ with문 
		// try( 매개변수) 를 사용하고 자동으로 close 해줌.
		try(Connection conn = DriverManager.getConnection(URL, USER, PW)) {
			Logger.info("Oracle에 연결되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

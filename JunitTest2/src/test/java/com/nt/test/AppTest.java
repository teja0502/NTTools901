package com.nt.test;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.nt.service.BankService;

@DisplayName("TestBankLoanService class")
@TestMethodOrder(value = MethodName.class)
//@TestMethodOrder(value = MethodOrderer.DisplayName.class)
//@TestMethodOrder(value = OrderAnnotation.class)
//@TestMethodOrder(value = MethodOrderer.Random.class)
public class AppTest {

	private static BankService service;
	@BeforeAll
	public static void startUp() {
		System.out.println("AppTest.startUp()");
		service= new BankService();
	}
	@BeforeEach
	public void beforeEach() {
		System.out.println("AppTest.beforeEach()");
	}
	
	@Order(1)
	//@Tag("dev")
	//@Tag("uat")
	@DisplayName("testWithBigNumbers")
	@Test
	public void testClaculateIntrestAmtWithBigNumbers() {
		double expect=1416000.0;
		double actual=service.claculateIntrestAmt(1200000.0, 1.5, 12);
		Assertions.assertEquals(expect, actual);
	}
	@Order(5)
	//@Tag("dev")
	@DisplayName("testWithSmallNumbers")
	@Test
	public void testClaculateIntrestAmtWithSmallNumbers() {
		double expect=118000.0;
		double actual=service.claculateIntrestAmt(100000.0, 1.5, 12);
		Assertions.assertEquals(expect, actual);
	}
	@Order(16)
	//@Tag("uat")
	@DisplayName("testWithZerosNumbers")
	@Test
	public void testClaculateIntrestAmtWithZeros() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			service.claculateIntrestAmt(0, 0, 0);
		});
	}
	@Order(7)
	//@Tag("uat")
	@DisplayName("testWithTimer")
	@Test
	public void testClaculateIntrestAmtWithTimer() {
		Assertions.assertTimeout(Duration.ofMillis(5100), ()->{
			service.claculateIntrestAmt(100000.0, 1.5, 12);
		});
	}
	@Order(8)
	@Disabled
	//@Tag("dev")
	@DisplayName("testWithLessTimer")
		@Test
		public void testClaculateIntrestAmtWithLessTimer() {
			Assertions.assertTimeout(Duration.ofMillis(1000), ()->{
				service.claculateIntrestAmt(100000.0, 1.5, 12);
			});
	}
	
		@AfterEach
	public void afterEach() {
		System.out.println("AppTest.afterEach()");
	}
	
	@AfterAll
	public static void tairDown() {
		System.out.println("AppTest.tairDown()");
		service=null;
	}

}

package com.nt.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.nt.service.CensusService;

public class CensusTest {
	
	private static CensusService service;
	@BeforeAll
	public static void startUp() {
		service=new CensusService();
	}
	
	
	@DisplayName("Test Export Data")
	//@Test
	@RepeatedTest(value = 10,name = "execution of {displayName}-{currentRepetition}/{totalRepetitions}")
	public void testExportData() {
		Assertions.assertEquals("data exported", service.exportData());
		
	}
	@ParameterizedTest
	@ValueSource(ints = {2,6,9,15,16,25,22,66})
	public void testIsOdd(int n) {
		System.out.println("CensusTest.testIsOdd()");
		Assertions.assertTrue(service.isOdd(n));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {2,6,9,15,16,25,22,66})
	public void testIsEven(int n) {
		System.out.println("CensusTest.testIsEven()");
		Assertions.assertFalse(service.isOdd(n));
	}
	@ParameterizedTest
	@ValueSource(strings = {"Teja","Anitha"})
	public void testSayHello(String user) {
		System.out.println("CensusTest.testSayHello()");
		Assertions.assertEquals("Hello: "+user, service.sayHello(user));
	}
	
	
	@AfterAll
	public static void clear() {
		service=null;
	}

}

package com.nt.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

import com.nt.dao.ILoginDao;
import com.nt.service.ILoginMgmtService;
import com.nt.service.LoginMgmtServiceImpl;

public class LoginMgmtTest {
	
	private static ILoginMgmtService loginService;
	
	private static ILoginDao loginDao;

	
	@BeforeAll
	public static void stepUp() {
		//create mock object
		loginDao=Mockito.mock(ILoginDao.class);
		System.out.println("Mock object:: "+loginDao.getClass());
		loginService=new LoginMgmtServiceImpl(loginDao);
	}
	@Test
	public void testWillValidCreditials() {
		
		Mockito.when(loginDao.authenticate("raja", "rani")).thenReturn(1);
		
		Assertions.assertTrue(loginService.authenticate("raja", "rani"));
		
	}
	
	@Test
	public void testWillInValidCreditials() {
		
		Mockito.when(loginDao.authenticate("raja", "rani")).thenReturn(1);
		
		Assertions.assertFalse(loginService.authenticate("raja", "rani1"));
		
	}
	
	@Test
	public void testWillNoValidCreditials() {
		
		Mockito.when(loginDao.authenticate("raja", "rani")).thenReturn(1);
		
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			loginService.authenticate("", "");
		});
		
	}
	
	/*@Test
	public void testRegisterWithSpy() {
		//spy object
		 loginDAOSpy=Mockito.spy(ILoginDao.class);
		ILoginMgmtService loginService = new LoginMgmtServiceImpl(loginDAOSpy);
		loginService.registerUser("raja", "admin");
		loginService.registerUser("suresh", "visitor");
		loginService.registerUser("jani", "");
		//Mockito.verify(loginDAOSpy, Mockito.times(1)).addUser("raja", "admin");
		Mockito.verify(loginDAOSpy, Mockito.atLeast(1)).addUser("suresh", "visitor");
		Mockito.verify(loginDAOSpy, Mockito.never()).addUser("jani", "");
		
		
	}*/
	
	
	@AfterAll
	public static void clear() {
		loginDao=null;
		loginService=null;
	}

}

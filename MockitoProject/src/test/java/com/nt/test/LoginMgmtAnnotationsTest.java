package com.nt.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.nt.dao.ILoginDao;
import com.nt.service.ILoginMgmtService;
import com.nt.service.LoginMgmtServiceImpl;

public class LoginMgmtAnnotationsTest {
	@InjectMocks//hereinject to impl class not on interface
	private  LoginMgmtServiceImpl loginService;
	@Mock
	private   ILoginDao  loginDao;
	
	
	public LoginMgmtAnnotationsTest() {
		MockitoAnnotations.openMocks(this);
	}
	@Test
	public void testWillValidCreditials() {
		
		Mockito.when(loginDao.authenticate("raja", "rani")).thenReturn(1);
		// BDDMockito.given(loginDao.authenticate("raja","rani")).willReturn(1);
		Assertions.assertTrue(loginService.authenticate("raja", "rani"));
		
	}
	
	@Test
	public void testWillInValidCreditials() {
		
		//Mockito.when(loginDao.authenticate("raja", "rani")).thenReturn(1);
		 BDDMockito.given(loginDao.authenticate("raja","rani")).willReturn(1);
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
		ILoginDao  loginDAOSpy=Mockito.spy(ILoginDao.class);
		ILoginMgmtService  loginService=new LoginMgmtServiceImpl(loginDAOSpy);
		loginService.registerUser("raja", "admin");
		loginService.registerUser("suresh", "visitor");
		loginService.registerUser("jani", "");
		
		Mockito.verify(loginDAOSpy,Mockito.times(1)).addUser("raja", "admin");		
		Mockito.verify(loginDAOSpy,Mockito.times(0)).addUser("suresh", "visitor");		
		Mockito.verify(loginDAOSpy,Mockito.never()).addUser("jani", "");		
		
		
	}*/
	
	
	

}

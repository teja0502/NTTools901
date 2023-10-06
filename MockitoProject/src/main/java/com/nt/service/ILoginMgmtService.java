package com.nt.service;

public interface ILoginMgmtService {
	
	public boolean authenticate(String username, String password);
	public   String  registerUser(String user,String role );

}

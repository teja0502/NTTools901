package com.nt.service;

import com.nt.dao.ILoginDao;

public class LoginMgmtServiceImpl implements ILoginMgmtService {
	
	private ILoginDao loginDAO;
	
	public LoginMgmtServiceImpl(ILoginDao dao) {
		this.loginDAO=dao;
	}

	@Override
	public boolean authenticate(String username, String password) {
		if(username.contentEquals("") && password.contentEquals("") )
			throw new IllegalArgumentException("Invalid Inputs");
		int count=loginDAO.authenticate(username, password);
		if(count==1)
			return true;
		else
			return false;
	}

	@Override
	public String registerUser(String user, String role) {
		if(user.contentEquals("") && role.contentEquals("") )
			throw new IllegalArgumentException("Invalid Inputs");
		
		if(!user.contentEquals("") && !role.contentEquals("") )
			return "User is added";
		else
			return "User is not added";
	}

}

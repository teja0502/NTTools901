package com.nt.service;

public class CensusService {
	
	
	public String exportData() {
		return "data exported";
	}
	
	public boolean isOdd(int no) {
		if (no%2==0)
		return false;
		else
		return true;
		}
		public String sayHello(String user) {
		return "Hello: "+user;
		}

}

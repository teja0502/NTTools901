package com.nt.service;

public class BankService {

	
	public double claculateIntrestAmt(double pamt,double rate,double time) {
		if(pamt<=0 || rate<=0 || time<=0)
			throw new IllegalArgumentException("Invalid numbers.");
		try {
			Thread.sleep(5000);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		double intrest=pamt*rate*time/100.0;
		return pamt+intrest;
	}
}

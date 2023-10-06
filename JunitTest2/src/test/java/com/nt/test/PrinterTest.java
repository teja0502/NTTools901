package com.nt.test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.nt.service.Printer;

public class PrinterTest {
	@Test
	public void testSingleton() {
		Printer p1= Printer.getInstance();
		Printer p2= Printer.getInstance();
		
		if(p1==null || p2==null)
			fail("p1,p2 references must not to be null");
		Assertions.assertSame(p1, p2);
	}

}

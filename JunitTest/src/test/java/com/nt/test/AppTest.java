package com.nt.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.nt.service.ArthamaticOperations;

public class AppTest {
	
	@Test
	public void testWithPositives() {
		ArthamaticOperations ar= new ArthamaticOperations();
		float expected=30.0f;
		float actual=ar.sum(10.0f, 20.0f);
		//compare
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testWithNegatives() {
		ArthamaticOperations ar= new ArthamaticOperations();
		float expected=-30.0f;
		float actual=ar.sum(-10.0f, -20.0f);
		//compare
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testWithZeros() {
		ArthamaticOperations ar= new ArthamaticOperations();
		float expected=0.0f;
		float actual=ar.sum(0.0f, 0.0f);
		//compare
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testWithMixedValues() {
		ArthamaticOperations ar= new ArthamaticOperations();
		float expected=-10.0f;
		float actual=ar.sum(10.0f, -20.0f);
		//compare
		Assertions.assertEquals(expected, actual);
	}

}

package com.nt.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class Mock_stubVsSpy {
	
	@Test
	public void mock_StubVsSpy() {
		
		List<String> mockList=Mockito.mock(ArrayList.class);
		List<String> spyList=Mockito.spy(new ArrayList<>());
		//List<String> spyList=Mockito.spy(ArrayList.class);
		
		mockList.add("table");
		
		spyList.add("table");
		
		Mockito.when(mockList.size()).thenReturn(10);
		Mockito.when(spyList.size()).thenReturn(10);
		
		System.out.println(mockList.size()+"     "+spyList.size());
		
	}

}

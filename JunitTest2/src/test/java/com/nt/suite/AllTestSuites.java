package com.nt.suite;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import com.nt.test.AppTest;
import com.nt.test.CensusTest;
import com.nt.test.PrinterTest;

@SelectPackages("com.nt.test")
@SelectClasses({AppTest.class,CensusTest.class,PrinterTest.class})
@Suite
public class AllTestSuites {

}

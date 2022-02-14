package testCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import appUtils.Utils;

public class TestCase1 extends Utils {
	
	@Test
	public void case1() {
		test=report.startTest(" Case1");

		System.out.println("Test Case1 executed");
		test.log(LogStatus.INFO, "Test Case1 executed");
	}
	@Test
	public void case2() {
		test=report.startTest(" Case2");

		test.log(LogStatus.PASS, "test case two failed");
	

	}
	@Test
	public void case3() {
		test=report.startTest(" Case3");

		test.log(LogStatus.PASS, "test case three passed");
	

	}
	@Test
	public void case4() {
		test=report.startTest(" Case4");

		test.log(LogStatus.SKIP, "test case four skipped");
	

		
	}

}

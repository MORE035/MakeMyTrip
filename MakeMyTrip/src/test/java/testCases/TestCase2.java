package testCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import appUtils.Utils;

public class TestCase2 extends Utils {
	
	@Test
	public void case5() {
		test=report.startTest(" Case5");

		System.out.println("Test Case5 executed");
		test.log(LogStatus.INFO, "Test Case5 executed");
	}
	@Test
	public void case6() {
		test=report.startTest(" Case6");

		test.log(LogStatus.PASS, "test case6 failed");
	

	}
	@Test
	public void case7() {
		test=report.startTest(" Case7");

		test.log(LogStatus.PASS, "test case7 passed");
	

	}
	@Test
	public void case8() {
		test=report.startTest(" Case8");

		test.log(LogStatus.SKIP, "test case8 skipped");
	

		
	}

}

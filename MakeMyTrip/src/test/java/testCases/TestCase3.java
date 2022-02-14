package testCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import appUtils.Utils;

public class TestCase3 extends Utils {
	
	@Test
	public void case9() {
		test=report.startTest(" Case9");

		System.out.println("Test Case9 executed");
		test.log(LogStatus.INFO, "Test Case9 executed");
	}
	@Test
	public void case10() {
		test=report.startTest(" Case10");

		test.log(LogStatus.PASS, "test case10 failed");
	

	}
	@Test
	public void case11() {
		test=report.startTest(" Case11");

		test.log(LogStatus.PASS, "test case11 passed");
	

	}
	@Test
	public void case12() {
		test=report.startTest(" Case12");

		test.log(LogStatus.SKIP, "test case12 skipped");
	

		
	}

}

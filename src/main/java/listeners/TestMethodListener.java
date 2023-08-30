package listeners;

import logging.Logging;
import org.testng.*;
import org.testng.asserts.SoftAssert;
import org.testng.internal.TestResult;
import testrunner.BaseTest;

public class TestMethodListener implements IInvokedMethodListener, Logging {

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		if (method.isTestMethod()) {
			Reporter.log("******************************************");
			Reporter.log("Beginning execution of Test: " + method.getTestMethod().getMethodName(), true);
			
			if (null != method.getTestMethod().getDescription() && !method.getTestMethod().getDescription().isEmpty()) {
				Reporter.log(method.getTestMethod().getDescription(), true);
			}
			Reporter.log("******************************************");
		}
		
	}


}
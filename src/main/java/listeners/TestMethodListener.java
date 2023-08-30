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

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		if (null != testResult.getThrowable()) {
			// Exception happened during the Test.
			getLogger().error(testResult.getThrowable().getMessage());
		}

		ITestClass invokingClass = method.getTestMethod().getTestClass();
		Object[] classInstance = invokingClass.getInstances(true);
		if (method.isTestMethod()) {
			BaseTest testCase = (BaseTest) classInstance[0];
			SoftAssert asserts = testCase.getValidator();
			AssertionError err = null;
			try {
				asserts.assertAll();
			} catch (AssertionError e) {
				err = e;
			}
			if (null != err) {
				testResult.setStatus(TestResult.FAILURE);
				testResult.setThrowable(err);
			}

		}
	}

}
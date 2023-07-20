package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener {
	public void onTestStart(ITestResult result) {
		System.out.println("......Test Started : " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("......Test Successfull  : " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("......Test Fails : " + result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("......Test Skipped : " + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("......Test fail with timeout percentage : " + result.getName());
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	public void onStart(ITestContext context) {
		// not implemented
	}

	public void onFinish(ITestContext context) {
		System.out.println("......Tests Completed : " + context.getName());
	}
}

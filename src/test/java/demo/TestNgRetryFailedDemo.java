package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgRetryFailedDemo {
	@Test
	public void test1() {
		System.out.println("I am Inside test1.......");
	}
	@Test(retryAnalyzer = listeners.MyRetry.class)
	public void test2() {
		System.out.println("I am Inside test2.......");
		int a = 1/0;
	}
	@Test
	public void test3() {
		System.out.println("I am Inside test3.......");
		
	}
	@Test(retryAnalyzer = listeners.MyRetry.class)
	public void test4() {
		System.out.println("I am Inside test4.......");
		Assert.assertTrue(false);	
	}
	@Test
	public void test5() {
		System.out.println("I am Inside test5.......");
	}
}

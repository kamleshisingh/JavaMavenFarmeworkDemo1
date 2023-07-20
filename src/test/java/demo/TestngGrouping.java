package demo;

import org.testng.annotations.Test;
@Test(groups ={"allClasstest"})
public class TestngGrouping {
	@Test(groups = {"sanity"})
	public void test1() {
		System.out.println(" I Am in test1....");
	}
	@Test(groups = {"window.sanity","window.smoke"})
	public void test2() {
		System.out.println(" I Am in test2....");
	}
	@Test(groups = {"window.smoke","window.regression"})
	public void test3() {
		System.out.println(" I Am in test3....");
	}
	@Test
	public void test4() {
		System.out.println(" I Am in test4....");
	}

}

package demo;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNgIgnoreDemo {
	@Ignore
	@Test
	public void test1() {
		System.out.println("i m in test1");
	}
	@Test
	public void test2() {
		System.out.println("i m in test2");
	}
	@Test
	public void test3() {
		System.out.println("i m in test3");
	}

}

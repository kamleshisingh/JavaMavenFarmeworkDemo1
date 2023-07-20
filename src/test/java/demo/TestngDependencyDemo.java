package demo;

import org.testng.annotations.Test;

public class TestngDependencyDemo {
	@Test(dependsOnMethods = {} )
	public void test1() 
	{
	System.out.println("i am in Test1");	
	}
	@Test(dependsOnGroups = "sanity1")
	public void test2() 
	{
		System.out.println("i am in Test2");	
	}
	@Test(groups = "sanity1")
	public void test3() 
	{
		System.out.println("i am in Test3");	
	}

}

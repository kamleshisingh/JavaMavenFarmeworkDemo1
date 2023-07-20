package demo;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestngParametersDemo {
	@Parameters("MyName")
	@Test
	public void test(@Optional("kamlesh") String name) {
		System.out.println("name is : "+name);
	}

}

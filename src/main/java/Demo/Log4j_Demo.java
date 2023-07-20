package Demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j_Demo {
	private static Logger loger = LogManager.getLogger(Log4j_Demo.class);
	public static void main(String[] args) {
		System.out.println("\n  .....hello wrold...... \n");
		
		loger.trace("this is a trace message");
		loger.info("this just and info message");
		loger.error("this is an error meessage ");
		loger.warn("this is an warning  meessage ");
		loger.fatal("this is an fetal meessage ");
		System.out.println("\n ...completed...  \n");
	}

}

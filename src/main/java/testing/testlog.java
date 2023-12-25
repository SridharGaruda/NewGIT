package testing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class testlog {

	private static Logger log;

	public static void main(String[] args) {
		
		//Trace < debug < info < warn < error < fatal < off
		
		log = LogManager.getLogger(testlog.class);
		log.fatal("This is a fatal log get logged in app log");
		log.error("this is error log");
		log.warn("this is warn log");
		log.info("this is info finally gulshana");
		log.debug("this is info log");
		log.trace("this is info log");

	}
}

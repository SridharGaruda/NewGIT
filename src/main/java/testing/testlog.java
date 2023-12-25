package testing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class testlog {

	private static Logger log;

	public static void main(String[] args) {
		
		
		log = LogManager.getLogger(testlog.class);
		log.fatal("This is a fatal log");
		log.error("this is error log");
		log.warn("this is warn log");
		log.info("this is info finally gulshana");
		log.debug("this is info log");
		log.trace("this is info log");

	}
}

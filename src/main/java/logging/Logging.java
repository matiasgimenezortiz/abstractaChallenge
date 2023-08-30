package logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Logging {
	
	default Logger getLogger() {
		System.setProperty("log4j.configurationFile", "log4j2-local.xml");
        return LoggerFactory.getLogger(getClass());
    }
}

package main.utils.logger;

public interface AbstractLogger {

	void info(String message);
	
	void error(String message);
	
	void debug(String message);
	
	void warn(String message);
}

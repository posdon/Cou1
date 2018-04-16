package main.utils.logger;

public class LoggerFactory {

	public static Logger getLogger(Class<?> cls) {
		return new Logger(cls.getName());
	}
}

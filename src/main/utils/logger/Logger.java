package main.utils.logger;

import java.time.LocalDateTime;

import main.bot.MainApp;

public class Logger implements AbstractLogger {

	private final String name;
	

	
	protected Logger(String name) {
		this.name=name;
	}

	@Override
	public void info(String message) {
		log("[INFO]-"+message);
	}

	@Override
	public void error(String message) {
		log("[ERROR]-"+message);
	}

	@Override
	public void debug(String message) {
		if(MainApp.DEBUG)
			log("[DEBUG]-"+message);
	}

	@Override
	public void warn(String message) {
		log("[WARN]-"+message);
	}
	
	private void log(String message) {
		System.out.println(LocalDateTime.now()+"::"+name+"::"+message);
	}
}

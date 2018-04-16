package main.utils.logger;

import java.time.LocalDateTime;

import main.bot.MainApp;

public class Logger implements AbstractLogger {

	private final String name;
	
	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	private static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	private static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	private static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	private static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	private static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	private static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	private static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
	protected Logger(String name) {
		this.name=name;
	}

	@Override
	public void info(String message) {
		log("[INFO]-"+message);
	}

	@Override
	public void error(String message) {
		log(ANSI_RED_BACKGROUND+"[ERROR]-"+message+ANSI_RESET);
	}

	@Override
	public void debug(String message) {
		if(MainApp.DEBUG)
			log(ANSI_GREEN_BACKGROUND+"[DEBUG]-"+message+ANSI_RESET);
	}

	@Override
	public void warn(String message) {
		log(ANSI_BLUE_BACKGROUND+"[WARN]-"+message+ANSI_RESET);
	}
	
	private void log(String message) {
		System.out.println(LocalDateTime.now()+"::"+name+"::"+message);
	}
}

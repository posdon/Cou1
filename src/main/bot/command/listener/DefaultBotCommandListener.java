package main.bot.command.listener;

import main.bot.ExecutorType;
import main.bot.MainApp;
import main.bot.command.Command;

public class DefaultBotCommandListener {

	private MainApp mainApp;
	
	public DefaultBotCommandListener(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	@Command(command="stop", type=ExecutorType.CONSOLE)
	public void stopCommand() {
		mainApp.stop();
	}
	
	@Command(command="quit", type=ExecutorType.CONSOLE)
	public void quitCommand() {
		mainApp.stop();
	}
}

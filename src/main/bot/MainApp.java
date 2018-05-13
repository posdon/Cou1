package main.bot;

import java.util.Scanner;

import javax.security.auth.login.LoginException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.bot.command.CommandMapper;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

public class MainApp implements Runnable {

	public static final boolean DEBUG = true;
	
	private final JDA jda;
	private static String TOKEN;
	
	private boolean running;
	private final CommandMapper commandMapper = new CommandMapper(this);
	
	private static final Logger LOG = LoggerFactory.getLogger(MainApp.class);
	private static final Scanner scanner = new Scanner(System.in);
	
	public MainApp() throws LoginException {
		jda = new JDABuilder(AccountType.BOT).setToken(TOKEN).buildAsync();
		jda.addEventListener(new TitancheListener(commandMapper));
	}

	public static void main(String[] args) {
		LOG.info("Please enter the token of the bot :");
		if(scanner.hasNextLine()) {
			TOKEN = scanner.nextLine();
		}
		try {
			MainApp mainApp = new MainApp();
			new Thread(mainApp,"titancheBot").start();
		} catch (LoginException e) {
			LOG.error(e.getMessage());
		}
	}	
	
	@Override
	public void run() {
		running = true;
		LOG.info("Bot is ready !");
		while(running) {
			if(scanner.hasNextLine()) {
				commandMapper.commandConsole(scanner.nextLine());
			}
		}
		scanner.close();
		LOG.info("Stopping the bot...");
		jda.shutdown();
		System.exit(0);
	}
	
	public JDA getJDA() {
		return jda;
	}

	private void setRunning(boolean running) {
		this.running = running;
	}
	
	public void stop() {
		setRunning(false);
	}
}

package main.bot.command.listener;

import main.bot.ExecutorType;
import main.bot.command.Command;
import main.model.example.ExampleInterface;
import main.model.example.ExampleManager;
import net.dv8tion.jda.core.entities.MessageChannel;

public class ExampleCommandListener {

private ExampleInterface example = new ExampleManager();
	
	@Command(command="\\!log\\s+$1", description="!log $1", type=ExecutorType.USER)
	public void callLogSomething(String message) {
		example.logSomething(message);
	}
	
	@Command(command="ping", description="ping", type=ExecutorType.USER)
	public void callPing(MessageChannel channel) {
		if(example.ping()) {
			channel.sendMessage("pong").queue();
		}
	}
	
	@Command(command="$1\\s+plus\\s+$2 =", description="$1 plus $2 =", type=ExecutorType.USER)
	public void callAdd(MessageChannel channel, String iText, String jText) {
		int i = Integer.parseInt(iText);
		int j = Integer.parseInt(jText);
		
		int result = example.add(i, j);
		
		channel.sendMessage(result+"").queue();
	}
}

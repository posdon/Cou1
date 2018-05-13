package main.bot;

import main.bot.command.CommandMapper;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.EventListener;

public class TitancheListener implements EventListener {

	private final CommandMapper commandMapper;
	
	private final String tag = "!";
	
	public TitancheListener(CommandMapper commandMapper) {
		this.commandMapper = commandMapper;
	}
	
	public void onEvent(Event event) {
		if( event instanceof MessageReceivedEvent) onMessage((MessageReceivedEvent) event);
	}
	
	public void onMessage(MessageReceivedEvent event) {
		if(event.getAuthor().equals(event.getJDA().getSelfUser())) return;
		
		String message = event.getMessage().getContentDisplay().toLowerCase();
		if(message.startsWith(tag)) {
			message = message.replaceFirst(tag, "");
			commandMapper.commandUser(event.getAuthor(), message, event.getMessage());
		}
	}
}

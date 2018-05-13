package main.bot.command;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.bot.ExecutorType;
import main.bot.MainApp;
import main.bot.command.listener.DefaultBotCommandListener;
import main.bot.command.listener.ExampleCommandListener;
import main.exception.bot.DuplicatedCommandException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;

public class CommandMapper {

	private final MainApp mainApp;
	private final Map<String,CommandBean> commands = new HashMap<String,CommandBean>();
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public CommandMapper(MainApp main) {
		this.mainApp = main;
		try {
			registerCommand(new ExampleCommandListener());
			registerCommand(new DefaultBotCommandListener(main));
		} catch (DuplicatedCommandException e) {
			log.error(e.getMessage(),e);
		}
	}
	
	public Collection<CommandBean> getCommands(){
		return commands.values();
	}

	/**
	 * Add all the {@link Command} annoted method of the given object into the mapper.
	 * @param object 
	 * @throws DuplicatedCommandException if a same command exist for two differents methods
	 */
	public void registerCommand(Object object) throws DuplicatedCommandException {
		for(Method method : object.getClass().getDeclaredMethods()){
			if(method.isAnnotationPresent(Command.class)){
				Command command = method.getAnnotation(Command.class);
				method.setAccessible(true);
				CommandBean commandBean= new CommandBean(command.command(), command.description(), command.type(), object, method);
				if(commands.containsKey(command.command())) {
					throw new DuplicatedCommandException(command.command());
				}
				commands.put(command.command(),commandBean);
			}
		}
	}
	
	/**
	 * Treatment for {@link Command} annotation with {@link ExecutorType} neither ALL nor CONSOLE
	 * @param command
	 */
	public void commandConsole(String command){
		Object[] object = getCommand(command);
		if(object[0] == null ||  (((CommandBean)object[0]).getType() != ExecutorType.CONSOLE && ((CommandBean)object[0]).getType() != ExecutorType.ALL)){
			log.warn(String.format("Unknown command from CONSOLE : {0}",command));
			return;
		}
		try{
			execute(((CommandBean)object[0]), command, (String[])object[1], null);
		}catch(Exception exception){
			log.error("Method "+((CommandBean)object[0]).getMethod().getName()+" isn't initialised correctly.");
		}
	}
	
	/**
	 * Treatment for {@link Command} annotation with {@link ExecutorType} neither ALL nor USER
	 * @param command
	 */
	public boolean commandUser(User user, String command, Message message){
		Object[] object = getCommand(command);
		if(object[0] == null || (((CommandBean)object[0]).getType() != ExecutorType.USER && ((CommandBean)object[0]).getType() != ExecutorType.ALL)) {
			log.warn("Unknown command from USER : {0}",command);
			return false;
		}
		try{
			execute(((CommandBean)object[0]), command,(String[])object[1], message);
		}catch(Exception exception){
			log.error("Method {O} isn't initialised correctly.",((CommandBean)object[0]).getMethod().getName());
		}
		return true;
	}
	
	/**
	 * 
	 * @param command
	 * @return A tab with first the command bean, then the params
	 */
	private Object[] getCommand(String command){
		String[] commandSplit = command.split(" ");
		String[] args = new String[commandSplit.length-1];
		for(int i = 1; i < commandSplit.length; i++) args[i-1] = commandSplit[i];
		CommandBean commandBean= commands.get(commandSplit[0]);
		return new Object[]{commandBean, args};
	}
	
	private void execute(CommandBean commandBean, String command, String[] args, Message message) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Parameter[] parameters = commandBean.getMethod().getParameters();
		Object[] objects = new Object[parameters.length];
		for(int i = 0; i < parameters.length; i++){
			if(parameters[i].getType() == List.class) objects[i] = args;
			else if(parameters[i].getType() == User.class) objects[i] = message == null ? null : message.getAuthor();
			else if(parameters[i].getType() == TextChannel.class) objects[i] = message == null ? null : message.getTextChannel();
			else if(parameters[i].getType() == PrivateChannel.class) objects[i] = message == null ? null : message.getPrivateChannel();
			else if(parameters[i].getType() == Guild.class) objects[i] = message == null ? null : message.getGuild();
			else if(parameters[i].getType() == String.class) objects[i] = command;
			else if(parameters[i].getType() == Message.class) objects[i] = message;
			else if(parameters[i].getType() == JDA.class) objects[i] = mainApp.getJDA();
			else if(parameters[i].getType() == MessageChannel.class) objects[i] = message.getChannel();
		}
		commandBean.getMethod().invoke(commandBean.getObject(), objects);
	}
}

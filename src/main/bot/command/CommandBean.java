package main.bot.command;

import java.lang.reflect.Method;

import main.bot.ExecutorType;

public class CommandBean {

	private final String command;
	private final String description;
	private final ExecutorType type;
	private final Object object;
	private final Method method;
	
	public CommandBean(String command, String description, ExecutorType type, Object object, Method method) {
		super();
		this.command = command;
		this.description = description;
		this.type = type;
		this.object = object;
		this.method = method;
	}

	public String getCommand() {
		return command;
	}

	public String getDescription() {
		return description;
	}

	public ExecutorType getType() {
		return type;
	}

	public Object getObject() {
		return object;
	}

	public Method getMethod() {
		return method;
	}

}

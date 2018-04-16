package main.bot.regexp;

import java.lang.reflect.Method;

import main.bot.regexp.Regexp.ExecutorType;

public class RegexpBean {

	private final String expression;
	private final String description;
	private final ExecutorType type;
	private final Object object;
	private final Method method;
	
	public RegexpBean(String expression, String description, ExecutorType type, Object object, Method method) {
		super();
		this.expression = expression;
		this.description = description;
		this.type = type;
		this.object = object;
		this.method = method;
	}
	
	public String getExpression() {
		return expression;
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

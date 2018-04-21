package main.bot.command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import main.bot.ExecutorType;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Command {

	public String command();
	public String description() default "Without description";
	public ExecutorType type() default ExecutorType.ALL;

}

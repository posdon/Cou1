package main.bot.regexp;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value=ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Regexp {

	public String expression();
	public String description() default "Sans description";
	public ExecutorType type() default ExecutorType.ALL;
	
	public enum ExecutorType {
		ALL, USER, CONSOLE;
	}
}

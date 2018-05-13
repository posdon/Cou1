package main.model.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleManager implements ExampleInterface {

	private final Logger LOG =LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void logSomething(String message) {
		LOG.info(message);
	}

	@Override
	public boolean ping() {
		return true;
	}

	@Override
	public int add(int i, int j) {
		return i+j;
	}

}

package main.model.example;

import main.utils.logger.Logger;
import main.utils.logger.LoggerFactory;

public class ExampleManager implements ExampleInterface {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
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

package main.model.blackjack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlackjackUserState implements Runnable {
	
	private BlackjackUser user;
	private static final Logger LOG = LoggerFactory.getLogger(BlackjackUserState.class);
	
	public BlackjackUserState(BlackjackUser user) {
		this.user = user;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(90000);
		} catch (InterruptedException e) {
			LOG.error(e.getMessage());
		}
		this.user.timeout(Thread.currentThread());
	}

}

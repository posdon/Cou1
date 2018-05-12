package main.model.blackjack;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class Blackjack {
	
	private Map<String,BlackjackUser> playerList;
	private BlackjackDealer dealer;
	private BlackjackDeck deck;
	private boolean opened;
	private Iterator<BlackjackUser> iterator;
	
	public Blackjack(String dealerName) {
		this.playerList = new HashMap<String,BlackjackUser>();
		this.deck = new BlackjackDeck();
		this.dealer = new BlackjackDealer(deck, dealerName);
		this.opened = true;
		this.iterator = null;
	}
	
	public void join(String userName, int bid) {
		if (!playerList.containsKey(userName) && opened)
			playerList.put(userName, new BlackjackUser(deck,bid,userName));
	}
	
	public void start() {
		opened = false;
		iterator = playerList.values().iterator();
		iterator.next().start();
	}
	
	public boolean nextUser() {
		if (!iterator.hasNext()) {
			BlackjackHand dealersHand = dealer.play(deck);
			for(BlackjackUser user : playerList.values()) {
				user.getGain(dealersHand);
			}
			return false;
		} else {
			iterator.next().start();
			return true;
		}
	}
	
	public BlackjackUser getUser(String userName) {
		 if (playerList.containsKey(userName)) {
			 if (playerList.get(userName).getActive())
				 return playerList.get(userName);
		 }
		 return null;
	}

}

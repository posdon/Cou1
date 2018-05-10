package main.model.blackjack;

import java.util.List;
import java.util.ArrayList;
import main.exception.bot.AceValueAccessException;

public class BlackjackHand {
	
	private List<BlackjackCard> cards;
	
	public BlackjackHand() {
		this.cards = new ArrayList<BlackjackCard>();
	}
	
	public void addCard(BlackjackCard card) {
		this.cards.add(card);
	}

	public int aceCounts11Value() throws AceValueAccessException{
		int sum = 0;
		for(BlackjackCard c : cards) {
			if (c.isAce()) sum +=11;
			else sum += c.getPointValue();
		}
		return sum;
	}
	
	public int optimalValue() throws AceValueAccessException{
		int sum = 0;
		int aceCount =0;
		for(BlackjackCard c : cards) {
			if (c.isAce()) {
				sum +=11;
				aceCount++;
			}
			else sum += c.getPointValue();
		}
		while(aceCount > 0) {
			if (sum >21) sum -=10;
			else return sum;
		}
		return sum;
	}

	
}

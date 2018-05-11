package main.model.blackjack;

import java.util.List;
import java.util.ArrayList;
import main.exception.bot.AceValueAccessException;

public class BlackjackHand {
	
	protected List<BlackjackCard> cards;
	protected boolean wonBlackjack;
	protected boolean isOut;
	protected boolean stands;
	
	public BlackjackHand() {
		this.cards = new ArrayList<BlackjackCard>();
		this.wonBlackjack = false;
		this.isOut = false;
		this.stands = false;
	}
	
	
	public void hit(BlackjackCard card) {
		this.cards.add(card);
		int val = 0;
		try {
			val = optimalValue();
		} catch(AceValueAccessException e) {
			System.out.println(e.getMessage());
		}
		if (val > 21) isOut = true;
		if (val== 21) wonBlackjack = true;
	}
	
	public void stand() {
		stands = true;
	}
	
	public BlackjackCard splitHand() {
		if (cards.size() == 2 && cards.get(0).equals(cards.get(1)))
			return cards.remove(1);
		return null;
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
	
	public boolean getWonBlackjack() {return this.wonBlackjack;}
	
	public boolean getIsOut() {return this.isOut;}
	
	public boolean getStands() {return this.stands;}

	
}

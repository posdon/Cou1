package main.model.blackjack;

import java.util.List;
import java.util.ArrayList;
import main.exception.bot.AceValueAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlackjackHand {
	
	private List<BlackjackCard> cards;
	private boolean wonBlackjack;
	private boolean isOut;
	private boolean stands;
	private static final Logger LOG = LoggerFactory.getLogger(BlackjackHand.class);
	
	public BlackjackHand() {
		this.cards = new ArrayList<BlackjackCard>();
		this.wonBlackjack = false;
		this.isOut = false;
		this.stands = false;
	}
	
	
	public void addCard(BlackjackCard card) {
		this.cards.add(card);
		int val = optimalValue();
		if (val > 21) isOut = true;
		if (val == 21 && isBeginning()) wonBlackjack = true;
	}
	
	public void stand() {
		stands = true;
	}
	
	public BlackjackCard split() {
		if (isBeginning() && cards.get(0).equals(cards.get(1)))
			return cards.remove(1);
		return null;
	}
	
	public int optimalValue(){
		int sum = 0;
		int aceCount =0;
		try {
			for(BlackjackCard c : cards) {
				if (c.isAce()) {
					sum +=11;
					aceCount++;
				}
				else sum += c.getPointValue();
			}
		} catch (AceValueAccessException e) {
			LOG.error(e.getMessage());
		}
		for(int i = aceCount; i > 0;i--) {
			if (sum >21) sum -=10;
			else return sum;
		}
		return sum;
	}
	
	public boolean isBeginning() { return (this.cards.size() ==2);}
	
	public boolean getWonBlackjack() {return this.wonBlackjack;}
	
	public boolean getIsOut() {return this.isOut;}
	
	public boolean getStands() {return this.stands;}

	
}

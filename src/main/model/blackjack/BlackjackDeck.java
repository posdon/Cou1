package main.model.blackjack;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class BlackjackDeck {

	private List<BlackjackCard> dAT; //Deck and Talon
	
	public BlackjackDeck() {
		reshuffle();
	}
	
	public void reshuffle() {
		this.dAT.clear();
		List<BlackjackCard> ordered = new ArrayList<BlackjackCard>();
		for(int i = 1; i <= 4;i++) {
			for(int j = 1; j<= 13; j++) {
				ordered.add(new BlackjackCard(i,j));
			}
		}
		for (int i = 1; i<= 52; i++) {
			dAT.add(ordered.remove(ThreadLocalRandom.current().nextInt(0,i)));
		}
	}
	
	public BlackjackCard drawCard() {
		return dAT.remove(0);
	}
}

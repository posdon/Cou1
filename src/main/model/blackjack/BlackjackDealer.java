package main.model.blackjack;

public class BlackjackDealer extends BlackjackAbstractPlayer {

	public BlackjackDealer(BlackjackDeck deck, String dealerName) {
		super(deck, dealerName);
	}
	
	public BlackjackHand play(BlackjackDeck deck) {
		mainHand.addCard(deck.drawCard());
		while (mainHand.optimalValue() <= 16)
			mainHand.addCard(deck.drawCard());
		return mainHand;
	}

}

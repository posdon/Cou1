package main.model.blackjack;

public abstract class BlackjackAbstractPlayer {
	
	protected BlackjackHand mainHand;
	
	
	public BlackjackAbstractPlayer(BlackjackDeck deck){
		super();
		init(deck);
	}
	
	public void init(BlackjackDeck deck){
		this.mainHand = new BlackjackHand();
		this.mainHand.addCard(deck.drawCard());
	}
	
	public abstract boolean checkIsOut();
	
	
}

package main.model.blackjack;

public abstract class BlackjackAbstractPlayer {
	
	protected BlackjackHand mainHand;
	protected String playerName;
	
	public BlackjackAbstractPlayer(BlackjackDeck deck, String playerName){
		super();
		init(deck);
		this.playerName = playerName;
	}
	
	public void init(BlackjackDeck deck){
		this.mainHand = new BlackjackHand();
		this.mainHand.addCard(deck.drawCard());
	}
	
	
}

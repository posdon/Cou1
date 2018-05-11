package main.model.blackjack;

public class BlackjackUser extends BlackjackAbstractPlayer {
	
	protected BlackjackHand splitHand;
	protected int bid;
	protected String userName;

	
	public BlackjackUser(BlackjackDeck deck,int bid, String userName) {
		super(deck);
		this.splitHand = null;
		this.bid = bid;
		this.userName = userName;
	}
	
	@Override
	public void init(BlackjackDeck deck) {
		super.init(deck);
		this.mainHand.hit(deck.drawCard());
	}

	
	public boolean split() {
		BlackjackCard splitter = mainHand.splitHand();
		if (splitter != null) {
			splitHand = new BlackjackHand();
			splitHand.hit(splitter);
		}
		
		return false;
	}

	@Override
	public boolean checkIsOut() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkWonBlackjack() {
		// TODO Auto-generated method stub
		return false;
	}

}

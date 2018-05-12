package main.model.blackjack;

public class BlackjackUser extends BlackjackAbstractPlayer {
	
	private BlackjackHand splitHand;
	private int bid;
	private String userName;
	private boolean active;
	private Thread waitThread;

	
	public BlackjackUser(BlackjackDeck deck,int bid, String userName) {
		super(deck);
		this.splitHand = null;
		this.bid = bid;
		this.userName = userName;
		this.active = false;
		this.waitThread = null;
	}
	
	@Override
	public void init(BlackjackDeck deck) {
		super.init(deck);
		this.mainHand.addCard(deck.drawCard());
	}
	
	public void start() {
		active = true;
		nextMove();
	}
	
	public void nextMove() {
		waitThread = new Thread(new BlackjackUserState(this),userName);
	}
	
	public void timeout(Thread timerThread) {
		if (active && timerThread == waitThread) {
			stand();
		}
	}
	
	public void nextUser() {
		active = false;
		// TODO Link to main class: NextUser
	}
	
	public void stand() {
		if (splitHandActive()) splitHand.stand();
		else {
			mainHand.stand();
			nextUser();
		}
	}
	
	public void hit(BlackjackDeck deck) {
		if(splitHandActive()) {
			splitHand.addCard(deck.drawCard());
		} else {
			mainHand.addCard(deck.drawCard());
			if (mainHand.getIsOut()) nextUser();
			else nextMove();
		}
	}
	
	public void split() {
		BlackjackCard splitter = mainHand.split();
		if (splitter != null) {
			splitHand = new BlackjackHand();
			splitHand.addCard(splitter);
			bid *= 2;
		}
		nextMove();
	}
	
	public void doubleDown(BlackjackDeck deck) {
		if (mainHand.isBeginning()) {
			bid *=2;
			this.mainHand.addCard(deck.drawCard());
			nextUser();
		}
		// TODO else display not poss!
		else nextMove();
	}

	@Override
	public boolean checkIsOut() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public double getGain(BlackjackHand dealersHand) {
		boolean splitted = (splitHand != null);
		if (mainHand.getWonBlackjack() && !splitted) {
			return (dealersHand.getWonBlackjack()) ? 0 : bid*1.5;
		} else if (dealersHand.getWonBlackjack()) {
			return bid*(-1.0);
		} else {
			double gain = 0;
			if (splitted) {
				if (splitHand.getIsOut()) gain += bid*(-0.5);
				else if (dealersHand.getIsOut() || splitHand.optimalValue() > dealersHand.optimalValue()) gain += bid*0.5;
				else if (splitHand.optimalValue() < dealersHand.optimalValue()) gain +=bid*(-0.5);
			}
			if (mainHand.getIsOut()) gain += bid * (splitted ? -0.5 : -1.0);
			else if (dealersHand.getIsOut() || mainHand.optimalValue() > dealersHand.optimalValue()) gain += bid*(splitted ? 0.5 : 1.0);
			else if (mainHand.optimalValue() < dealersHand.optimalValue()) gain +=bid*(splitted ? -0.5 : -1.0);
			return gain;
		}
	}

	private boolean splitHandActive() {
		return (splitHand != null && !splitHand.getStands() && !splitHand.getIsOut());
	}

}

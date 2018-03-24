package main.model.loveletter;

import java.util.ArrayList;
import java.util.List;

public class LoveLetterPlayer {

	private static final String DEFAULT_NAME="NO_NAME";
	private String name;
	private List<LoveLetterCards> hand;
	
	/* ******************************
	 * 								*
	 * 			Constructors		*
	 * 								*
	 ****************************** */
	
	protected LoveLetterPlayer(String name) {
		this.name = name;
		this.hand = new ArrayList<LoveLetterCards>();
	}
	
	protected LoveLetterPlayer() {
		this(DEFAULT_NAME);
	}
	
	/* ******************************
	 * 								*
	 * 		Getters / Setters		*
	 * 								*
	 ****************************** */
	
	
	protected String getName() {
		return this.name;
	}
	
	protected int getNumberOfCardInHand() {
		return this.hand.size();
	}
	
	/**
	 * @return if the player's hand is not empty
	 */
	protected boolean isAlive() {
		return ! this.hand.isEmpty();
	}

	/**
	 * Add a card in the player's hand.
	 * There is no limits of card.
	 * @param card
	 */
	protected void addCard(LoveLetterCards card) {
		this.hand.add(card);
	}
	
	/**
	 * Discard a card from the player's hand.
	 * @param index of the 
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	protected LoveLetterCards discard(int ind) throws IndexOutOfBoundsException {
		try {
			return this.hand.remove(ind);
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoveLetterPlayer other = (LoveLetterPlayer) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}

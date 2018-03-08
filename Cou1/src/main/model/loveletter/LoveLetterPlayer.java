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
	
	public LoveLetterPlayer(String name) {
		this.name = name;
		this.hand = new ArrayList<LoveLetterCards>();
	}
	
	public LoveLetterPlayer() {
		this(DEFAULT_NAME);
	}
	
	/* ******************************
	 * 								*
	 * 		Getters / Setters		*
	 * 								*
	 ****************************** */
	
	
	public String getName() {
		return this.name;
	}
	
	public int getNumberOfCardInHand() {
		return this.hand.size();
	}
	
	/**
	 * @return if the player's hand is not empty
	 */
	public boolean isAlive() {
		return ! this.hand.isEmpty();
	}

	/**
	 * Add a card in the player's hand.
	 * There is no limits of card.
	 * @param card
	 */
	public void addCard(LoveLetterCards card) {
		this.hand.add(card);
	}
	
	/**
	 * Discard a card from the player's hand.
	 * @param index of the 
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	public LoveLetterCards discard(int ind) throws IndexOutOfBoundsException {
		try {
			return this.hand.remove(ind);
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

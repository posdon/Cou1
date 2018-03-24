package main.model.loveletter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoveLetterDeck {

	private List<LoveLetterCards> deck;
	private LoveLetterCards removedCard;

	private final int NB_GUARD = 5;
	private final int NB_PRIEST = 2;
	private final int NB_BARON = 2;
	private final int NB_HANDMAID = 2;
	private final int NB_PRINCE = 2;
	private final int NB_KING = 1;
	private final int NB_COUNTESS = 1;
	private final int NB_PRINCESS = 1;
	
	protected LoveLetterDeck() {
		this.deck = new ArrayList<LoveLetterCards>();
		initializeDeck();
	}
	
	/**
	 * Create and shuffle the deck composition
	 */
	private void initializeDeck() {
		List<LoveLetterCards> flatCompositionDeck = new ArrayList<LoveLetterCards>();
		constructComposition(flatCompositionDeck);
		shuffle(flatCompositionDeck);
		this.removedCard = this.deck.remove(0);
	}
	
	/**
	 * Add all the cards to the given deck
	 * @param flatCompositionDeck
	 */
	private void constructComposition(List<LoveLetterCards> flatCompositionDeck) {
		for(int i=0; i<NB_GUARD; i++) {
			flatCompositionDeck.add(LoveLetterCards.GUARD);
		}
		
		for(int i=0; i<NB_PRIEST; i++) {
			flatCompositionDeck.add(LoveLetterCards.PRIEST);
		}
		
		for(int i=0; i<NB_BARON; i++) {
			flatCompositionDeck.add(LoveLetterCards.BARON);
		}
		
		for(int i=0; i<NB_HANDMAID; i++) {
			flatCompositionDeck.add(LoveLetterCards.HANDMAID);
		}
		
		for(int i=0; i<NB_PRINCE; i++) {
			flatCompositionDeck.add(LoveLetterCards.PRINCE);
		}
		
		for(int i=0; i<NB_KING; i++) {
			flatCompositionDeck.add(LoveLetterCards.KING);
		}
		
		for(int i=0; i<NB_COUNTESS; i++) {
			flatCompositionDeck.add(LoveLetterCards.COUNTESS);
		}
		
		for(int i=0; i<NB_PRINCESS; i++) {
			flatCompositionDeck.add(LoveLetterCards.PRINCESS);
		}
	}

	/**
	 * Shuffle with a pseudo random way the deck
	 * @param flatCompositionDeck
	 */
	private void shuffle(List<LoveLetterCards> flatCompositionDeck) {
		this.deck.clear();
		Random rdm = new Random();
		while (flatCompositionDeck.size() > 0) {
			int randomInd = rdm.nextInt(flatCompositionDeck.size());
			this.deck.add(flatCompositionDeck.remove(randomInd));
		}
	}
	
	/**
	 * Shuffle with a pseudo random way the deck
	 */
	protected void shuffle() {
		shuffle(new ArrayList<LoveLetterCards>(this.deck));
	}

	/** 
	 * Add the first card of the deck to the player's hand
	 * @param player
	 */
	protected void draw(LoveLetterPlayer player) {
		if(!this.deck.isEmpty())
			player.addCard(this.deck.remove(0));
	}
	
	protected int getNbCard() {
		return this.deck.size();
	}
	
	protected LoveLetterCards getRemovedCard() {
		return this.removedCard;
	}
	
	protected boolean isEmpty() {
		return this.deck.isEmpty();
	}
}

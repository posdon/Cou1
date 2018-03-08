package main.model.uno;

import java.util.ArrayList;

import main.model.uno.exception.UnoCannotPlaceException;
import main.model.uno.exception.UnoWrongIndexException;

/**
 * Data on a player in a Uno game.
 * @author Scipio
 *
 */
public class UnoPlayer {
	
	private int id;
	private boolean finished;
	private boolean saidUno;
	private ArrayList<UnoCard> hand;
	//TODO add a value corresponding to an actual discord user -> Really ? What is a discord user ? We are in the model package here, not the bot package.
	// If you can't remember this rule, so forget discord
	
	public UnoPlayer(int id) {
		this.id = id;
		finished = false;
		hand = new ArrayList<UnoCard>();
		saidUno = false; //TODO change it when someone says uno
	}
	
	public int getId() {return id;}
	public boolean hasFinished() {return finished;}
	
	/**
	 * Adds the top card of a deck to the player's hand.
	 * @param deck
	 */
	public UnoCard draw(UnoDeck deck) {
		UnoCard card = deck.draw();
		hand.add(card);
		return card;
	}
	
	
	public UnoCard play(int cardLocation, UnoPile pile) throws UnoWrongIndexException, UnoCannotPlaceException {
		UnoCard target = hand.get(cardLocation);
		if(target==null) throw new UnoWrongIndexException();
		if(!target.canBePlacedOn(pile.getTopCard())) throw new UnoCannotPlaceException();
		
		if(target.getValue()<10) {
			for(int i = 0;i<hand.size();i++) {
				if(target.equals(hand.get(i))&&i!=cardLocation) {
					//TODO propose to play the second card
				}
			}
		}
		
		
		while(target.getValue() == 13 ||target.getValue()==14) {
			//TODO color selection
			//target.setColor(selectedColor);
		}
		
		pile.add(target);
		hand.remove(target);
		
		if(hand.size()==0) {finished = true;}
		
		
		return target;
	}

}

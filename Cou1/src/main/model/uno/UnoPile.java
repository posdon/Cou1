package main.model.uno;

import java.util.ArrayList;

/**
 * The Uno pile, where played cards go.
 * @author Scipio
 *
 */
public class UnoPile extends UnoCardStack{
	
	
	
	
	public void add(UnoCard card) {content.add(card);}
	
	public UnoCard getTopCard() {return content.size() == 0 ? null : content.get(content.size()-1);}
	
	public ArrayList<UnoCard> clearLeavingOne() {
		UnoCard topCard = getTopCard();
		if (topCard==null) return null;
		
		ArrayList<UnoCard> cards = content;
		cards.remove(cards.size()-1);
		
		content = new ArrayList<UnoCard>();
		content.add(topCard);
		
		return cards;
		
	}
	

}

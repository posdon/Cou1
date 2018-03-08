package main.model.uno;

import java.util.ArrayList;

/**
 * Represents a group of cards, basis of UnoDeck and UnoPile.
 * @author Scipio
 *
 */
public class UnoCardStack {
	
	protected ArrayList<UnoCard> content;
	
	public UnoCardStack() {
		content = new ArrayList<UnoCard>();
	}
	
	public UnoCardStack(ArrayList<UnoCard> content) {
		this.content = content;
	}
	
	
	public ArrayList<UnoCard> getContent(){return content;}

	
	public UnoCard getTopCard() {return content.size() == 0 ? null : content.get(content.size()-1);}
	
	
	

}

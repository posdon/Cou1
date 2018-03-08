package main.model.uno;

import java.util.ArrayList;

/**
 * Represents a group of cards, basis of UnoDeck and UnoPile.
 * @author Scipio
 *
 */
// Looks like juste a simple List<UnoCard>. Is a class file necessary for this ?
// When you will sel an attribute UnoCardStack, just set it as an ArrayList.
public class UnoCardStack {
	
	protected ArrayList<UnoCard> content;
	
	public UnoCardStack() {
		content = new ArrayList<UnoCard>();
	}
	
	public UnoCardStack(ArrayList<UnoCard> content) {
		this.content = content;
	}
	
	
	public ArrayList<UnoCard> getContent(){return content;}

	// Warning : avoid return null when possible
	// If you do, throw an exception if it's for a case impossible
	// If you do, throw a default value if it's for a default case (like a UnoCard named "NULL"
	public UnoCard getTopCard() {return content.size() == 0 ? null : content.get(content.size()-1);}
	
	
	

}

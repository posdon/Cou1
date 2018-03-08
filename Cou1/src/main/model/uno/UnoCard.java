package main.model.uno;

/**
 * Card for the Uno game.
 * @author Scipio
 *
 */
public class UnoCard {
	
	
	// Try an enum
	/**
	 * The value of the card.
	 * 0-9 : the number of the card.
	 * 10 : +2 card
	 * 11 : skip turn card
	 * 12 : reverse card
	 * 13 : wild card
	 * 14 : wild +4 card
	 */
	private int value;
	
	// Try an enum too : 
	/**
	 * The color of the card.
	 * By default : "jaune" "rouge" "vert" "bleu" for normal cards
	 * "jocker" for wild cards
	 */
	private String color;
	
	/**
	 * Create a card based on its value and its color
	 * @param value
	 * @param color
	 */
	public UnoCard(int value, String color) {
		this.value = value;
		this.color = color;
	}
	
	public int getValue() {return value;}
	public String getColor() {return color;}
	
	public void setColor(String color) {this.color = color;}
	
	
	/**
	 * Checks if this card can be placed on the card put in parameters.
	 * @param card
	 * @return true if it is the case.
	 */
	public boolean canBePlacedOn(UnoCard card) {
		return (this.value==card.value || this.color.equals(card.color) || this.color.equals("jocker"));
	}
	
	
	public String toString() {
		
		String name;
		
		switch (value) {
		case 10:
			name = "+2 ";
			break;
		case 11:
			name = "Passe ";
			break;
		case 12:
			name = "Changement de sens ";
			break;
		case 13:
			name = "Jocker";
			break;
		case 14:
			name = "Super jocker (+4)";
			break;
		default:
			name = String.valueOf(value) +" ";
		}
		if(value<13)name += color;
		
		return name;
		
	}
	
	// Attention à ne pas oublier @Override.
	// Sinon tu risques d'appeler la méthode equals de la classe Object (toutes les classes héritent d'Object)
	public boolean equals(UnoCard card) {
		return(this.value==card.value||this.color.equals(card.color));
	}


}

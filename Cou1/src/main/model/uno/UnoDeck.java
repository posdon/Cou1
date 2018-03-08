package main.model.uno;

import java.util.Collections;

/**
 * The Uno deck, contains all the cards players can draw.
 * @author Scipio
 *
 */
public class UnoDeck extends UnoCardStack{
	//TODO : replace the numbers in for loops to be more understandable
	
	
	public UnoDeck(String[] colors) {
		
		
		super();
		
		//Add colored cards
		for(String color : colors) {
			addColor(color);
		}
		
		//Add wild ("jocker") cards
		for(int i = 52; i< 60; i++) {
			content.add(new UnoCard(i/4, "jocker"));
		}
		
		//Shuffle
		Collections.shuffle(content);
		
		
	}
	
	
	
	
	/**
	 * Add all the cards of a color.
	 * @param color
	 */
	private void addColor(String color) {
		
		//Adding 2 zeros
		content.add(new UnoCard(0,color));
		content.add(new UnoCard(0,color));
		
		//Adding 4 times each number from 1 to 9
		for(int i = 4; i<40; i++) {
			content.add(new UnoCard(i/4,color));			
		}
		
		//Adding 8 of each special card
		for(int i = 80; i< 104;i++) {
			content.add(new UnoCard(i/8,color));
		}
	}
	
	public UnoCard draw() {
		return content.remove(content.size()-1);
	}
	

}

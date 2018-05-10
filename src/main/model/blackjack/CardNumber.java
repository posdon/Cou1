package main.model.blackjack;

import main.exception.bot.*;

public enum CardNumber {

	ACE("A",11),
	TWO("2",2),
	THREE("3",3),
	FOUR("4",4),
	FIVE("5",5),
	SIX("6",6),
	SEVEN("7",7),
	EIGHT("8",8),
	NINE("9",9),
	TEN("10",10),
	JACK("V",10),
	QUEEN("D",10),
	KING("K",10);
	
	private final String title;
	private final int value;
	
	private CardNumber(String title, int value) {
		this.title = title;
		this.value = value;
	}

	public String getTitle() {return this.title;}
	
	public int getValue() throws AceValueAccessException {
		if (this.value == 11) throw new AceValueAccessException();
		return this.value;
	}
	
}

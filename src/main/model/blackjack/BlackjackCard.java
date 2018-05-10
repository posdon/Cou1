package main.model.blackjack;

import main.exception.bot.*;

public class BlackjackCard {

	protected Color color;
	protected CardNumber number;
	
	public BlackjackCard(int colorCode, int numberCode) {
		switch(colorCode) {
		case 1: this.color = Color.CLOVERS;
		case 2: this.color = Color.PIKES;
		case 3: this.color = Color.HEARTS;
		case 4: this.color = Color.TILES;
		}
		switch(numberCode) {
		case 1: this.number = CardNumber.ACE;
		case 2: this.number = CardNumber.TWO;
		case 3: this.number = CardNumber.THREE;
		case 4: this.number = CardNumber.FOUR;
		case 5: this.number = CardNumber.FIVE;
		case 6: this.number = CardNumber.SIX;
		case 7: this.number = CardNumber.SEVEN;
		case 8: this.number = CardNumber.EIGHT;
		case 9: this.number = CardNumber.NINE;
		case 10: this.number = CardNumber.TEN;
		case 11: this.number = CardNumber.JACK;
		case 12: this.number = CardNumber.QUEEN;
		case 13: this.number = CardNumber.KING;
		}
	}
	
	@Override
	public String toString() {
		return this.color.getAbbr() + this.number.getTitle();
	}
	
	public int getPointValue() throws AceValueAccessException {
		return this.number.getValue();
	}
	
	public boolean isAce() {
		return (this.number.toString().equals("ACE"));
	}
}

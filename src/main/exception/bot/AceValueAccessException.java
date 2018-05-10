package main.exception.bot;

public class AceValueAccessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6265078248554959081L;
	
	private static final String MESSAGE = "Don't acces the value of the ace direcly, it depnds on the player's cards!";
	
	public AceValueAccessException() {super(MESSAGE);}

}

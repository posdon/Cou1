package main.exception.bot;

public class DuplicatedCommandException  extends Exception {

	private static final long serialVersionUID = 270997008941302440L;

	private final static String message = "This command is already used as listener : ";
	
	public DuplicatedCommandException(String duplicata) {
		super(message+duplicata);
	}

}

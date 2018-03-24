package main.model.loveletter;

public interface LoveLetterInterface {

	public boolean addPlayer(String name);
	
	public boolean removePlayer(String name);
	
	public boolean start();
	
	public boolean draw();
	
	public boolean discard(int cardNb);
	
	public String getCurrentPlayer();
	
	public boolean isEnded();
	
	public String getWinner();
}

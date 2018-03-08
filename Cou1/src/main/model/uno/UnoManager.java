package main.model.uno;

import java.util.ArrayList;

import main.model.uno.exception.UnoCannotPlaceException;
import main.model.uno.exception.UnoWrongIndexException;

/**
 * The class that will play the Uno game.
 * @author Scipio
 */
public class UnoManager {
	
	private ArrayList<UnoPlayer> finished;
	private ArrayList<UnoPlayer> playing;
	private UnoPlayer activePlayer;
	private UnoDeck deck;
	private UnoPile pile;
	private boolean gameOn;
	private boolean isWaitingForPlayers;
	private boolean waitForPlay;
	private int turn;
	private int order;
	private int cardsToDraw;
	private String[] colors;
		
	
	public UnoManager() {
		
		colors = new String[]{"jaune","rouge","vert","bleu"};
		deck = new UnoDeck(colors);
		pile = new UnoPile();
		
		order = 1;
		cardsToDraw = 0;
		
		isWaitingForPlayers = true;
		playing = waitForPlayers();
		
		
		
		
		gameOn = true;
		while(gameOn) {
			
			activePlayer = playing.get(turn % playing.size());
			
			printGameState();
			
			if(cardsToDraw!=0) {
				draw(cardsToDraw);
			}else {
				
				waitForPlay = true;
				while(waitForPlay) {
					
					//TODO add a way to select a card to play with a command (!uno play <location>) sets cardLocation
					//TODO add a way to draw
					play(0);
					draw();
					
				}
				
			}
			
			
			
		}
	}


	private ArrayList<UnoPlayer> waitForPlayers() {
		
		ArrayList<UnoPlayer> players = new ArrayList<UnoPlayer>();
		while(isWaitingForPlayers) {
			
			//TODO detect command adding a player (!uno join), adds in players and playing
			//TODO detect command starting the game (!uno launch), sets isWaitingForPlayers to false.
		}
		
		return players;
	}
	
	private void printWrongIndexMessage() {
		//TODO I/O
	}
	
	private void printCannotPlaceException() {
		// TODO I/O
	}
	
	private void printGameState() {
		//TODO I/O
	}
	private void play(int cardLocation) {
		
		try {
			UnoCard card = activePlayer.play(cardLocation, pile);
			waitForPlay = false;
			
			switch (card.getValue()) {
			case 10:
				cardsToDraw = 2;
				break;
			case 11:
				turn += order;
				break;
			case 12:
				order = -order;
				break;
			case 14:
				cardsToDraw = 4;
				break;
			}

			
			
			if(activePlayer.hasFinished()) {
				playing.remove(activePlayer);
				finished.add(activePlayer);
			}else turn += order;
			
			
			
		} catch (UnoWrongIndexException e) {
			printWrongIndexMessage();
		} catch (UnoCannotPlaceException e) {
			printCannotPlaceException();
		}
	}
	
	private void draw() {
		UnoCard card = activePlayer.draw(deck);
		if (card.canBePlacedOn(pile.getTopCard())){
			//TODO option to play the card
		}else {
			turn += order;
		}
	}
	
	private void draw(int number) {
		for(int i = 0; i<number;i++) {
			activePlayer.draw(deck);
		}
	}

}

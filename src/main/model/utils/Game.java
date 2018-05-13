package main.model.utils;

import java.util.List;

import main.model.utils.exception.ClassMustHaveAnIdException;

public class Game<T extends Player> {

	private String gameId;
	private T gameMaster;
	private List<T> players;
	
	public Game() throws ClassMustHaveAnIdException {
		throw new ClassMustHaveAnIdException();
	}
	
	public Game(String gameId, T gameMaster, List<T> players) {
		this.gameId = gameId;
		this.gameMaster = gameMaster;
		this.players = players;
	}
	
	public Game(Game<T> game) {
		new Game<T>(game.getId(), game.getMaster(), game.getPlayers());
	}

	public String getId() {
		return gameId;
	}
	
	public T getMaster() {
		return gameMaster;
	}
	
	public List<T> getPlayers(){
		return players;
	}
	
	public boolean containsPlayer(T player) {
		return players.contains(player);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gameId == null) ? 0 : gameId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game<T> other = (Game<T>) obj;
		if (gameId == null) {
			if (other.gameId != null)
				return false;
		} else if (!gameId.equals(other.gameId))
			return false;
		return true;
	}
	
}

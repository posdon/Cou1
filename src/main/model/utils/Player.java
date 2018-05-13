package main.model.utils;

import main.model.utils.exception.ClassMustHaveAnIdException;

public class Player {

	private String playerId;
	
	public Player() throws ClassMustHaveAnIdException {
		throw new ClassMustHaveAnIdException();
	}
	
	public Player(String playerId) {
		this.playerId = playerId;
	}
	
	public Player(Player player) {
		this.playerId = player.playerId;
	}
	
	public String getId() {
		return playerId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((playerId == null) ? 0 : playerId.hashCode());
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
		Player other = (Player) obj;
		if (playerId == null) {
			if (other.playerId != null)
				return false;
		} else if (!playerId.equals(other.playerId))
			return false;
		return true;
	}
}

package main.model.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.model.utils.exception.ClassMustHaveAnIdException;
import main.model.utils.exception.MustBeGameMasterException;
import main.model.utils.exception.PlayerAlreadyInGameException;
import main.model.utils.exception.PlayerNotInGameException;
import main.model.utils.exception.SomeoneIsNotReadyException;

/**
 * Builder for the class Game<P>
 * @author posdon
 *
 * @param <P> the type of the Players of the game
 *
 */
public class GameBuilder<P extends Player> {

	private List<P> playerList;
	private P master;
	private Map<P,Boolean> isReady;
	private String id;
	
	public GameBuilder() {
		new GameBuilder<>("");
	}
	
	public GameBuilder(String id) {
		playerList = new ArrayList<>();
		this.id = id;
		isReady = new HashMap<>();
		master = null;
	}
	
	/**
	 * Build the game and reset all
	 * @param master
	 * @return
	 * @throws SomeoneIsNotReadyException At least one of the game's player is not ready yet
	 * @throws ClassMustHaveAnIdException The game must have a not null id
	 * @throws MustBeGameMasterException Only the master should be able to build the game
	 */
	public Game<P> build(P master) throws SomeoneIsNotReadyException, ClassMustHaveAnIdException, MustBeGameMasterException {
		if(! master.equals(this.master)) throw new MustBeGameMasterException();
		if(! allReady()) throw new SomeoneIsNotReadyException();
		if(id.equals("")) throw new ClassMustHaveAnIdException();
		Game<P> result = new Game<>(id, master, playerList);
		id = "";
		isReady = new HashMap<>();
		playerList = new ArrayList<>();
		master = null;
		return result;
	}	
	
	/* *********/
	/* Getters */
	/* *********/
	
	public List<P> getPlayerList() {
		return playerList;
	}

	public Player getMaster() {
		return master;
	}

	public Map<P, Boolean> getIsReady() {
		return isReady;
	}

	public String getId() {
		return id;
	}
	
	
	
	/**
	 * @return true if every player is ready
	 */
	public boolean allReady() {
		for(Map.Entry<P,Boolean> entry : isReady.entrySet()) {
			if(! entry.getValue())
				return false;
		}
		return true;
	}

	public void setMaster(P master) {
		this.master = master;
	}
	
	public void addPlayer(P player) throws PlayerAlreadyInGameException {
		if(playerList.contains(player)) throw new PlayerAlreadyInGameException();
		playerList.add(player);
		isReady.put(player, false);
	}
	
	public void removePlayer(P player) throws PlayerNotInGameException {
		if(!playerList.contains(player)) throw new PlayerNotInGameException();
		isReady.remove(player);
		playerList.remove(player);
	}
	
	public boolean containsPlayer(P player) {
		return playerList.contains(player);
	}
	
	public void setReady(P player, boolean value) throws PlayerNotInGameException {
		if(!isReady.containsKey(player)) throw new PlayerNotInGameException();
		isReady.put(player, value);
	}
}

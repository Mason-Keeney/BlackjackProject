package com.skilldistillery.blackjack.abstractclasses;

import java.util.List;

public abstract class Table {
	protected List<Contestant> players;
	protected Dealer dealer;
	protected boolean hasWinner;
	

	public List<Contestant> getPlayers() {
		return players;
	}

	public void setPlayers(List<Contestant> players) {
		this.players = players;
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public void removePlayer(Player player) {
		players.remove(player);
	}
	
}

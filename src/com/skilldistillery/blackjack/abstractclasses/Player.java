package com.skilldistillery.blackjack.abstractclasses;

public abstract class Player implements Contestant {
	protected Hand hand;
	protected int bet;
	protected String name;
	
	public Player() {
	}

	public Player(int bet, String name) {
		this.bet = bet;
		this.name = name;
	}


	public Player(String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getBet() {
		return bet;
	}


	public void setBet(int bet) {
		this.bet = bet;
	}


	public Hand getHand() {
		return hand;
	}


	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
	
	public String toString() {
		return name;
	}
	
}

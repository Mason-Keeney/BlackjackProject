package com.skilldistillery.blackjack.cards;

public enum Suit {
	SPADES("Spades"), CLUBS("Clubs"), HEARTS("Hearts"), DIAMONDS("Diamonds");

	private final String name;

	Suit(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}

package com.skilldistillery.blackjack.abstractclasses;

import com.skilldistillery.blackjack.cards.Deck;

public abstract class Dealer {
	protected Deck deck;

	
	public Dealer() {
		deck = new Deck();
		deck.shuffle();
	}
	
	public void dealCard(Hand hand) {
		deck.dealCard(hand);
	}

	
	public void newDeck() {
		deck = new Deck();
		deck.shuffle();
	}
	
	
	public abstract void friendlyBanter(boolean winning);
	
	
}

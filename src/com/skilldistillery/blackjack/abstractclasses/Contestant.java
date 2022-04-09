package com.skilldistillery.blackjack.abstractclasses;

import com.skilldistillery.blackjack.cards.Card;

public interface Contestant {

	public boolean hasWinningHand();
	
	public boolean hasLosingHand();
	
	public boolean concedes();
	
	public void draws(Card card);
	
	public int getHandValue();
	
	public boolean isHolding();
}

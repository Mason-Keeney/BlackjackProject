package com.skilldistillery.blackjack.entities;

import com.skilldistillery.blackjack.abstractclasses.Hand;
import com.skilldistillery.blackjack.cards.Card;

public class BlackjackHand extends Hand {

	@Override
	public int getHandValue() {
		int handValue = 0;
		for (Card card : hand) {
			handValue += card.getValue();
		}
		if (handValue > 21 && containsAce()) {
			handValue -= 10;
		}
			
		return handValue;
	}
	
	private boolean containsAce() {
		for (Card card : hand) {
			if (card.isAce()) {
				return true;
			}
		}
		return false;
	}

	public boolean isBlackjack() {
		if (getHandValue() == 21) {
			return true;
		}
		return false;
	}
	
	public boolean isBust() {
		if (getHandValue() > 21) {
			return true;
		}
		return false;
	}
	

}

package com.skilldistillery.blackjack.entities;

import com.skilldistillery.blackjack.abstractclasses.Player;
import com.skilldistillery.blackjack.cards.Card;

public class BlackjackPlayer extends Player {
	private Boolean isHolding = false;

	public BlackjackPlayer() {
		hand = new BlackjackHand();
	}

	public BlackjackPlayer(String name) {
		super(name);
		hand = new BlackjackHand();
	}

	public BlackjackPlayer(int bet, String name) {
		super(bet, name);
		hand = new BlackjackHand();
	}

	@Override
	public boolean hasWinningHand() {
		if (((BlackjackHand) hand).isBlackjack()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean concedes() {
		return true;
	}

	@Override
	public void draws(Card card) {
		hand.addCard(card);
	}

	@Override
	public boolean hasLosingHand() {
		if (((BlackjackHand) hand).isBust()) {
			return true;
		}
		return false;
	}

	@Override
	public int getHandValue() {
		return hand.getHandValue();
	}

	
	public void setHolding(boolean decision) {
		if (decision) {
			isHolding = true;
		} else {
			isHolding = false;
		}
	}
	
	@Override
	public boolean isHolding() {
		return isHolding;
	}

}

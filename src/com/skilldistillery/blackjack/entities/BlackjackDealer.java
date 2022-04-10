package com.skilldistillery.blackjack.entities;

import com.skilldistillery.blackjack.abstractclasses.Contestant;
import com.skilldistillery.blackjack.abstractclasses.Dealer;
import com.skilldistillery.blackjack.abstractclasses.Hand;
import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.cards.Deck;

public class BlackjackDealer extends Dealer implements Contestant {
	private Hand hand;
	private String name;
	private final int initialHandSize = 2;

	public BlackjackDealer() {
		deck = new Deck();
		deck.shuffle();
		hand = new BlackjackHand();
		name = "Dealer";
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
		return false;
	}

	@Override
	public void draws(Card card) {
		hand.addCard(card);
	}

	@Override
	public void friendlyBanter(boolean winning) {
		if (winning) {
			System.out.println("Better luck next time");
		} else {
			System.out.println("Good show ol' chap!");
		}
	}

	public void dealCard(Contestant contestant) {
		Card temp = deck.dealCard();
		contestant.draws(temp);
		System.out.println(contestant + " recieved " + temp);
	}
	
	public Hand cardsShowing() {
		Hand showingHand = new BlackjackHand();
		for(int i = 0; i < hand.getHand().size(); i++) {
			if (i != 0) {
				showingHand.addCard(hand.get(i));
			}
		}
		return showingHand;
	}
	
	public Hand getHand() {
		return hand;
	}
	

	public void dealHand(Contestant contestant) {
		for (int i = 0; i < initialHandSize; i++) {
			contestant.draws(deck.dealCard());
		}
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

	@Override
	public boolean isHolding() {
		if (hand.getHandValue() >= 17) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return name;
	}
	
	

}

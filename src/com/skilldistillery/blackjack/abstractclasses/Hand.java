package com.skilldistillery.blackjack.abstractclasses;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.blackjack.cards.Card;

public abstract class Hand {
	protected List<Card> hand;
	
	public Hand() {
		hand = new ArrayList<>();
	}
	public Hand(List<Card> hand) {
		hand = new ArrayList<>();
		this.hand = hand;
	}
	
	public void addCard(Card card) {
		hand.add(card);
	}
	
	public List<Card> getHand(){
		return hand;
	}
	
	public void clear() {
		hand = new ArrayList<>();
	}
	public int size() {
		return hand.size();
	}
	public Card get(int i) {
		return hand.get(i);
	}
	
	
	public abstract int getHandValue();

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int i = 1;
		String handToString = "";
	
		for (Card card : hand) {
			sb.append("Card " + i + ": " + card + "\n");
			i++;
		}
	
		handToString = sb.toString();
		return handToString;
	}
	
	
}

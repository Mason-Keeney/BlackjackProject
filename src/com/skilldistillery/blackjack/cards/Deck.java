package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.skilldistillery.blackjack.abstractclasses.Hand;

public class Deck {
	private List<Card> cards;

	public Deck() {
		cards = new ArrayList<>();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				cards.add(new Card(rank, suit));
			}

		}

	}

	public int size() {
		return 52;
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public Card dealCard() {
		return cards.remove(0);
	}

	public int cardsLeftInDeck() {
		return cards.size();
	}
	
	public void dealCard(Hand hand) {
		hand.addCard(cards.remove(0));
	}

	

}

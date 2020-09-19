package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> deck; 
	
	public Deck(){
		deck = createDeck();
	}
	
	public List<Card> createDeck() {
		List<Card> cards = new ArrayList<>(52);
		for (Suit suit : Suit.values()) {
			for(Rank rank : Rank.values()) {
				cards.add(new Card(suit, rank));
			}
		}
		return cards;
	}
	
	public int checkDeckSize( ) {
		return deck.size();
	}
	
	public Card dealCard() {
		return deck.remove(0);
	}
	
	public void shuffel() {
		Collections.shuffle(deck);
	}
}

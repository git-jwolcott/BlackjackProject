package com.skilldistillery.common.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	List<Card> deck; 
	
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
	
	public int checkDeckSize(List<Card> deck) {
		return deck.size();
	}
	
	public Card dealCard() {
		return deck.remove(0);
	}
	
	public void shuffel() {
		Collections.shuffle(deck);
	}
}

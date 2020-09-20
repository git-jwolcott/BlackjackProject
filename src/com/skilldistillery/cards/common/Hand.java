package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> hand = new ArrayList<>();
	
	
	public void addCard(Card card) {
		hand.add(card);
	}
	
	public abstract int getHandValue();
	public abstract StringBuilder getDealerHandShownValue();

	public void clearHand() {
		hand.clear();
// 		for (Card card : hand) {
//			hand.remove(card);
//		}
//		hand = new ArrayList<>();
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cards in hand ");
		for (int i = 0; i < hand.size(); i++) {
			if(i != hand.size()-1) {
				builder.append(hand.get(i).toString());
				builder.append(", ");
			}
			else if (i == hand.size()-1){
				builder.append(hand.get(i).toString());
			}
		}
		return builder.toString();
	}

	
	
	
}

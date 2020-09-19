package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> hand = new ArrayList<>();
	
	
	public void addCard(Card card) {
		hand.add(card);
	}
	
	public abstract int getHandValue();
	protected abstract int getDealerHandShownValue();

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
		builder.append("Hand [hand=");
		builder.append(hand);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

	
	
	
}

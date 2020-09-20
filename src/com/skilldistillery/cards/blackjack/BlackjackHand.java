package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Hand;

public class BlackjackHand extends Hand {
	StringBuilder sb = new StringBuilder();

	@Override
	public int getHandValue() {
		int handValue = 0;
		for (Card card : hand) {
			handValue += card.getValue();
		}
		return handValue;
	}
	@Override
	public StringBuilder getDealerHandShownValue() {
		StringBuilder sb = new StringBuilder();
			sb.append(hand.get(1).getValue());
			sb.append(" Shown Card ");
		    sb.append(hand.get(1).toString());
		return sb;
	}
	
	public boolean isBlackjack() {
		return (this.getHandValue() != 21) ? false : true;
	}
	
	public boolean isBust() {
		return (this.getHandValue() > 21) ? true : false;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hand Value = ");
		builder.append(this.getHandValue());
		builder.append(" ");
		builder.append(super.toString());
		return builder.toString();
	}
	
//	public boolen isHard() {}
	
//	public boolen isSoft(){}	
	

}

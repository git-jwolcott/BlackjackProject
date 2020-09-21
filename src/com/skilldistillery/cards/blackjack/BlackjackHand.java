package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Hand;

public class BlackjackHand extends Hand {
	StringBuilder sb = new StringBuilder();

	public boolean isBlackjack() {
		return (this.getHandValue() != 21) ? false : true;
	}

	public boolean isBust() {
		return (this.getHandValue() > 21) ? true : false;
	}

	@Override
	public int getHandValue() {
		boolean hasAce = false;
		int softValue = 0;
		int hardValue = 0;
		for (Card card : hand) {
			// hand value - if ace is present, it counts as one (this is set in the enum)
			softValue += card.getValue();
			// if a hand has an ace, set boolean true
			if (card.toString().contains("ACE")) {
				hasAce = true;
			}
		}
		// add ten to softValue (in case aces are present)
		hardValue = softValue + 10;
		// if an ace is present, see if hard value causes a bust
		if (hasAce && (hardValue <= 21)) {
			// when true, return hardValue...this new card won't cause a bust
			return hardValue;
			// else if new card causes a bust, count the ace as 1 and return the soft value
		} else if (hasAce && (hardValue > 21)) {
			return softValue;
		}
		// no ace, return softValue
		else
			return softValue;
	}

	public boolean evaluateDealerHandForAce() {
		boolean hasAce = false;
		for (Card card : hand) {
			if (card.toString().contains("ACE")) {
				hasAce = true;
			}
		}
		return hasAce;
	}

	@Override
	public StringBuilder getDealerHandShownValue() {
		StringBuilder sb = new StringBuilder();
		sb.append(hand.get(1).getValue());
		sb.append(" Shown Card ");
		sb.append(hand.get(1).toString());
		return sb;
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

}

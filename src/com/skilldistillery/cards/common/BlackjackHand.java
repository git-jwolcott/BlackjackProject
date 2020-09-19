package com.skilldistillery.cards.common;

public class BlackjackHand extends Hand {


	@Override
	public int getHandValue() {
		int handValue = 0;
		for (Card card : hand) {
			handValue += card.getValue();
			
		}
		return handValue;
	}
	@Override
	public int getDealerHandShownValue() {
		int handValue = 0;
		for(int i = 1; i < hand.size(); i++)
		{
		    handValue += (hand.get(i).getValue());
		}
		return handValue;
			
	}
	
	public boolean isBlackjack() {
		return (this.getHandValue() != 21) ? false : true;
	}
	
	public boolean isBust() {
		return (this.getHandValue() > 21) ? true : false;
	}
	
//	public boolen isHard() {}
	
//	public boolen isSoft(){}	
	

}

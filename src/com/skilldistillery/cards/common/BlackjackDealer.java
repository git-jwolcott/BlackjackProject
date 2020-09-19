package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public class BlackjackDealer {
	//give the dealer a deck of cards
	Deck deck = new Deck();
	//the dealer is also a player, give the dealer a blackjackHand
	Hand hand = new BlackjackHand();
	//cast hand to a blackjack so you can use BlackjackHand specific methods
	BlackjackHand bjHand = (BlackjackHand) hand;

	public void suffleDeck() {
		System.out.println("Shuffling the deck.");
		deck.shuffel();
	}

	public Card dealCard() {
		return deck.dealCard();

	}

	public List<Card> dealMultipleCards(int numCardsToDeal) {
		List<Card> hand = new ArrayList<>(numCardsToDeal);
		if (numCardsToDeal > deck.checkDeckSize()) {
			System.out.println("Not enough cards in the deck.");
		} else {
			int cardValue = 0;
			for (int i = 0; i < numCardsToDeal; i++) {
				Card c = deck.dealCard();
				cardValue += c.getValue();
				System.out.println(c);
				hand.add(c);
			}
			System.out.println("Your card value " + cardValue);
		}
		return hand;

	}

	public void addCardToHand() {
		bjHand.addCard(deck.dealCard());
	}

	public void dealerHitorStand() {
		while(bjHand.getHandValue() < 17) {
			bjHand.addCard(deck.dealCard());
		}
		if(bjHand.getHandValue() > 21) {
			System.out.println("Dealer busted. Player wins!");
		}
		else if (bjHand.getHandValue() == 21) {
			System.out.println("Blackjack! Dealer wins!");
		}
		else {return;}
		}
	}
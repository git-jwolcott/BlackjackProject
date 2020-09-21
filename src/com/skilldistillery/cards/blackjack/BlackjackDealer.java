package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Hand;

public class BlackjackDealer {
	// give the dealer a deck of cards
	Deck deck = new Deck();
	// the dealer is also a player, give the dealer a blackjackHand
	Hand hand = new BlackjackHand();
	// cast hand to a blackjack so you can use BlackjackHand specific methods
	public BlackjackHand bjHand = (BlackjackHand) hand;

	public void suffleDeck() {
		List<Card> cardList = deck.createDeck();
		System.out.println("Shuffling the deck.");
		Collections.shuffle(cardList);
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
		System.out.println("Dealer " + bjHand.toString());
		boolean hasAce = bjHand.evaluateDealerHandForAce();
		while ((!hasAce && bjHand.getHandValue() < 17) || (hasAce && bjHand.getHandValue() == 17)) {
			bjHand.addCard(deck.dealCard());
			System.out.println("Dealer hits. \nDealer " + bjHand.toString());
			continue;
		}
		if (bjHand.getHandValue() >= 17 && bjHand.getHandValue() < 21) {
			System.out.println("Dealer stays. ");
		}
	}
}
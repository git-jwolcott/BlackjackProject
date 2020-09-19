package com.skilldistillery.cards.common;

import java.util.Scanner;

public class BlackjackPlayer {
	Hand hand = new BlackjackHand();
	BlackjackHand bjHand = (BlackjackHand) hand;

	public void addCard(Card card) {
		bjHand.addCard(card);
	}

	static Scanner userInput;

	public char playerHitOrStand() {
		userInput = new Scanner(System.in);
		System.out.println("Do you want to hit or stand? Enter h for hit or s for stand. ");
		char choice = Character.toLowerCase((userInput.next().charAt(0)));
			return choice;
		}
}

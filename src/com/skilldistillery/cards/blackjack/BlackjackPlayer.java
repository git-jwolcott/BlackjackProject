package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Hand;

public class BlackjackPlayer {
	Hand hand = new BlackjackHand();
	public BlackjackHand bjHand = (BlackjackHand) hand;

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

	public char playAgain() {
		userInput = new Scanner(System.in);
		System.out.println("Would you like to play again? Enter y for yes or n for no.");
		char choice = Character.toLowerCase((userInput.next().charAt(0)));
		return choice;
	}
	
}


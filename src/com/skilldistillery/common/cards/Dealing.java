package com.skilldistillery.common.cards;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Dealing {

	public static void main(String[] args) {
		Deck deck = new Deck();
		
		Scanner userInput = new Scanner(System.in);
		System.out.print("How many cards do you want?");

		try {
			int numCardsToDeal = userInput.nextInt();
			if (numCardsToDeal > deck.checkDeckSize()) {
				throw new InputMismatchException();
				System.out.println("Not enough cards in the deck.");
			} else {
				List<Card> hand = new ArrayList<>(numCardsToDeal);
				int cardValue = 0;
				for (int i = 0; i < numCardsToDeal; i++) {
					Card c = deck.dealCard();
					cardValue += c.getValue();
					System.out.println(c);
					hand.add(c);
				}
				System.out.println("Your card is " + cardValue);
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid entry. Please enter a number.");
		}
		finally {
			userInput.close();
		}

	}

}

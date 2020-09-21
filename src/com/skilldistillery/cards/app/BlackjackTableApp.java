package com.skilldistillery.cards.app;

import com.skilldistillery.cards.blackjack.BlackjackDealer;
import com.skilldistillery.cards.blackjack.BlackjackPlayer;

public class BlackjackTableApp {

	public static void main(String[] args) {
		BlackjackTableApp bta = new BlackjackTableApp();
		bta.run();

	}

	public void run() {
		// local variables
		BlackjackDealer dealer = new BlackjackDealer();
		BlackjackPlayer player = new BlackjackPlayer();
		setupBlackjackGame(dealer, player);
	}

	public void setupBlackjackGame(BlackjackDealer dealer, BlackjackPlayer player) {
		// start playing
		dealer.suffleDeck();
		// give each player one card until all players have two cards
		for (int i = 0; i < 2; i++) {
			player.addCard(dealer.dealCard());
			System.out.println("Player " + player.bjHand.toString());
			dealer.addCardToHand();

		}
		System.out.println("Dealer Hand Shown Value: " + dealer.bjHand.getDealerHandShownValue());
		// see if anyone has blackjack
		evaluateHandForNaturalBlackjack(dealer, player);

	}

	private void evaluateHandForNaturalBlackjack(BlackjackDealer dealer, BlackjackPlayer player) {
		boolean playerBlackjack = player.bjHand.isBlackjack();
		boolean dealerBlackjack = dealer.bjHand.isBlackjack();
		// if all hands have blackjack, push. No winner.
		if (playerBlackjack && dealerBlackjack) {
			System.out.println("All players have blackjack. No winner.");
			playAgain(dealer, player);
		}
		// if player has blackjack and dealer does not, player wins
		else if (playerBlackjack && !dealerBlackjack) {
			System.out.println("Player has blackjack! Player wins!");
			playAgain(dealer, player);
		}
		// if dealer has blackjack and player does not, dealer wins
		else if (!playerBlackjack && dealerBlackjack) {
			System.out.println("Dealer has blackjack! Dealer wins!");
			playAgain(dealer, player);
		}
		// no one has blackjack. ask player to hit or stay
		else {
			playerHitOrStand(dealer, player);
		}
	}

	public void playerHitOrStand(BlackjackDealer dealer, BlackjackPlayer player) {
		char choice = ' ';
		// keep asking the player to hit or stay until the player either stays or busts.
		boolean keepGoing = true;
		while (keepGoing) {
			choice = player.playerHitOrStand();
			// if 'h', deal the player another card
			if (choice == 'h') {
				player.addCard(dealer.dealCard());
				// check if new card has caused the player to bust
				if (player.bjHand.isBust()) {
					System.out.println("Busted! Dealer Wins!");
					System.out.println("Player " + player.bjHand.getHandValue() + " " + player.bjHand.toString());
					//play again?
					playAgain(dealer, player);
				}
				// check if new card has caused the player to get blackjack
				else if (player.bjHand.isBlackjack()) {
					System.out.println("Blackjack! Player wins!");
					System.out.println("Player " + player.bjHand.toString());
					// play again?
					playAgain(dealer, player);
				}
				// player hasn't busted nor obtained blackjack, show hand value and ask to hit
				// or stay
				else {
					System.out.println("Player " + player.bjHand.toString());
					continue;
				}

			}
			// if player chooses to stay
			else if (choice == 's') {
				// exit the while loop
				keepGoing = false;
				// give the dealer a turn
				dealerHitorStand(dealer, player);
			}
			// check for invalid entry
			else if (choice != 'h' && choice != 's') {
				System.out.print("Invalid entry. ");
				// let player choose a valid entry
				continue;
			}
		}
	}

	private void dealerHitorStand(BlackjackDealer dealer, BlackjackPlayer player) {
		dealer.dealerHitorStand();
		if (dealer.bjHand.isBlackjack()) {
			System.out.println("Blackjack! Dealer wins!");
			//play again?
			playAgain(dealer, player);
		} else if (dealer.bjHand.isBust()) {
			System.out.println("Dealer busted! Player wins!");
			//play again?
			playAgain(dealer, player);
		} else {
			evaluateHands(dealer, player);
		}

	}

	public void evaluateHands(BlackjackDealer dealer, BlackjackPlayer player) {
		// who's hand is larger but not busted?
		if (dealer.bjHand.getHandValue() > player.bjHand.getHandValue()) {
			System.out.println("Dealer hand equals " + dealer.bjHand.getHandValue() + "\nPlayer hand equals "
					+ player.bjHand.getHandValue() + "\nDealer Wins!");
			playAgain(dealer, player);
		} else if (dealer.bjHand.getHandValue() < player.bjHand.getHandValue()) {
			System.out.println("Dealer hand equals " + dealer.bjHand.getHandValue() + "\nPlayer hand equals "
					+ player.bjHand.getHandValue() + "\nPlayer Wins!");
			playAgain(dealer, player);
		}
		// if the hands are equal, no winner game is pushed.
		else {
			System.out.println("Dealer hand equals " + dealer.bjHand.getHandValue() + "\nPlayer hand equals "
					+ player.bjHand.getHandValue() + "\nHands are tied. Game is pushed. No winner.");
			playAgain(dealer, player);
		}
	}

	private void playAgain(BlackjackDealer dealer, BlackjackPlayer player) {
		System.out.println("Game over.");
		char choice = ' ';
		boolean keepGoing = true;
		while (keepGoing) {
			// ask player if they would like to play again
			choice = player.playAgain();
			// evaluate player's choice
			// keep asking the player until a valid entry is entered
			if (choice != 'n' && choice != 'y') {
				continue;
			}
			// if yes, restart the game.
			else if (choice == 'y') {
				// exit the loop
				keepGoing = false;
				dealer.bjHand.clearHand();
				player.bjHand.clearHand();
				setupBlackjackGame(dealer, player);
				// if no, return to run and exit the game.
			} else if (choice == 'n') {
				// exit the loop
				keepGoing = false;
				System.out.println("Goodbye");
				System.exit(0);
			}
		}
	}
}

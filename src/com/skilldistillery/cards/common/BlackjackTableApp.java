package com.skilldistillery.cards.common;


public class BlackjackTableApp {

	public static void main(String[] args) {
		BlackjackTableApp bta = new BlackjackTableApp();
		bta.run();

	}

	public void run() {
		// local variables
		BlackjackDealer dealer = new BlackjackDealer();
		BlackjackPlayer player = new BlackjackPlayer();
		//start playing
		dealer.suffleDeck();
		setupBlackjackGame(dealer, player);
		System.out.println("Game over.");
		dealer.bjHand.clearHand();
		player.bjHand.clearHand();
		System.exit(0);
		
	}

	public void setupBlackjackGame(BlackjackDealer dealer, BlackjackPlayer player) {
		//give each player one card until all players have two cards
		for (int i = 0; i < 2; i++) {
			player.addCard(dealer.dealCard());
			System.out.println("Player Hand Value: " + player.bjHand.getHandValue());
			dealer.addCardToHand();

		}
		System.out.println("Dealer shown card value: " + dealer.bjHand.getDealerHandShownValue());
		//see if anyone has blackjack
		evaluateHandForNaturalBlackjack(dealer, player);

	}

	private void evaluateHandForNaturalBlackjack(BlackjackDealer dealer, BlackjackPlayer player) {
		boolean playerBlackjack = player.bjHand.isBlackjack();
		boolean dealerBlackjack = dealer.bjHand.isBlackjack();
		//if all hands have blackjack, push. No winner.
		if(playerBlackjack && dealerBlackjack) {
			System.out.println("All players have blackjack. No winner.");
		}
		//if player has blackjack and dealer does not, player wins
		else if (playerBlackjack && !dealerBlackjack) {
			System.out.println("Player has blackjack! Player wins!");
		}
		//if dealer has blackjack and player does not, dealer wins
		else if (!playerBlackjack && dealerBlackjack) {
			System.out.println("Dealer has blackjack! Dealer wins!");
			
		}
		//no one has blackjack. ask player to hit or stay
		else {playerHitOrStand(dealer, player);}		
	}

	public void playerHitOrStand(BlackjackDealer dealer, BlackjackPlayer player) {
		char choice = ' ';
		//keep asking the player to hit or stay until the player either stays or busts.
		boolean keepGoing = true;
		while (keepGoing) {
			choice = player.playerHitOrStand();
			//if 'h', deal the player another card
			if (choice == 'h') {
				player.addCard(dealer.dealCard());
				//check if new card has caused the player to bust
				if(player.bjHand.isBust()) {
				System.out.println("Busted! Dealer Wins!");
				keepGoing = false;
				}
				//check if new card has caused the player to get blackjack
				else if(player.bjHand.isBlackjack()) {
					System.out.println("Blackjack! Player wins!");
					break;
				} 
				//player hasn't busted nor obtained blackjack, show hand value and ask to hit or stay
				else {
					System.out.println("Player Hand Value: " + player.bjHand.getHandValue());
					continue;}
				
			} 
			//if player chooses to stay
			else if(choice == 's'){
				//exit the while loop
				keepGoing = false;
				//give the dealer a turn
				dealer.dealerHitorStand();
				//after the dealer goes and doesn't get blackjack or bust, see who wins
				evaluateHands(dealer, player);
			}
			//check for invalid entry
			else if (choice != 'h' && choice != 's') {
				System.out.print("Invalid entry. ");
				//let player choose a valid entry
				continue;
			}
		}
	}
	
	public void evaluateHands(BlackjackDealer dealer, BlackjackPlayer player) {
		//who's hand is larger but not busted?
		if(dealer.bjHand.getHandValue() > player.bjHand.getHandValue()) {
			System.out.println("Dealer hand equals " + dealer.bjHand.getHandValue() + 
					"\nPlayer hand equals " + player.bjHand.getHandValue() +
					"\nDealer Wins!");
		} else if (dealer.bjHand.getHandValue() < player.bjHand.getHandValue()){System.out.println("Dealer hand equals " + dealer.bjHand.getHandValue() + 
				"\nPlayer hand equals " + player.bjHand.getHandValue() +
				"\nPlayer Wins!");}
		//if the hand are equal, no winner game is pushed.
		else {System.out.println("Dealer hand equals " + dealer.bjHand.getHandValue() + 
				"\nPlayer hand equals " + player.bjHand.getHandValue() +
				"\nHands are tied. Game is pushed. No winner.");}
	}
	

}

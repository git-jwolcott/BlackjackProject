# Blackjack Project

## Overview
### Week 4 Homework
Use classes to create a functional command line blackjack game.

Upon starting the game, the deck is shuffled and each player is dealt two cards. The cards in the player's hand are shown along with the total value of the hand. The dealer's "faceup" card is shown along with its value. The system will check if either player was dealt blackjack. If either player has blackjack the hand is ended.

If neither player was dealt blackjack, the player is given the opportunity to "hit" (take another card) or "stand" (not take any additional cards). If the player selects to "hit", the dealer deals another card. The card is added to the player's hand. The cards in the player's hand are shown along with the total value of the hand. If the player obtains 21, the player wins. If the additional card causes the player's total hand value to exceed 21, the player busted (total hand value is over 21) and the dealer wins. If the total value of the player's hand, including the additional card, is less than 21, the player may choose to "hit" or "stand". The "hit"/"stand" process is repeated until the player either bust or selects to "stand".

Once the player has selected to "stand", meaning the total value of the player's hand is less than 21, the dealer takes a turn. While the value of dealer's hand is less than 17, the dealer automatically "hits". Just like with the player hand, if the dealer's hand value is 21, the dealer wins. If the dealer's hand value is greater than 21, the player wins. If the dealer's hand is more than 17 but less than 21, the dealer automatically "stands".

Once both players have stopped taking additional cards and have hand values less than 21, each player's hand is evaluate. The player with the hand value closest to 21, wins.

Once a winner is determined, the winner is announced, the hand is ended, and the player is given the option to play again. If the player selects to play again, the hands are cleared, two cards are dealt to each player, and the game continues as described above. If the player selects not to play again, the game is ended and the system is exited.

### Topics
* Java Fundamentals
* Java 1
* Java 2
* Working with UML diagrams
* Object Oriented Programming
  - Abstraction
  - Polymorphism
  - Inheritance
  - Encapsulation
* Obtaining user input
* Printing information to the terminal screen
* While loops
* Methods and passing variables between them
* Conditional statement
* Classes
  - building classes in an Object Oriented manner
  - building classes whose fields are Objects
  - static fields
  - private fields
  - getters, setters, toString, and hashCode methods
  - @Override
* Abstract Classes
* Collections
  - List interface
  - ArrayList
* Packaging

### How to Run
Depending upon the outcome of the initial deal, you will be given option to "hit" or "stand". You will enter h for hit or s for stand. You will continue to enter h or s until you obtain blackjack, go bust, or choose to stand. The remainder of the hand is automatic. At the end of the hand, enter y to play again or n to exit the game.

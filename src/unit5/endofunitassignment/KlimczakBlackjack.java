package unit5.endofunitassignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import utilities.ScannerUtils;

/*	Jacob Klimczak
 * 	May, 1, 2019
 * 	ICS3U0
 * 	Unit 5, End Of Unit Assignment, Blackjack
 */

/**
 * Has the user play a game of blackjack
 * @author Jacob
 *
 */
public class KlimczakBlackjack {
	
	//TODO : Rules
	
	public static final int DEALER_HIT_CAP = 17; //the dealer will not hit past this value
	public static final int PLAYER_STARTING_CASH = 100;
	public static final int MINIMUM_BET = 10;
	
	static Scanner m_input = new Scanner(System.in);
	
	static ArrayList<Hand> m_playerHands;
	static Hand m_dealerHand;
	static Deck m_deck;
	
	static boolean m_endGame, m_endPlayer, m_dealBustShown, m_playerBustShown = false;
	static int m_playerCash = PLAYER_STARTING_CASH;
	static int m_handNumber = 0;
	
	public static void main(String[] args) {
		while (true) {
			newGame();

			checkHands();
			
			while (!m_endGame) {
				while (!m_endPlayer) {
					playerTurn();
				}
				while (!m_dealerHand.isStand()) {
					dealerTurn();
				}
			}
			
			checkWinners();

		}		
	}
	
	/*--------------------------------------------------*/
	/*--------------------METHODS-----------------------*/
	/*--------------------------------------------------*/
	
	/**
	 * The dealer's turn
	 */
	public static void dealerTurn() {
		System.out.println("__________________________________");
		System.out.println("DEALER TURN");
		System.out.println();
		
		displayDealerHandValue();
		displayPlayerHandValue();
		
		//check if player are still in game
		boolean dealerWin = true;
		for (Hand hand : m_playerHands) {
			dealerWin = hand.getValue() > Hand.MAX_HAND_VALUE;
			if (!dealerWin)
				break;
		}
		
		//check if dealer has a soft max (i.e. ace at max, + 6 in other cards)
		boolean aceAt11 = false;
		for (Card card : m_dealerHand.getCards()) {
			aceAt11 = (card.getType() == Type.ACE && card.getValue() == Card.ACE_HIGH_VALUE); //detects aces with a value of 11
			if (aceAt11)
				break;
		}
		
		//tell the dealer whether or not to hit
		if ((m_dealerHand.getValue() < DEALER_HIT_CAP || (m_dealerHand.getValue() == DEALER_HIT_CAP && aceAt11)) && !dealerWin) { //dealer hits under 17, or at a soft 17, if there are players left in the game
			//hit
			Card card = m_deck.drawCard();
			m_dealerHand.addCard(card);
			System.out.println("The dealer drew: " + card + " - " + card.getValue());
		} else {
			//stand
			m_dealerHand.stand();
			System.out.println("The dealer chose to stand");
		}
		
		continuePrompt();
		
		checkHands();
		
	}
	
	/**
	 * The player's turn
	 */
	public static void playerTurn() {
		
		System.out.println("__________________________________");
		System.out.println("PLAYER TURN");
		System.out.println();
		
		displayDealerHandValue();
		
		for (int i = 0; i < m_playerHands.size(); i++) {
			if (!m_playerHands.get(i).isStand()) { //as long as hand is not standing
				System.out.println("Currently Playing Hand " + (i+1));
				displaySingleHandValue(i);
				
				System.out.println("What would you like to do?");
				System.out.println("\t--> Hit");
				System.out.println("\t--> Stand");
				System.out.println("\t--> Double Down");
				System.out.println("\t--> Split");
				

				
				boolean end = false;
				do {
					System.out.print(">>> ");
					String input = ScannerUtils.read(m_input);
					System.out.println();
					if (input.length() < 3)
						input = "Q"; //sets to q to avoid matching any other cases
					
					if ("Hit".matches("(?i)(.*|)" + input + "(.*|)")) { //player said hit
						Card card = m_deck.drawCard();
						m_playerHands.get(i).addCard(card);
						System.out.println("You drew: " + card + " - " + card.getValue());
						end = true;
						continuePrompt();
					} else if ("Stand".matches("(?i)(.*|)" + input + "(.*|)")) { //player said stand
						m_playerHands.get(i).stand();
						System.out.println("You choose to stand.");
						end = true;
						continuePrompt();
					} else if ("Double Down".matches("(?i)(.*|)" + input + "(.*|)")) { //player said double down
						
						if (m_playerCash >= 2*m_playerHands.get(i).getWager()) { //check if player can afford to double down
							m_playerHands.get(i).setWager(2*m_playerHands.get(i).getWager()); //doubles wager
							System.out.println("The wager is now $" + m_playerHands.get(i).getWager());
							
							Card card = m_deck.drawCard();
							m_playerHands.get(i).addCard(card);
							System.out.println("You drew: " + card + " - " + card.getValue());
							
							m_playerHands.get(i).stand();
						} else { //player can't afford it
							System.out.println("Sorry, you can't afford to double down.");
						}
						
						end = true;
						continuePrompt();
					} else if ("Split".matches("(?i)(.*|)" + input + "(.*|)")) { //player said split
						
						if (m_playerHands.get(i).getCards().length == 2 && m_playerHands.get(i).getCards()[0].getType() == m_playerHands.get(i).getCards()[1].getType()) { //capable of splitting
							m_playerHands.add(new Hand(m_playerHands.get(i).removeCard())); //creates a new hands with half of the current hand
							int wager = m_playerHands.get(i).getWager();
							m_playerHands.get(i).setWager((wager % 2 != 0 ? 1 : 0) + (wager/2)); //sets new wager on current hand (+1 if int truncation occurs)
							m_playerHands.get(m_playerHands.size()-1).setWager(wager/2); //sets new wager on new hand
							System.out.println("This hand has been split into two new hands: Hand " + (i+1) + ", and Hand " + m_playerHands.size() + ".");
							System.out.println("The wager on hand " + (i+1) + " is $" + m_playerHands.get(i).getWager());
							System.out.println("The wager on hand " + m_playerHands.size() + " is $" + m_playerHands.get(m_playerHands.size()-1).getWager());
						} else {
							System.out.println("Your hand does not currently allow you to split.");
						}
						
						end = true;
						continuePrompt();
					} else {
						System.out.println("The dealer says, \"Sorry, I couldn't quite catch that, what did you say?\"");
						System.out.println();
					}

				} while (!end);
				
				
				checkHands();
									
			}
		}
	}
	
	/**
	 * checks all hands, finds which are bust
	 */
	public static void checkHands() {
		boolean endPlayer = true;
		for (Hand hand : m_playerHands) {
			if (hand.getValue() > Hand.MAX_HAND_VALUE && !m_playerBustShown) {
				hand.stand();
				System.out.println("You have gone bust!");
				m_playerBustShown = true;
				continuePrompt();
			}
			if (endPlayer && !hand.isStand()) { //checks if all player hands are stood
				endPlayer = false;
			}
		}
		if (m_dealerHand.getValue() > Hand.MAX_HAND_VALUE && !m_dealBustShown) {
			m_dealerHand.stand();
			System.out.println("The dealer has gone bust!");
			m_dealBustShown = true;
			continuePrompt();	
		}
		
		m_endPlayer = endPlayer; //updates m_endplayer
		
		m_endGame = m_endPlayer && m_dealerHand.isStand(); //ends game if needs to
		
	}
	
	/**
	 * calculates the winner between each player hand and the dealer hand, allocates money accordingly
	 */
	public static void checkWinners() {
		System.out.println("GAME RESULTS");
		System.out.println();
		
		for (int i = 0; i < m_playerHands.size(); i++) {
			System.out.println("Player Hand " + (i+1) + ": $" + m_playerHands.get(i).getWager());
			if (m_playerHands.get(i).getValue() == Hand.MAX_HAND_VALUE && m_playerHands.get(i).getValue() != m_dealerHand.getValue()) { //player has 21 nad not a tie
				System.out.println("You have 21!");
				System.out.println("You win $" + m_playerHands.get(i).getWager());
				m_playerCash += m_playerHands.get(i).getWager();
			} else if (m_dealerHand.getValue() == Hand.MAX_HAND_VALUE && m_playerHands.get(i).getValue() != m_dealerHand.getValue()) { // dealer has 21 and not a tie
				System.out.println("The dealer has 21!");
				System.out.println("The dealer wins $" + m_playerHands.get(i).getWager());
				m_playerCash -= m_playerHands.get(i).getWager();
			} else if (m_playerHands.get(i).getValue() > Hand.MAX_HAND_VALUE) { //player is bust
				System.out.println("You went bust!");
				System.out.println("The dealer wins $" + m_playerHands.get(i).getWager());
				m_playerCash -= m_playerHands.get(i).getWager();
			} else if (m_dealerHand.getValue() > Hand.MAX_HAND_VALUE) { //dealer is bust
				System.out.println("The dealer went bust!");
				System.out.println("You win $" + m_playerHands.get(i).getWager());
				m_playerCash += m_playerHands.get(i).getWager();
			} else if (m_playerHands.get(i).getValue() > m_dealerHand.getValue()) { //player wins
				System.out.println("The player has a higher score!");
				System.out.println("You win $" + m_playerHands.get(i).getWager());
				m_playerCash += m_playerHands.get(i).getWager();
			} else if (m_playerHands.get(i).getValue() < m_dealerHand.getValue()) { //dealer wins
				System.out.println("The dealer has a higher score!");
				System.out.println("The dealer wins $" + m_playerHands.get(i).getWager());
				m_playerCash -= m_playerHands.get(i).getWager();
			} else { //push (tie game)
				System.out.println("Push, the scores are even! Ties go to the dealer!");
				System.out.println("The dealer wins $" + m_playerHands.get(i).getWager());
				m_playerCash -= m_playerHands.get(i).getWager();
			}
			
			System.out.println();
			
			System.out.println("You now have $" + m_playerCash);
			continuePrompt();
		}
		
		//trashes cards from both hands
		for (Card card : m_dealerHand.getCards()) { //trashes dealer cards
			m_deck.trash(card);
		}
		
		for (Hand hand : m_playerHands) { //iterates through all player hands
			for (Card card : hand.getCards()) { //iterates through all cards in hand
				m_deck.trash(card);
			}
		}
		
		m_handNumber++; //iterates hand number
	}
	
	/**
	 * The player sets his wager
	 * @return the wager the player set
	 */
	public static int setWager() {
		System.out.println("You currently have $" + m_playerCash);
		System.out.print("Please place your bet (" + MINIMUM_BET + " - " + m_playerCash + "): ");
		
		int wager = 0;
		
		try {
			wager = ScannerUtils.readIntRange(m_input, MINIMUM_BET, m_playerCash);
		} catch (Exception e) {
			System.out.println();
			System.out.println("That betting amount is not within acceptable ranges.");
			System.out.println("please place a different bet.");
			System.out.println();
			wager = setWager();
			m_playerHands.get(0).setWager(wager);
			return wager;
		}
		
		System.out.println();
		
		System.out.println("You have bet $" + wager);
		System.out.println("Are you ok with this (y/n)?");
		if (ScannerUtils.yesQuery(m_input)) {
			System.out.println();
			m_playerHands.get(0).setWager(wager);
			return wager;
		} else {
			System.out.println();
			wager = setWager();
			m_playerHands.get(0).setWager(wager);
			return wager;
		}
		
	}
	
	/**
	 * starts a new game and deals out cards
	 */
	public static void newGame() {
		m_endPlayer = false;
		m_endGame = false;
		m_dealBustShown = false;
		m_playerBustShown = false;
		
		m_playerHands = new ArrayList<Hand>() {
			{
			add(new Hand());
			}
		};
		m_dealerHand = new Hand();
		
		if (m_handNumber % 20 == 0) { //if a multiple of 20 hands has been played
			m_deck = new Deck(6);
			m_handNumber = 0; //resets handNumber, technically good practice to avoid int limit
		}
		
		setWager();
		
		deal();
		
		if (m_dealerHand.getCards()[0].getType() == Type.ACE) { //dealers upcard is ace, prompt for insurance
			System.out.println("You may have noticed that the dealer's upcard is an ace. He may have blackjack.");
			System.out.println("If you would like, you can take insurance against the dealer, reclaiming half your wager from the pot.");
			System.out.println("Would you like to take insurance (y/n)?");
			
			if (ScannerUtils.yesQuery(m_input)) { //insurance
				m_playerHands.get(0).setWager(m_playerHands.get(0).getWager()/2); //halves wager
				System.out.println("You are now betting $" + m_playerHands.get(0).getWager());
			} else { //no insurance
				
			}
			
			System.out.println();
			
		}
		
		System.out.println("It is with these hands that the game begins.");
		continuePrompt();
		
	}
	
	/**
	 * deals out cards to the player and the dealer
	 */
	public static void deal() {
		m_playerHands.get(0).addCard(m_deck.drawCard()); //the dealer deals to you
		m_dealerHand.addCard(m_deck.drawCard()); //then to himself
		m_playerHands.get(0).addCard(m_deck.drawCard()); //your second card is dealt to you
		m_dealerHand.addCard(m_deck.drawCard()); //finally to himself
		System.out.println("The dealer deals the cards.");
		System.out.println();
		displayDealerHandValue();	
		displayPlayerHandValue();
	}
	
	/**
	 * Display the value of the player's hand(s)
	 */
	public static void displayPlayerHandValue() {
		for (int i = 0; i < m_playerHands.size(); i++) {
			System.out.println("PLAYER HAND" + (m_playerHands.size() == 1 ? "" : (" " + (i+1))));
			System.out.println("Wager On This Hand: $" + m_playerHands.get(i).getWager());
			System.out.println("Overall Value: " + m_playerHands.get(i).getValue());
			System.out.println("Hand Breakdown (Card - Value):");
			for (Card card : m_playerHands.get(i).getCards()) {
				System.out.println("\t--> " + card + " - " + card.getValue());
			}
			System.out.println();
		}
	}
	
	/**
	 * displays the value of a single player hand
	 * @param i the index of the hand to display
	 */
	public static void displaySingleHandValue(int i) {
		System.out.println("PLAYER HAND" + (m_playerHands.size() == 1 ? "" : (" " + (i+1))));
		System.out.println("Wager On This Hand: $" + m_playerHands.get(i).getWager());
		System.out.println("Overall Value: " + m_playerHands.get(i).getValue());
		System.out.println("Hand Breakdown (Card - Value):");
		for (Card card : m_playerHands.get(i).getCards()) {
			System.out.println("\t--> " + card + " - " + card.getValue());
		}
		System.out.println();
	}
	
	/**
	 * Display the value of the dealer's hand
	 */
	public static void displayDealerHandValue() {
		if (m_endPlayer) { //it is the dealer's turn
			System.out.println("DEALER HAND");
			System.out.println("Overall Value: " + m_dealerHand.getValue());
			System.out.println("Hand Breakdown (Card - Value):");
			for (Card card : m_dealerHand.getCards()) {
				System.out.println("\t--> " + card + " - " + card.getValue());
			}
			System.out.println();
		} else { //player is still making moves
			System.out.println("DEALER HAND");
			System.out.println("Overall Value: " + m_dealerHand.getCards()[0].getValue() + " + The Value Of The Hidden Card");
			System.out.println("Hand Breakdown (Card - Value):");
			System.out.println("\t--> " + m_dealerHand.getCards()[0] + " - " + m_dealerHand.getCards()[0].getValue());
			System.out.println("\t--> Hidden Card - Unknown Value");
			System.out.println();
		}
	}
	
	/**
	 * prompts the user to press enter before they can continue
	 */
	public static void continuePrompt() {
		System.out.println();
		System.out.println("(press enter to continue)");
		
		ScannerUtils.read(m_input);
	}
	
	/*--------------------------------------------------*/
	/*----------------------CLASSES---------------------*/
	/*--------------------------------------------------*/
	
	/**
	 * Enum representing the suit of each card
	 * @author Jacob
	 *
	 */
	static enum Suit {
		HEARTS,
		CLUBS,
		SPADES,
		DIAMONDS;
		
		@Override
		public String toString() {
			switch (this) {
			
			case HEARTS:
				return "Hearts";
				
			case CLUBS:
				return "Clubs";
				
			case SPADES:
				return "Spades";
	
			case DIAMONDS:
				return "Diamonds";
				
			default:
				return "Suit";
				
			
			}
		}
	}
	
	
	/**
	 * Enum representing the name of each card
	 * @author Jacob
	 *
	 */
	static enum Type {
		ACE,
		TWO,
		THREE,
		FOUR,
		FIVE,
		SIX,
		SEVEN,
		EIGHT,
		NINE,
		TEN,
		JACK,
		QUEEN,
		KING;
		
		@Override
		public String toString() {
			switch (this) {
			
			case ACE:
				return "Ace";
				
			case TWO:
				return "Two";
				
			case THREE:
				return "Three";
				
			case FOUR:
				return "Four";
				
			case FIVE:
				return "Five";
				
			case SIX:
				return "Six";
				
			case SEVEN:
				return "Seven";
				
			case EIGHT:
				return "Eight";
				
			case NINE:
				return "Nine";
				
			case TEN:
				return "Ten";
				
			case JACK:
				return "Jack";
				
			case QUEEN:
				return "Queen";
				
			case KING:
				return "King";
				
			default:
				return "Name";
			
			}
		}
	}
	
	/**
	 * Class representing a card
	 * @author Jacob
	 *
	 */
	static class Card {
		
		public static final int ACE_HIGH_VALUE = 11;
		public static final int ACE_LOW_VALUE = 1;
		
		private Suit m_suit;
		private Type m_type;
		private int m_value;
		
		/**
		 * Initializes a card with a suit and a type (i.e. Ace of Spades)
		 * @param suit The suit of the card
		 * @param name The type of the card
		 */
		public Card(Suit suit, Type type) {
			
			m_suit = suit; //assigns variables
			m_type = type;
			
			switch (m_type) { //determines value
			
			case ACE: //ace will need to be a special case with the value calculated by the hand as opposed to the card
				
				m_value = ACE_HIGH_VALUE;
				
				break;
				
			case TWO:
				
				m_value = 2;
				
				break;
				
			case THREE:
				
				m_value = 3;
				
				break;
				
			case FOUR:
				
				m_value = 4;
				
				break;
				
			case FIVE:
				
				m_value = 5;
				
				break;
				
			case SIX:
				
				m_value = 6;
				
				break;
				
			case SEVEN:
				
				m_value = 7;
				
				break;
								
			case EIGHT:
				
				m_value = 8;
				
				break;
				
			case NINE:
				
				m_value = 9;
				
				break;
				
			case TEN:
				
			case JACK:
				
			case QUEEN:
				
			case KING:
				
				m_value = 10;
				
				break;
			
			}
			
		}
		
		@Override
		public String toString() {
			return m_type + " of " + m_suit;
		}
		
		public int getValue() {
			return m_value;
		}
		
		/**
		 * Sets value of a card, only used for aces
		 * @param value the value to assign a card
		 */
		public void setValue(int value) {
			m_value = value;
		}
		
		/**
		 * Return the suit of the card
		 * @return the suit of the card
		 */
		public Suit getSuit() {
			return m_suit;
		}
		
		/**
		 * Returns the type of the card
		 * @return the type of the card
		 */
		public Type getType() {
			return m_type;
		}
		
	}
	
	/**
	 * class representing one player's hand
	 * @author Jacob
	 *
	 */
	static class Hand {
		
		public static final int MAX_HAND_VALUE = 21; //max value for a hand
		
		private ArrayList<Card> m_cards = new ArrayList<Card>();
		private int m_wager = 0;
		private boolean m_stand = false;
		
		/**
		 * Constructor for Hand class, initializes with a list of cards
		 * @param cards list of cards in hand at init
		 */
		public Hand(Card... cards) {
			for (Card card : cards) { //adds init cards to hand
				m_cards.add(card);
			}
		}
		
		/**
		 * Returns the value of the hand, calculates aces if necessary
		 * @return the overall value of the hand
		 */
		public int getValue() {
			
			int value = 0;
			ArrayList<Card> aces = new ArrayList<Card>(); //list of all aces in the hand, they must be calculated last
			
			for (Card card : m_cards) { //iterates through normal cards
				if (card.getType() != Type.ACE) { //if the card is not an ace
					value += card.getValue();
				} else { //if the card is an ace
					aces.add(card);
				}
			}
			
			for (Card ace : aces) { //iterates through aces
				
				ace.setValue(Card.ACE_HIGH_VALUE);
				
				if (value + ace.getValue() + ((aces.size() - (aces.indexOf(ace)+1))*Card.ACE_LOW_VALUE) > Hand.MAX_HAND_VALUE) { //if the value with the ace at high exceeds the max, make the ace low
					ace.setValue(Card.ACE_LOW_VALUE);
				}
				
				value += ace.getValue(); //add current value of ace
			}
			
			return value;
		}
		
		/**
		 * Sets the wager on this hand
		 * @param wager the value to set the wager to
		 */
		public void setWager(int wager) {
			m_wager = wager;
		}
		
		/**
		 * Gets the wager on this hand
		 * @return the wager on this hand
		 */
		public int getWager() {
			return m_wager;
		}
		
		/**
		 * stands this hand
		 */
		public void stand() {
			m_stand = true;
		}
		
		/**
		 * Indicates the status of this hand
		 * @return whether or not this hand has stood
		 */
		public boolean isStand() {
			return m_stand;
		}
		
		/**
		 * Returns an array of all cards in this hand
		 * @return an array of cards in the hand
		 */
		public Card[] getCards() {
			return m_cards.toArray(new Card[m_cards.size()]);
		}
		
		/**
		 * Adds a card to this hand
		 * @param card the card to add
		 */
		public void addCard(Card card) {
			m_cards.add(card);
		}
		
		/**
		 * Removes the last card from the hand
		 * @return the card that was removed
		 */
		public Card removeCard() {
			try {
				Card card = m_cards.get(m_cards.size()-1);
				m_cards.remove(card);
				return card;
			} catch (Exception e) {
				return null;
			}	
		}
		
	}
	
	/**
	 * class representing a deck of cards
	 * @author Jacob
	 *
	 */
	static class Deck {
		
		private ArrayList<Card> m_deck;
		private ArrayList<Card> m_trash;
		
		/**
		 * Creates a new stack (collection of decks) containing a specified number of decks
		 * @param stackNumber the number of decks you want in the stack
		 */
		public Deck(int stackNumber) {
			m_deck = new ArrayList<Card>(); //empties arraylists
			m_trash = new ArrayList<Card>();//empties arraylists
			for (int i = 0; i < stackNumber; i++) { //adds the specified number of decks to the stack
				for (Suit suit : Suit.values()) { //iterates through all suits
					for (Type type : Type.values()) { //iterates through all types
						addCard(new Card(suit, type)); //adds one card of every suit and type
					}
				}
			}
			
			this.shuffle(); //shuffles the deck/stack
		}
		
		/**
		 * Creates a single deck stack with 52 cards
		 */
		public Deck() {
			this(1);
		}
		
		
		/**
		 * Adds a card to the end of the deck/stack
		 * @param card adds a card to the deck/stack
		 */
		public void addCard(Card card) {
			m_deck.add(card);
		}
		
		/**
		 * Removes a card from the deck if it exists
		 * @param card the card to remove
		 */
		public void removeCard(Card card) {
			m_deck.remove(card);
		}
		
		/**
		 * removes the last card from the deck
		 */
		public void removeCard() {
			try {
				m_deck.remove(m_deck.get(m_deck.size()-1));
			} catch (Exception e) {
				
			}		
		}
		
		/**
		 * Returns all cards in the deck
		 * @return an array containing all cards in this deck
		 */
		public Card[] getDeck() {
			return m_deck.toArray(new Card[m_deck.size()]);
		}
		
		/**
		 * Shuffles the deck, randomizes order of cards
		 */
		public void shuffle() {
			Collections.shuffle(m_deck);
		}
		
		/**
		 * Draws the last card from the deck, if out of cards refills from trash
		 * @return the card that was drawn
		 */
		public Card drawCard() {
			
			Card card;
			
			try {
				card = m_deck.get(m_deck.size()-1);
				m_deck.remove(card);
			} catch (Exception e) { //if out of cards
				replenishDeck(); //refill from trash
				card =  drawCard(); //draw a new card
			}

			return card;
		}
		
		/**
		 * Adds a card to the trash, cards in the trash are used when the deck needs to be replenished
		 * @param card the card to add to the trash
		 */
		public void trash(Card card) {
			m_trash.add(card);
		}
		
		/**
		 * Replenishes the deck with cards from the trash
		 * @throws IndexOutOfBoundsException if the trash is empty
		 */
		public void replenishDeck() throws IndexOutOfBoundsException {
			if (m_trash.size() > 0) { //if the trash isn't empty (necessary to avoid infinite loops with drawcard calling itself recursively)
				for (Card card : m_trash) { //adds cards to deck
					m_deck.add(card);
				}
				m_trash.removeAll(m_trash); //empties trash		
				shuffle(); //re shuffles	
			} else {
				throw new IndexOutOfBoundsException(); //throws exception
			}
			
		}
		
	}
	
}

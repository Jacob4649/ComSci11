package unit5.assignment2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import utilities.ScannerUtils;

/*	Jacob Klimczak
 * 	May, 1, 2019
 * 	ICS3U0
 * 	Unit 5, Assignment 2, Question 5
 */

/**
 * Has the user repeatedly guess a number until they eventually succeed
 * @author Jacob
 *
 */
public class KlimczakA2Q5 {

	static int m_number = 0; //number to guess
	static int m_guess = 0; //guess
	static int m_invalid = 3;
	static boolean m_end = false; //end the program
	
	static Scanner m_input = new Scanner(System.in);
	static Random m_rand = new Random();
	
	public static void main(String[] args) {
		
		//opening details
		System.out.println("Number Guessing Game");
		System.out.println("The computer will pick a random number between 1 and 50 (inclusive).");
		System.out.println("The player is to guess this random number.");
		System.out.println("The player has unlimited guesses.");
		System.out.println("The game will end if the player enters guesses not between 1 and 50, 3 times.");
		continuePrompt();
		
		while (!m_end) {
			
			System.out.println("Computer: Picking a random number");
			
			m_number = m_rand.nextInt(49) + 1; //picks random number
			m_invalid = 0; //resets value of invalid
			
			System.out.println("Computer: A random number between 1 and 50 (inclusive) has been selected");
			
			continuePrompt();
			
			System.out.println();
			
			do {
				System.out.println("Input Guess:"); //prompts for number
				System.out.print(">>> ");
				
				try {
					m_guess = ScannerUtils.readIntRange(m_input, 1, 50);
				} catch (InputMismatchException e) {
					if (m_invalid < 3)
						m_invalid++;
					else
						break;
				}
				
				System.out.println();
				
				if (m_guess == m_number) { //correct guess
					System.out.println("Correct");
				} else if (Math.abs(m_guess - m_number) <= 3) { //really close
					System.out.println("Almost Got It!");
				} else if (Math.abs(m_guess - m_number) <= 10) { //pretty close
					System.out.println("Too " + (m_guess > m_number ? "high " : "low ") + "but close!");
				} else if (m_guess > m_number) { //greater than selected number
					System.out.println("Too High");
				} else { //less than selected number
					System.out.println("Too Low");
				}
				
				System.out.println();
				
			} while (m_number != m_guess);
			
			if (m_invalid == 3) {
				System.out.println("You Lose!");
				System.out.println("Nice try, better luck next time.");
				System.out.println("The number was " + m_number);
				continuePrompt();
			} else {
				System.out.println("You Win!");
				System.out.println("Congratulations!");
				continuePrompt();
			}
			
		}
		
		System.out.println();
		System.out.println("Terminating Program");

	}
	
	static void continuePrompt() {
		System.out.println();
		System.out.println("(press enter to continue)");
		
		ScannerUtils.read(m_input);
	}
	
}

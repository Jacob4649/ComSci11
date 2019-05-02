package unit5.assignment2;

import java.util.Scanner;
import utilities.ScannerUtils;
import java.util.Random;
import java.util.Arrays;

/*	Jacob Klimczak
 * 	May, 1, 2019
 * 	ICS3U0
 * 	Unit 5, Assignment 2, Question 4
 */

/**
 * Has the user repeatedly guess a 6 digit password until they eventually succeed
 * @author Jacob
 *
 */
public class KlimczakA2Q4 {
	
	static int[] m_password = {0, 0, 0, 0, 0, 0};
	static String m_guessString = "";
	static int[] m_guess = {0, 0, 0, 0, 0, 0};
	static int m_count = 0;
	
	static Scanner m_input = new Scanner(System.in);
	static Random m_rand = new Random();
	
	public static void main(String[] args) {
		
		System.out.println("Password Guessing Game");
		System.out.println();
		
		System.out.println("A random 6 digit password has been generated.");
		System.out.println("You are to try and guess it.");
		System.out.println("You have as many tries as you need.");
		System.out.println("If at any point you would like to exit the game, type \"end\"");
		System.out.println();
		
		for (int i = 0; i < 6; i++) {
			m_password[i] = m_rand.nextInt(9);
		}

		do {

			System.out.print("Input Guess (6 Digits, 0-9, No Spaces): ");
			
			m_guessString = ScannerUtils.readWord(m_input);
			
			if (m_guessString.matches("^(?i)end$"))
				break;
			
			if (m_guessString.matches("^(\\d){6}$")) { //input is valid
				
				char[] guess = m_guessString.toCharArray();
				
				for (int i = 0; i < 6; i++) {
					m_guess[i] = Character.getNumericValue(guess[i]); //sets values of guess
				}
				
			} else { //invalid input
				for (int i = 0; i < 6; i++) { //resets guess
					m_guess[i] = m_password[i] + 1;
				}
				System.out.println("Invalid Input");
			}
			
			System.out.println((Arrays.equals(m_password, m_guess) ? "Correct!" : "Incorrect, Try Again"));
			
			System.out.println();
			
			m_count ++;
			
		} while (!Arrays.equals(m_password, m_guess));
		
		System.out.println();
		
		if (Arrays.equals(m_password, m_guess)) {
			System.out.println("You guessed the password!");
			System.out.print("It was ");
			for (int i : m_password) {
				System.out.print(i);
			}
			System.out.println();
			System.out.println("It only took you " + m_count + (m_count != 1 ? " tries!" : " try!"));
		} else {
			System.out.println("You have exited the game after " + m_count + (m_count != 1 ? " tries!" : " try!"));
			System.out.println("The password was ");
			for (int i : m_password) {
				System.out.print(i);
			}
			System.out.println();
			System.out.println("Better luck next time.");
		}
		
	}
	
}

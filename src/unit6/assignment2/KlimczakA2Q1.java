package unit6.assignment2;

import java.util.Scanner;

import utilities.ScannerUtils;

/*	Jacob Klimczak
 * 	May, 15, 2019
 * 	ICS3U0
 * 	Unit 6, Assignment 2, Question 1
 */

/**
 * Determines the number of vowels, consonants, and spaces in a given string
 * @author Jacob
 *
 */
public class KlimczakA2Q1 {

	static Scanner m_input = new Scanner(System.in);
	
	static int m_vowels, m_consonants, m_spaces, m_other = 0;
	static String m_word;
	
	public static void main(String[] args) {
		System.out.println("Character Counter");
		System.out.println();
		
		while (true) {
			m_vowels = 0;
			m_consonants = 0;
			m_spaces = 0;
			m_other = 0;
			
			System.out.print("Enter your Word: "); //prompts
			
			//gets input
			m_word = ScannerUtils.read(m_input);
			
			if (m_word.matches("(?i)^Stop$")) 
				break;
			
			for (char c : m_word.toCharArray()) {
				if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U') { //c is a vowel
					m_vowels++;
				} else if (c == ' ') { //space
					m_spaces++;
				} else if (("" + c).matches("(?i)[A-Z]")) { //consonant
					m_consonants++;
				} else { //other character
					m_other++;
				}
			}
			
			//display result
			System.out.print("Result: " + (m_vowels > 0 ? (m_vowels + " vowel(s), ") : ""));
			System.out.print((m_consonants > 0 ? (m_consonants + " consonant(s), ") : ""));
			System.out.print((m_spaces > 0 ? (m_spaces + " space(s), ") : ""));
			System.out.print((m_other > 0 ? (m_other + " other character(s), ") : ""));
			System.out.println((m_vowels + m_consonants + m_spaces + m_other) + " total character(s)");
			System.out.println();
			
		}
		
		System.out.println();
		System.out.println("Terminating Program");
		
	}
	
}

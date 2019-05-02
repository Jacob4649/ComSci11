package unit5.assignment1;

import java.util.Scanner;
import utilities.ScannerUtils;

/*	Jacob Klimczak
 * 	April, 10, 2019
 * 	ICS3U0
 * 	Unit 5, Assignment 1, Leapyear Question
 */

/**
 * Takes a year as input, indicates whether it was a leap year
 * @author Jacob
 *
 */
public class KlimczakA1Q2 {

	static Scanner m_input = new Scanner(System.in);
	
	static boolean m_end = false;
	
	static int m_year = 0;
	
	public static void main(String[] args) {
		
		System.out.println("Leap Year Calculator"); //title
		
		while (!m_end) {
			System.out.println();
			
			System.out.print("Input a year: ");
			
			m_year = ScannerUtils.readInt(m_input);
			
			if (m_year < 1582) { //checks if year is within range
				System.out.println("The Gregorian Calendar did not exist prior to 1582,\nPlease input a valid date on the Gregorian Calendar");
				continue;
			}
			
			System.out.println(m_year + " is" + ((m_year % 4 == 0 && !(m_year % 100 == 0 && !(m_year % 400 == 0))) ? " " : " not ") + "a leapyear!"); //checks to see if it was a leapyear
				
			System.out.println();
			
			System.out.println("Do you wish to enter another year? (y/n)"); //does the user wish to continue
			m_end = !ScannerUtils.yesQuery(m_input);
			
		}
		
		System.out.println();
		System.out.println("Terminating Program");
		
	}
	
}

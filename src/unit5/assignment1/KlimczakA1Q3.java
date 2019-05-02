package unit5.assignment1;

import java.util.Scanner;
import utilities.ScannerUtils;

/*	Jacob Klimczak
 * 	April, 10, 2019
 * 	ICS3U0
 * 	Unit 5, Assignment 1, Addition Question
 */

/**
 * Adds up the provided integers until a zero is input
 * @author Jacob
 *
 */
public class KlimczakA1Q3 {

	static Scanner m_input = new Scanner(System.in);
	
	static boolean m_end = false;
	
	static long m_sum = 0;
	
	public static void main(String[] args) {
		
		System.out.println("Adding Program"); //title
		
		System.out.println();
		
		while (!m_end) {
			
			System.out.println("I will add up the numbers you give me");
			System.out.print("Number: "); //prompts user for input
			
			int num = ScannerUtils.readInt(m_input); //reads input
			m_sum += num; //adds to sum
			m_end = (num == 0); //checks if should end
			
			if (num != 0) //only if number is nonzero
				System.out.println("The total so far is " + m_sum); //prints running total
		}
		
		System.out.println();
		System.out.println("The total is " + m_sum); //prints total
		
	}
	
}

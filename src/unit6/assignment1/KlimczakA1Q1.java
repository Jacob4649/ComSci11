package unit6.assignment1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utilities.ScannerUtils;

/*	Jacob Klimczak
 * 	May, 15, 2019
 * 	ICS3U0
 * 	Unit 6, Assignment 1, Question 1
 */

/**
 * Has the user input a name, outputs a variety of info
 * @author Jacob
 *
 */
public class KlimczakA1Q1 {

	static Scanner m_input = new Scanner(System.in);
	
	static Matcher m_matcher;
	
	static String m_name = "";
	
	public static void main(String[] args) {
		System.out.println("Name Recognition Machine - Enter Your Name (FirstName LastName)");
		System.out.print("Enter Name: ");
		
		while (true) {
			m_name = ScannerUtils.read(m_input);
			m_matcher = Pattern.compile("^(\\w*) (\\w*)$").matcher(m_name); //compares with regex, checks for groups
			
			if (m_matcher.find()) //if groups are found, breaks
				break;
			
			System.out.println("Invalid Input"); //if not breaks, prints invalid input and restarts
		}
		
		//outputs a variety of info in a bunch of formats
		System.out.println("Result (Lastname FIRSTNAME): " + m_matcher.group(2).substring(0, 1).toUpperCase() + m_matcher.group(2).substring(1, m_matcher.group(2).length()).toLowerCase() + " " + m_matcher.group(1).toUpperCase());
		
		System.out.println("Initials: " + Character.toUpperCase(m_matcher.group(1).charAt(0)) + Character.toUpperCase(m_matcher.group(2).charAt(0)));
		
		System.out.println("First Name Letter Count: " + m_matcher.group(1).length());
		
		System.out.println("Last Name Letter Count: " + m_matcher.group(2).length());
	}
	
	
	
}

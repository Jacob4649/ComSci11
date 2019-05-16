package unit6.assignment3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utilities.ScannerUtils;

/*	Jacob Klimczak
 * 	May, 15, 2019
 * 	ICS3U0
 * 	Unit 6, Assignment 3, Question 1
 */

/**
 * Calculator for +-*\/^
 * @author Jacob
 *
 */
public class KlimczakA3Q1 {

	static Scanner m_input = new Scanner(System.in);
	
	static Matcher m_matcher;
	
	static String m_calculation = "";
	
	static char m_operator;
	
	static double m_arg1, m_arg2, m_ans = 0;
	
	public static void main(String[] args) {
		System.out.println("Calculator");
		
		System.out.print("Enter calculation: "); //prompts 
		
		while (true) {
			m_calculation = ScannerUtils.read(m_input).replaceAll(" ", ""); //reads input removes all spaces
		
			m_matcher = Pattern.compile("^(\\-?\\d+\\.?\\d*)([-^+*\\/])((\\-?\\d*\\.?\\d+))$").matcher(m_calculation); 
			//java's regex engine cannot correctly parse (\\-?\\d+\\.?\\d*)([-^+*\\/])(\\-?\\d+\\.?\\d*)
			//for this reason, an additional capture group is necessary around the third capture group
			//see: https://stackoverflow.com/questions/14712932/bug-in-java-regex-implementation
			
			if (m_matcher.find())
				break;
			
			System.out.println("Invalid Input");
		}
		
		//parses components
		m_arg1 = Double.parseDouble(m_matcher.group(1));
		m_arg2 = Double.parseDouble(m_matcher.group(3));
		m_operator = m_matcher.group(2).toCharArray()[0];
		
		switch (m_operator) { //evaluates answer
		
		case '+':
			m_ans = m_arg1 + m_arg2;
			break;
			
		case '-':
			m_ans = m_arg1 - m_arg2;
			break;
			
		case '*':
			m_ans = m_arg1 * m_arg2;
			break;
			
		case '/':
			m_ans = m_arg1 / m_arg2;
			break;
			
		case '^':
			m_ans = Math.pow(m_arg1, m_arg2);
			break;
			
		default:
			m_ans = 0;
		
		}
		
		System.out.println();
		
		System.out.println(m_arg1 + " " + m_operator + " " + m_arg2 + " = " + m_ans); //displays answer
		
	}
	
}

package assignment3;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

/*	Jacob Klimczak
 * 	March, 6, 2019
 * 	ICS3U0
 * 	Assignment 3, Math Question
 */

/**
 * This program takes two integers, and two doubles.
 * It performs some operations on both sets of numbers and prints the results to the screen.
 * @author Jacob
 *
 */
public class KlimczakA3Math {

	static Scanner m_input = new Scanner(System.in);
	
	static int m_int1, m_int2, m_GCD, m_rem, m_div = 0;
	static double m_d1, m_d2;
	
	static DecimalFormat m_threePlaces = new DecimalFormat("#.###");
	static DecimalFormat m_onePlace = new DecimalFormat("#.#");
	static DecimalFormat m_noPlaces = new DecimalFormat("#");
	
	public static void main(String[] args) {
		
		//sets rounding modes on decimal formats
		m_threePlaces.setRoundingMode(RoundingMode.HALF_UP);
		m_onePlace.setRoundingMode(RoundingMode.HALF_UP);
		m_noPlaces.setRoundingMode(RoundingMode.HALF_UP);
		
		/*
		 * Integer Math Portion
		 * Takes two integers in, outputs various operations performed on those inputs
		 */
		
		System.out.println("Please Enter 2 Numbers For Integer Mathematics:");
		
		//gets first integer value
		System.out.print("Integer Number 1: ");
		m_int1 = ScannerUtils.readInt(m_input);	
		
		//gets second integer value
		System.out.print("Integer Number 2: ");
		m_int2= ScannerUtils.readInt(m_input); 	
		
		System.out.print("\n");
		
		//prints result of addition
		System.out.println("Addition: " + m_int1 + " + " + m_int2 + " = " + (m_int1 + m_int2) + ""); 			
		//prints result of subtraction
		System.out.println("Subtraction: " + m_int1 + " - " + m_int2 + " = " + (m_int1 - m_int2) + "");			
		//prints result of multiplication
		System.out.println("Multiplication: " + m_int1 + " * " + m_int2 + " = " + (m_int1 * m_int2) + "");		
		
		//finds the result and remainder when the two numbers when divided
		if (m_int2 != 0) {
			m_div = m_int1 / m_int2; 	
			m_rem = m_int1 % m_int2;	
		}
		
		//prints result of integer division
		System.out.println("Integer Division (No Remainder): " + m_int1 + " / " + m_int2 + " = " + m_div + "");	
		//prints remainder after integer division
		System.out.println("Remainder After Integer Division: " + m_rem + "");									
		//prints as a mixed number in reduced form
		System.out.println("As A Fraction: " + m_int1 + " / " + m_int2 + " = " + m_div + " and " + m_rem/findGCD(m_rem, m_int2) + " / " + m_int2/findGCD(m_rem, m_int2) + "");	
		//prints the absolute value of m_int1
		System.out.println("The Absolute Value Of Integer Number 1 Is: " + Math.abs(m_int1) + "");
		//prints the square of int2
		System.out.println("Integer Number 2 Raised To The Exponent 2 Is: " + (int) Math.pow(m_int2, 2) + "");
		
		/*
		 * Decimal Math Portion
		 * Takes two doubles in and outputs the results of various operations performed on those inputs
		 */
		
		System.out.println("Please Enter 2 Numbers For Decimal Mathematics:");
		
		//gets first integer value
		System.out.print("Decimal Number 1: ");
		m_d1 = ScannerUtils.readDouble(m_input);	
		
		//gets second integer value
		System.out.print("Decimal Number 2: ");
		m_d2= ScannerUtils.readDouble(m_input); 	
		
		System.out.print("\n");
		
		//prints result of addition
		System.out.println("Addition: " + m_d1 + " + " + m_d2 + " = " + m_threePlaces.format(m_int1 + m_int2) + ""); 			
		//prints result of subtraction
		System.out.println("Subtraction: " + m_d1 + " - " + m_d2 + " = " + m_threePlaces.format(m_d1 - m_d2) + "");			
		//prints result of multiplication
		System.out.println("Multiplication: " + m_d1 + " * " + m_d2 + " = " + m_threePlaces.format(m_d1 * m_d2) + "");		
		//prints result of division
		System.out.println("Division: " + m_d1 + " / " + m_d2 + " = " + m_threePlaces.format(m_d1 / m_d2) + "");
		
		System.out.print("\n");
		
		//prints square root of first double
		System.out.println("The Square Root Of " + m_d1 + " (Three Decimal Places) = " + m_threePlaces.format(Math.sqrt(m_d1)) + "");
		//prints square root of second double
		System.out.println("The Square Root Of " + m_d2 + " (One Decimal Place) = " + m_onePlace.format(Math.sqrt(m_d2)) + "");
		//prints the first double rounded
		System.out.println("The Value " + m_d1 + " Rounded Is " + m_noPlaces.format(m_d1) + "");
		System.out.println("The Value " + m_d2 + " Rounded Is " + m_noPlaces.format(m_d2) + "");
	}
	
	/**
	 * Finds the greatest common denominator of two integers
	 * @param int1 the first integer
	 * @param int2 the second integer
	 * @return The greatest common denominator of the two numbers inputed
	 */
	public static int findGCD(int int1, int int2) {
		int gcd = 1;
		
		for (int i = 2; i <= int1 && i <= int2; i++) {
			if (int1 % i == 0 && int2 % i == 0)
				gcd = i;
		}
		
		return gcd;
	}
	
}

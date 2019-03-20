package unit3.assignment3;

import java.text.DecimalFormat;
import java.util.Scanner;
import unit3.assignment3.ScannerUtils;

/*	Jacob Klimczak
 * 	March, 6, 2019
 * 	ICS3U0
 * 	Assignment 3, Math Question
 */

/**
 * Takes height and weight, and outputs body mass index
 * @author Jacob
 *
 */
public class KlimczakA3BMI {


	static Scanner m_input = new Scanner(System.in);
	
	static double m_height, m_weight, m_feet, m_inches, m_bMI = 0;
	static int m_inputMode = 0;
	
	static DecimalFormat m_fivePlaces = new DecimalFormat("#.#####");
	static DecimalFormat m_onePlace = new DecimalFormat("#.#");
	static DecimalFormat m_noPlaces = new DecimalFormat("#");
	
	public static void main(String[] args) {
		
		/*
		 * Calculates and outputs BMI based on height and weight inputed
		 */
		
		System.out.println("Body Mass Index Calculator");
		
		System.out.print("\n");
		
		//selects input units
		System.out.println("Enter input units:");
		System.out.println("\t1 - Meters & Kilograms");
		System.out.println("\t2 - Inches & Pounds");
		System.out.println("\t3 - Feet & Pounds");
		System.out.print("\n");
		System.out.print("Input: ");
		while (true) {
			m_inputMode = ScannerUtils.readInt(m_input)-1;
			if (m_inputMode <= 2 && m_inputMode >= 0)
				break;
			System.out.println("Invalid Input");
		}
		
		System.out.print("\n");
		
		switch (m_inputMode) {
		
		case 0: //meters and kilograms
			
			//gets height in meters
			System.out.print("What is your height (meters)? ");
			m_height = ScannerUtils.readDouble(m_input);
			
			//gets weight in Kg
			System.out.print("What is your weight (kilograms)? ");
			m_weight = ScannerUtils.readDouble(m_input);
			
			System.out.print("\n");
			
			//prints height
			System.out.println("Your height in meters: " + m_fivePlaces.format(m_height) + "");
			//prints weight
			System.out.println("Your weight in kilograms: " + m_fivePlaces.format(m_weight) + "");
			
			break;
			
		case 1: //inches and pounds
			
			//gets height in meters
			System.out.print("What is your height (inches)? ");
			m_height = (ScannerUtils.readDouble(m_input) * 2.54) / 100; //converts to metres
			
			//gets weight in Kg
			System.out.print("What is your weight (pounds)? ");
			m_weight = ScannerUtils.readDouble(m_input) / 2.205; //covnerts to pounds
			
			System.out.print("\n");
			
			//prints height
			System.out.println("Your height in inches: " + m_fivePlaces.format((m_height * 100) / 2.54) + "");
			//prints weight
			System.out.println("Your weight in pounds: " + m_fivePlaces.format(m_weight * 2.205) + "");
			
			break;
			
		case 2: //feet and pounds
			
			//gets height in meters
			System.out.print("What is your height (feet only)? ");
			m_feet = ScannerUtils.readDouble(m_input);
			m_height = (m_feet * 12 * 2.54) / 100; //converts to metres
			
			System.out.print("What is your height (inches only)? ");
			while (true) {
				m_inches = ScannerUtils.readInt(m_input);
				if (m_inches <= 12 && m_inches >= -12)
					break;
				System.out.println("Invalid Input");
			}
			m_height += (m_inches * 2.54) / 100; //converts to metres
			
			//gets weight in Kg
			System.out.print("What is your weight (pounds)? ");
			m_weight = ScannerUtils.readDouble(m_input) / 2.205;
			
			System.out.print("\n");
			
			//prints height
			System.out.println("Your height in feet only: " + m_fivePlaces.format(m_feet) + "");
			System.out.println("Your height in inches only: " + m_fivePlaces.format(m_inches) + "");
			//prints weight
			System.out.println("Your weight in pounds: " + m_fivePlaces.format(m_weight * 2.205) + "");
			
			break;
			
		}
		
		//calculates BMI
		m_bMI = m_weight/(Math.pow(m_height, 2));
		
		//prints BMI
		System.out.println("Your BMI is: " + m_fivePlaces.format(m_bMI) + "");
	}
	
}

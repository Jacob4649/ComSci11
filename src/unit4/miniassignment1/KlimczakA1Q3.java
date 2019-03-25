package unit4.miniassignment1;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

import utilities.ScannerUtils;

/*	Jacob Klimczak
 * 	March, 20, 2019
 * 	ICS3U0
 * 	Unit 4, Mini Assignment 1, Microwave Oven Question
 */

/**
 * Takes a microwave item, the time it takes to heat, and the number of items, and outputs the total cooking time 
 * if all items are put in the microwave at the same time
 * @author Jacob
 *
 */
public class KlimczakA1Q3 {

	static Scanner m_input = new Scanner(System.in);
	
	static DecimalFormat m_threePlaces = new DecimalFormat("0.###");

	static double m_seconds = 0;
	static int m_items = 0;
	
	public static void main(String[] args) {
		
		m_threePlaces.setRoundingMode(RoundingMode.HALF_UP); //configures decimal format
		
		System.out.println("Microwave Oven Cooking Time Calculator");
		
		System.out.print("\n");
		
		//get single item time
		System.out.print("How long does it take to microwave on item? (seconds): ");
		while (true) {
			m_seconds = ScannerUtils.readDouble(m_input);
			
			if (m_seconds >= 0)
				break;
			
			System.out.println("Invalid Input");
		}
		
		//get number of items
		System.out.print("How many items are going in the microwave? (1-4): ");
		while (true) {
			m_items = ScannerUtils.readInt(m_input);
			
			if (m_items > 0 && m_items < 5)
				break;
			
			System.out.println("Heating " + m_items + " items simultaneously is not recommended");
		}
		
		System.out.print("\n");
		
		switch (m_items) {
		
		case 1:
			System.out.println("Cooking time: " + m_threePlaces.format(m_seconds) + " seconds"); //1 item
			break;
			
		case 2:
			System.out.println("Cooking time: " + m_threePlaces.format(1.5 * m_seconds) + " seconds"); //2 items
			break;
			
		case 3:
			System.out.println("Cooking time: " + m_threePlaces.format(1.75 * m_seconds) + " seconds"); // 3 items
			break;
			
		case 4:
			System.out.println("Cooking time: " + m_threePlaces.format(2 * m_seconds) + " seconds"); //4 items
			break;
		}
	}
	
}

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
 * Creats a character for Harry Potter Quest
 * @author Jacob
 *
 */
public class KlimczakA1Q4 {

	static Scanner m_input = new Scanner(System.in);
	
	static DecimalFormat m_threePlaces = new DecimalFormat("0.###");

	static int m_str, m_hp, m_luk, m_wis = 0;
	static String m_name = "";
	
	public static void main(String[] args) {
		
		m_threePlaces.setRoundingMode(RoundingMode.HALF_UP); //configures decimal format
		
		System.out.println("Welcome to the Harry Potter's Quest");
		
		//gets character name
		System.out.println("Enter the name of your character:");
		m_name = ScannerUtils.readWord(m_input);
		
		//gets strength
		System.out.print("Enter strength (1-8): ");
		while (true) {
			m_str = ScannerUtils.readInt(m_input);
			
			if (m_str > 0 && m_str < 9)
				break;
			
			System.out.println("Invalid Input");
		}
		
		//gets health
		System.out.print("Enter health (1-8): ");
		while (true) {
			m_hp = ScannerUtils.readInt(m_input);
			
			if (m_hp > 0 && m_hp < 9)
				break;
			
			System.out.println("Invalid Input");
		}
		
		//gets luck
		System.out.print("Enter luck (1-8): ");
		while (true) {
			m_luk = ScannerUtils.readInt(m_input);
			
			if (m_luk > 0 && m_luk < 9)
				break;
			
			System.out.println("Invalid Input");
		}
		
		//gets wisdom
		System.out.print("Enter wisdom (1-8): ");
		while (true) {
			m_wis = ScannerUtils.readInt(m_input);
			
			if (m_wis > 0 && m_wis < 9)
				break;
			
			System.out.println("Invalid Input");
		}
		
		System.out.print("\n");
		
		// if total exceeds 19, then 4 points are applied to each characteristic
		if (m_str + m_hp + m_luk + m_wis > 19) {
			m_str = 4;
			m_hp = 4;
			m_luk = 4;
			m_wis = 4;
			System.out.println("You gave your character too many points! Default values have been assigned:");
		}
		
		//prints character
		System.out.println(m_name + ", strenth: " + m_str + ", health: " + m_hp + ", luck: " + m_luk + ", wisdom: " + m_wis);
	}
}

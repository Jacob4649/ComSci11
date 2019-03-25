package unit4.miniassignment1;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

import utilities.ScannerUtils;

/*	Jacob Klimczak
 * 	March, 20, 2019
 * 	ICS3U0
 * 	Unit 4, Mini Assignment 1, Steam Question
 */

/**
 * Takes steam and air temperature and outputs engine efficiency
 * @author Jacob
 *
 */
public class KlimczakA1Q2 {

	static Scanner m_input = new Scanner(System.in);
	
	static DecimalFormat m_threePlaces = new DecimalFormat("0.000");

	static boolean m_celcius = false;
	static double m_airTemp, m_steamTemp, m_efficiency = 0;
	
	public static void main(String[] args) {
		
		m_threePlaces.setRoundingMode(RoundingMode.HALF_UP); //configures decimal format
		
		System.out.println("Steam Engine Efficiency Calculator");
		
		//gets input type
		System.out.println("How would you like to input your temperatures?");
		System.out.println("\t1 == Kelvin");
		System.out.println("\t2 == Celcius");
		
		while (true) {
			double input = ScannerUtils.readDouble(m_input);
			
			if (input == 1 || input == 2) {
				m_celcius = input == 2;
				break;
			}
			
			System.out.println("Invalid Input");
		}
		
		System.out.print("\n");

		/*I left negative kelvin inputs as an option because it turns out it is technically possible, 
		 * and an efficiency of over 100% is technically possible too.
		 * https://www.mpg.de/research/negative-absolute-temperature
		 */
		
		//gets air temperature
		System.out.print("Input air temperature (" + (m_celcius ? "celcius" : "kelvin") + "):");
		m_airTemp = ScannerUtils.readDouble(m_input);		
		
		//gets steam temperature
		System.out.print("Input steam temperature (" + (m_celcius ? "celcius" : "kelvin") + "):");
		m_steamTemp = ScannerUtils.readDouble(m_input);	
		
		System.out.print("\n");
		
		//converts to kelvin to calculate efficiency
		if (m_celcius) {
			m_airTemp += 273.15;
			m_steamTemp += 273.15;
		}
		
		//calculates efficiency
		m_efficiency = (m_steamTemp < 373) ? 0 : 1 - (m_airTemp / m_steamTemp);
		
		System.out.println("The steam engine has an efficiency of: " + m_threePlaces.format(m_efficiency*100) + "%");
	}
	
}

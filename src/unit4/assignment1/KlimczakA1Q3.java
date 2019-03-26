package unit4.assignment1;

import java.util.Scanner;
import utilities.ScannerUtils;

/*	Jacob Klimczak
 * 	March, 25, 2019
 * 	ICS3U0
 * 	Unit 4, Assignment 1, Car Question 3
 */

/**
 * Takes four tire pressures, outputs whether or not there is a problem
 * @author jacob
 *
 */
public class KlimczakA1Q3 {

	static Scanner m_input = new Scanner(System.in);
	
	static double m_frontLeft, m_frontRight, m_backLeft, m_backRight;
	static boolean m_badInflation = false;
	
	public static void main(String[] args) {
		
		System.out.println("Tire Pressure Checker");
		
		//gets front right
		m_frontRight = getPressure("front right");
		
		//gets front left
		m_frontLeft = getPressure("front left");
		
		//gets back right
		m_backRight = getPressure("back right");
		
		//gets back left
		m_backLeft = getPressure("back left");
		
		//outputs whether pressure is ok
		System.out.println("Inflation is " + (m_badInflation ? "BAD" : ((Math.abs(m_backLeft - m_backRight) <= 3.5 && Math.abs(m_frontLeft - m_frontRight) <= 3.5 && Math.abs(((m_frontLeft + m_frontRight)/2 < (m_backLeft + m_backRight)/2 ? Math.min(m_frontLeft, m_frontRight) : Math.max(m_frontLeft, m_frontRight)) - ((m_backLeft + m_backRight)/2 < (m_frontLeft + m_frontRight)/2 ? Math.min(m_backLeft, m_backRight) : Math.max(m_backLeft, m_backRight))) <= 10) ? "OK" : "not OK")));
		
	}
	
	static double getPressure(String label) {
		System.out.print("Input " + label + " pressure (in psi): ");
		double input = ScannerUtils.readDouble(m_input);
		if (!(input >= 32 && input <= 48)) {
			m_badInflation = true;
			System.out.println("Warning: pressure is out of range");	
		}
		return input;
	}

}

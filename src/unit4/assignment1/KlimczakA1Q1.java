package unit4.assignment1;

import java.util.Scanner;
import utilities.ScannerUtils;

/*	Jacob Klimczak
 * 	March, 25, 2019
 * 	ICS3U0
 * 	Unit 4, Assignment 1, Car Question 1
 */

/**
 * Takes four tire pressures, outputs whether or not there is a problem
 * @author jacob
 *
 */
public class KlimczakA1Q1 {

	static Scanner m_input = new Scanner(System.in);
	
	static double m_frontLeft, m_frontRight, m_backLeft, m_backRight;
	
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
		System.out.println("Inflation is " + ((m_backLeft == m_backRight && m_frontLeft == m_frontRight) ? "OK" : "not OK"));
		
	}
	
	static double getPressure(String label) {
		System.out.print("Input " + label + " pressure (in psi): ");
		return ScannerUtils.readDouble(m_input);
	}

}

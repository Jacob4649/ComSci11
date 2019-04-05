package unit4.miniassignment2;

import java.util.Scanner;
import utilities.ScannerUtils;

/*	Jacob Klimczak
 * 	April, 4, 2019
 * 	ICS3U0
 * 	Unit 4, Mini Assignment 2, Question 3 - Compass
 */

/**
 * Takes an angle, outputs a direction on the compass rose
 * @author Jacob
 *
 */
public class KlimczakA2Q3 {

	static Scanner m_input = new Scanner(System.in);
	
	static int m_angle = 0;
	static char m_heading = '?';
	
	/**
	 * Takes an angle outputs a direction 
	 */
	public static void main(String[] args) {
		//title
		System.out.println("Angle to Direction");
		System.out.println();
		
		//input prompt
		System.out.println("Enter an angle (degrees):");
		System.out.print(">>> ");
		
		//input
		m_angle = ScannerUtils.readInt(m_input);
		
		//processces angle
		m_angle %= 360;
		if (m_angle < 0)
			m_angle = 360 + m_angle;
		
		//determines direction
		if (Math.abs(0 - m_angle) < 45 || Math.abs(360 - m_angle) < 45 ) { //facing north
			m_heading = 'N';
		} else if (Math.abs(90 - m_angle) <= 45) { //facing east
			m_heading = 'E';
		} else if (Math.abs(180 - m_angle) < 45) { //facing south
			m_heading = 'S';
		} else if (Math.abs(270 - m_angle) <= 45) { //facing west
			m_heading = 'W';
		} else {
			m_heading = '?';
		}
		
		System.out.println();
		System.out.println("The angle you have inputted is equivalent to the direction " + m_heading);
	}
	
}

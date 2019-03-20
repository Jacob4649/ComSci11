package unit3.excercises1;

import java.util.Scanner;
import unit3.excercises1.ScannerUtils;

public class KlimczakE1Q4 {

	static Scanner m_input;
	static double m_time = 10;
	
	public static void main(String[] args) {
		m_input = new Scanner(System.in);
		System.out.println("Enter a time less than 4.5 seconds");
		while (true) {
			m_time = ScannerUtils.readDouble(m_input);
			if (m_time <= 4.5 && m_time >= 0)
				break;
			System.out.println("Invalid Input");
		}
		System.out.println("Height of object after " + m_time + " seconds: " + (100.0 - (4.9*Math.pow(m_time, 2))) + " meters.");
	}
	
}

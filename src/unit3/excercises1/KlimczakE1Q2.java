package unit3.excercises1;

import java.util.Scanner;
import unit3.excercises1.ScannerUtils;

public class KlimczakE1Q2 {

	static int m_rad;
	static Scanner m_input;
	
	public static void main(String[] args) {
		m_input = new Scanner(System.in);
		System.out.println("Please input the radius:");
		m_rad = ScannerUtils.readInt(m_input);
		System.out.println("\tThe radius is: " + m_rad
				+ "\n\tThe area is: " + Math.PI*Math.pow(m_rad, 2));
	}
	
}

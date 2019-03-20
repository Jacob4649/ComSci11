package unit3.excercises1;

import java.util.Scanner;
import excercises1.ScannerUtils;

public class KlimczakE1Q3 {
	
	static Scanner m_input;
	static int m_cents;
	
	public static void main(String[] args) {
		m_input = new Scanner(System.in);
		System.out.println("Please input the number of cents:");
		m_cents = ScannerUtils.readInt(m_input);
		System.out.println("That is " + m_cents/100 + " dollars and " + m_cents%100 + " cents.");
	}

}

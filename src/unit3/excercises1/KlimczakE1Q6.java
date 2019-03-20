package unit3.excercises1;

import java.util.Scanner;
import excercises1.ScannerUtils;

public class KlimczakE1Q6 {

	static int m_voltage, m_current, m_resistance;
	static Scanner m_input;
	
	public static void main(String[] args) {
		m_input = new Scanner(System.in);
		
		System.out.println("Enter resistance (ohms):");
		m_resistance = ScannerUtils.readInt(m_input);
		
		System.out.println("Enter voltage (volts):");
		m_voltage = ScannerUtils.readInt(m_input);
		
		System.out.println("Current (amps): " + ((double) m_voltage)*m_resistance);
	}
	
}

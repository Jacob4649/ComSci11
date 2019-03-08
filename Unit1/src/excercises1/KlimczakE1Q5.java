package excercises1;

import java.util.Scanner;
import excercises1.ScannerUtils;

public class KlimczakE1Q5 {
	
	static int m_change, m_dollars, m_quarters, m_dimes, m_nickels, m_cents;
	static Scanner m_input;

	public static void main(String [] args) {
		m_input = new Scanner(System.in);
		System.out.println("Input the amount of change due (in cents):");
		m_change = ScannerUtils.readInt(m_input);
		
		m_dollars = m_change/100;
		m_quarters = (m_change-(m_dollars*100))/25;
		m_dimes = (m_change-((m_dollars*100) + (m_quarters*25)))/10;
		m_nickels = (m_change-((m_dollars*100) + (m_quarters*25) + (m_dimes*10)))/5;
		m_cents = (m_change-((m_dollars*100) + (m_quarters*25) + (m_dimes*10) + (m_nickels*5)));
		System.out.println("Your change is:"
				+ "\n\tDollars: " + m_dollars
				+ "\n\tQuarters: " + m_quarters
				+ "\n\tDimes: " + m_dimes
				+ "\n\tNickels: " + m_nickels
				+ "\n\tCents: " + m_cents);
	}
	
}

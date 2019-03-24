package unit4.miniassignment1;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

import utilities.ScannerUtils;

/*	Jacob Klimczak
 * 	March, 20, 2019
 * 	ICS3U0
 * 	Unit 4, Mini Assignment 1, Deli Question
 */

/**
 * Takes an order, and outputs an invoice
 * @author jacob
 */
public class KlimczakA1Q1 {

	static Scanner m_input = new Scanner(System.in);
	
	static DecimalFormat m_twoPlaces = new DecimalFormat("0.00");

	static String m_item = "";
	static double m_price, m_shipping, m_distance, m_taxes = 0;
	static boolean m_delivery = false;
	
	public static void main(String[] args) {
		
		m_twoPlaces.setRoundingMode(RoundingMode.HALF_UP); //configures decimal format

		System.out.println("Carnegie Delicatessan Restaurant");

		//gets item name
		System.out.print("Enter the item: ");
		m_item = ScannerUtils.read(m_input);
		
		//gets price
		System.out.print("Enter the price: ");
		m_price = ScannerUtils.readDouble(m_input);
		
		//get delivery status
		System.out.print("Delivery? (0==no, 1==yes): ");
		while (true) {
			int input = ScannerUtils.readInt(m_input);
			if (input == 1 || input == 0) {
				m_delivery = input == 1;
				break;
			}
			System.out.println("Invalid Input");
		}
		
		//if delivery, get distance
		if (m_delivery) {
			System.out.print("How far (km): ");
			m_distance = ScannerUtils.readDouble(m_input);
			
			if (m_distance > 11) {
				m_delivery = false;
				m_distance = 0;
				System.out.println("We do not deliver to locations further than 11km");
			}
		}
		
		System.out.print("\n");
		
		//calculate costs
		if (m_delivery)
			m_shipping = (m_distance > 7 ? 6.0 : 5.0);	//calculate shipping
		
		m_taxes = (m_price + m_shipping) * 0.13; //calculate taxes
		
		//output invoice
		System.out.println("Invoice:\n\t" + m_item + "\t$" + m_twoPlaces.format(m_price) + "\n" + (m_delivery ? ("\tshipping\t$" + m_twoPlaces.format(m_shipping) + "\n" ) : "") + "\ttaxes\t\t$" + m_twoPlaces.format(m_taxes) + "\n\ttotal\t\t$" + m_twoPlaces.format(m_price + m_shipping + m_taxes));
		System.out.print("\n");
		System.out.println("Your order will be delivered in 30 minutes. Thank you for shopping at the Carnegie Deli!");
	}

}
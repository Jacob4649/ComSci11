package unit4.miniassignment1;

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

	static String m_item;

	public static void main(String[] args) {

		System.out.println("Carnegie Delicatessan Restaurant");

		//gets item name
		System.out.print("Enter the item: ");
		m_item = ScannerUtils.read(m_input);
	}

}
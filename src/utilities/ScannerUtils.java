package utilities;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Collection of convenient scanner methods that read values then clear the scanner buffer.
 * They also handle inputmismatch exceptions.
 * @author Jacob
 *
 */
public class ScannerUtils {
	/**
	 * Reads input from a scanner, then clears buffer
	 * Prints "Invalid Input" on InputMismatchException
	 * @param input the scanner to read from
	 * @return the value read
	 */
	public static int readInt(Scanner input) {
		int i = 0;
		try {
			i = input.nextInt();
			input.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("Invalid Input");
			input.nextLine();
			i = readInt(input);
		}
		return i;
	}
	
	/**
	 * Reads input from a scanner, then clears buffer
	 * Prints "Invalid Input" on InputMismatchException
	 * @param input the scanner to read from
	 * @return the value read
	 */
	public static double readDouble(Scanner input) {
		double d = 0;
		try {
			d = input.nextDouble();
			input.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("Invalid Input");
			input.nextLine();
			d = readDouble(input);
		}
		return d;
	}
	
	/**
	 * Reads input from a scanner, then clears buffer
	 * Prints "Invalid Input" on InputMismatchException
	 * @param input the scanner to read from
	 * @return the value read
	 */
	public static String readWord(Scanner input) {
		String s = "";
		try {
			s = input.next();
			input.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("Invalid Input");
			input.nextLine();
			s = readWord(input);
		}
		return s;
	}

	/**
	 * Reads input from a scanner
	 * Prints "Invalid Input" on InputMismatchException
	 * @param input the scanner to read from
	 * @return the value read
	 */
	public static String read(Scanner input) {
		String s = "";
		try {
			s = input.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("Invalid Input");
			input.nextLine();
			s = read(input);
		}
		return s;
	}
}

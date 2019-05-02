package unit5.assignment1;

/*	Jacob Klimczak
 * 	April, 10, 2019
 * 	ICS3U0
 * 	Unit 5, Assignment 1, Looping Question
 */

/**
 * Iterates through a bunch of numbers using while loops
 * @author Jacob
 *
 */
public class KlimczakA1Q1 {

	public static void main(String[] args) {
		
		//title
		System.out.println("Unit 5, Assignment 1, Question 1 - Looping");
		
		//looping
		int part = 0;
		
		while (part < 5) { //5 parts
		
			part++;
			
			System.out.println();
			System.out.println("Part: " + part);
			System.out.println();
			
			int i = 1;
			while (i <= 10) { //part one
				System.out.print(i + (part == 5 && i != 10 ? ", " : " "));
				i++;
			}

			System.out.println();
			
			if (part == 1 || part == 5) {
				continue;
			}

			
			while (i > 1) { //part two
				i--;
				System.out.print(i + " ");
			}
			
			System.out.println();
			
			if (part == 2) {
				continue;
			}
			
			while (i <= 25) { //part 3
				System.out.print(i + " ");
				i += 3;
			}
			
			i = 30;
			
			System.out.println();
			
			if (part == 3) {
				continue;
			}
			
			
			while (i >= 11) { //part 4
				System.out.print(i + " ");
				i -= 4;
			}
			
			System.out.println();
			
		}
		
	}
	
}

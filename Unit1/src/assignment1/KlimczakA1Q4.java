package assignment1;

import java.util.Random;

public class KlimczakA1Q4 {
	
	/*
	 * Jacob Klimczak
	 * Assignment 1, Question 4
	 * February 21, 2019
	 * ICS3U0
	 */

	static Random rand = new Random();
	
	public static void main(String[] args) {
		printCard();
	}
	
	public static void printCard() {
		String[][] card = {
				colGen(1, 15, false),
				colGen(16, 30, false),
				colGen(31, 45, true),
				colGen(46, 60, false),
				colGen(61, 75, false),
		};
		
		System.out.println("B\tI\tN\tG\tO");
		for (int i = 0; i < card.length; i++) {
			for (int j = 0; j < card[0].length; j++) {
				System.out.print(card[j][i] + "\t");
			}
			System.out.print("\n");
		}
	}
	
	
	public static String[] colGen(int min, int max, boolean isG) {
		int[] ret = new int[max-min+1];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = min+i;
		}
		
		for (int i = ret.length-1; i > 0; i--) {
			int ind = rand.nextInt(i+1);
			int temp = ret[i];
			ret[i] = ret[ind];
			ret[ind] = temp;
		}
		
		if (isG)
			return new String[] {String.valueOf(ret[0]), String.valueOf(ret[1]), "FREE", String.valueOf(ret[3]), String.valueOf(ret[4])};
			
		return new String[] {String.valueOf(ret[0]), String.valueOf(ret[1]), String.valueOf(ret[2]), String.valueOf(ret[3]), String.valueOf(ret[4])};
			
	}
}

package assignment2;

//	Jacob Klimczak
//	Sports Assignment
//	Assignment 2, Question 1
//	ICS3U0
//	February, 28, 2019
//	All data from espn.com and basketball-reference.com and sportsnet and nhl.com

public class KlimczakA2Q1 {

	static String[] lines;
	
	public static void main(String[] args) {

		lines = new String[] {"TORONTO RAPTORS",
				"Toronto Raptors won to the Boston Celtics by a score of " + 95 + " - " + 118 + " in NBA action.",
				"In the last game, Danny Green and Marc Gasol combined for a total of " + (3  +  5) + " rebounds and " + (6 + 5) + " points.",
				"The Toronto Raptors have a total of " + 94 + " Field Goals Attempted (FGA) and " + 46 + " Field Goals Made for a Field Goal Percentage of " + Math.round((46.0/94.0)*100000.0)/1000.0 + "%.",
				"Kawhi Leonard is currently averaging " + Math.round(78.0/45.0*100)/10.0 + " 3Pointers / Game and " + Math.round(((847.0 + 219.0 + 628.0 + 344)/45.0)*10.0)/10.0 + " Total Shots / Game.", 
				"Toronto Raptors total attendance at Scotiabank Arena this season is " + 634246 + " over " + 32 + " matches played so far for an average of " + (634246/32) + ".",
				"",
				"TORONTO MAPLE LEAFS",
				"In the last game they played, The Toronto Maple Leafs lost to the New York Islanders by a score of " + 1 + " - " + 6 + " in 2018-2019 season action.",
				"Garret Sparks stopped a total of " + 31 + " shots and allowed " + 6 + " goals for a game save percentage of " + Math.round((31.0/37.0)*100000.0)/1000.0 + "%.",
				"Sparks currently has a " + Math.round((41.0/13.0)*100.0)/100.0 + " GAA for the entire season.",
				"Auston Matthews has a total of " + 59 + " points so far in the 2018-2019 seasonand is averaging " + Math.round((59.0/50.0)*100.0)/100.0 + " points per game.",
				"John Tavares has a salary of " + (77/7) + " million dollars per season"
				};
		

		for (String s : lines) {
			System.out.println(s);
		}
		
	}

}

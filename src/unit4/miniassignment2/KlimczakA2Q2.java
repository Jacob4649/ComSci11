package unit4.miniassignment2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import utilities.ScannerUtils;

/*	Jacob Klimczak
 * 	April, 4, 2019
 * 	ICS3U0
 * 	Unit 4, Mini Assignment 2, Question 2 - Quiz
 */

/**
 * A quiz on game of thrones
 * input is processed by what is roughly a fuzzy search system
 * @author Jacob
 *
 */
public class KlimczakA2Q2 {

	static Scanner m_input = new Scanner(System.in);
	
	static DecimalFormat m_noPlaces = new DecimalFormat("0");
	
	static Question[] m_questions = new Question[] {
		new Question("Who airs Game of Thrones?", "HBO", "City", "ABC", "Global", "AMC", "Disney"),
		new Question("In which year was the first episode of Game of Thrones released?", "2011", "2012", "2015", "2009", "2013"),
		new Question("Which of these actors plays Jon Snow in the show?", "Kit Harrington", "Nikolai Coster-Waldeau", "Peter Dinklage", "Steve Buscemi", "Adam Sandler"),
		new Question("Which of these is not a prominent family in Game of Thrones?", "The Tryells", "The Tarlys", "The Lannisters", "The Starks", "The Baratheons", "The Martells"),
		new Question("Who killed Tywin Lannister?", "Tyrion Lannister", "Jamie Lannister", "Daenerys Targaryen", "Ramsay Snow", "Robb Stark"),
		new Question("Who was to be married at the Red Wedding?", "Edmure Tully", "Robb Stark", "Greatjon Umber", "Walder Frey"),
		new Question("What did Sansa Stark name her direwolf?", "Lady", "Summer", "Grey Wind", "Nymeria"),
		new Question("Which of Jon Snow's relatives is Jon currently sleeping with (as of the beginning of season 9)?", "His Aunt", "His Sister", "His Mother", "His Brother"),
		new Question("Who had their eyes crushed by Gregor Clegane?", "Oberyn Martell", "Jamie Lannister", "Sam Tarly", "Gendry Stone"),
		new Question("In which of the free cities did Arya Stark join the House of Black and White?", "Braavos", "Lorath", "Lys", "Qohor", "Pentos"),
		new Question("One of the greatest fight scenes in the show involves Sandor Clegane, and which piece of food?", "Roast Chicken", "Vegan Burgers", "Pheasant Pie", "Cow Tongue")
	};
	
	static int m_correct = 0;
	
	/**
	 * Game of thrones quiz
	 */
	public static void main(String[] args) {
		
		//title
		System.out.println("Game of Thrones Quiz");
		System.out.println("_________________________");
		
		//instructions
		System.out.println("INSTRUCTIONS:");
		System.out.println("Enter the answer you think is correct on the prompt marked '>>>'.");
		System.out.println();
		System.out.println("If any of the answers are multi word answers, you may enter only one word of that answer.");
		System.out.println("You do not need to enter entire words, only enough of the wor to make it distinguishable from the other options.");
		System.out.println("\tE.X. tyrion -> Tyrion Lannister & tyri -> Tyrion Lannister & lann -> Tyrion Lannister");
		System.out.println();
		System.out.println("Case is irrelevant");
		System.out.println("\tE.X. jamie -> Jamie");
		System.out.println();
		
		//asks if the user is ready for a quiz
		System.out.println("Are you ready for a quiz? (y/n)");
		System.out.print(">>> ");
		if (ScannerUtils.yesQuery(m_input))
			System.out.println("Great! Here it comes.");
		else
			System.out.println("Too bad, you're gonna get one anyways!");
		
		//countdown
		try {
			System.out.println(3);
			Thread.sleep(1000);
			System.out.println(2);
			Thread.sleep(1000);
			System.out.println(1);
			Thread.sleep(1000);
			System.out.println("START!");
		} catch (Exception e) {
			System.out.println("3\n2\n1\nSTART!");
		}
		
		System.out.println();
		
		//Questions
		
		if (askQuestion("Correct, Game of Thrones is aired by HBO", "Nope, Game of Thrones is actually aired by HBO", m_questions[0]))
			m_correct += 1;
		
		if (askQuestion("Correct, the first episode of Game of Thrones was released on April 17, 2011", "Game of Thrones was actually first aired in 2011", m_questions[1]))
			m_correct += 1;		
		
		if (askQuestion("Correct, it's Kit Harrington,\nthank god it's not Adam Sandler", "Better luck next time,\nKit Harrington plays Jon Snow", m_questions[2]))
			m_correct += 1;
		
		if (askQuestion("You got it, there are no Tryells in Game of Thrones", "Incorrect, Tryells was the correct answer,\nwhile there are Tyrells (note the spelling) in Game of Thrones,\nthere are no Tryells", m_questions[3]))
			m_correct += 1;
		
		if (askQuestion("Yup Tywin was killed by Tyrion,\nhis own son", "Tywin was actually killed by his son, Tyrion Lannister", m_questions[4]))
			m_correct += 1;
		
		if (askQuestion("It was indeed Edmure Tully who was being married at the Red Wedding", "Contrary to popular recollection,\nit was actually Edmure Tully who was being married at the Red Wedding", m_questions[5]))
			m_correct += 1;
		
		if (askQuestion("Correct, Sansa's direwolf was named Lady", "Sansa's direwolf was actually named Lady", m_questions[6]))
			m_correct += 1;
		
		if (askQuestion("That's right, Jon Snow slept with his aunt...", "Jon Snow actually slept with his aunt,\nHonestly, I'm not sure if that's better or worse", m_questions[7]))
			m_correct += 1;
		
		if (askQuestion("Oberyn Martell was killed by Gregor Clegane", "Incorrect, it was actually Oberyn Martell who had his eyes crushed by Gregor Clegane", m_questions[8]))
			m_correct += 1;
		
		if (askQuestion("Arya did join the House of Black and White in Braavos", "Arya actually joined the House of Black and White in Braavos", m_questions[9]))
			m_correct += 1;
		
		if (askQuestion("Correct, it was the chicken", "Nope, it was actually the chicken", m_questions[10]))
			m_correct += 1;
		
		//prints score
		System.out.println("Your final score was " + m_correct + "/" + m_questions.length + " or " + m_noPlaces.format(((double) m_correct/m_questions.length)*100) + "%");
		
	}
	
	/**
	 * Asks the user a question
	 * @param correctMessage the message to display if the user gets the question right
	 * @param incorrectMessage the message to display if the user gets the question wrong
	 * @param question the question to ask
	 * @return true if the user gets the question right, false if the user gets the question wrong
	 */
	public static boolean askQuestion(String correctMessage, String incorrectMessage, Question question) {
		System.out.println(question.getQuestion()); //prints the question
		
		for (String answer : question.getAnswers()) { //prints the answers
			System.out.println("\t--> " + answer);
		}
		
		int answerIndex = -1;
		
		while (true) { //gets user input that only matches one answer
		
			String input = "";
			boolean compatibleAnswer = false; //whether the input matches another answer
			
			System.out.print(">>> "); //input answer
			input = ScannerUtils.read(m_input);
		
			if (input.length() >= 3) { //only compare if length is greater or equal to 3
		
				answerIndex = -1;
				
				//check here against everything in the problematic index
				for (int i = 0; i < question.getProblematicIndex().length; i++) {
					if (question.getAnswers()[question.getProblematicIndex()[i]].matches("(?i)^" + input + "$")) { //checks if it matches exactly
						compatibleAnswer = true;
						answerIndex = question.getProblematicIndex()[i];
					}
				}
				
				if (answerIndex == -1) { //only runs if answer has not already been found
					for (int i = 0; i < question.getAnswers().length; i++) {	//checks all answers
						
						if (question.getAnswers()[i].matches("(?i)(.*|)" + input + "(.*|)")) { //checks if it matches 
							if (answerIndex == -1) { //only compatible answer
								compatibleAnswer = true;
								answerIndex = i; 
							} else { //if another answer that matches has already been detected
								compatibleAnswer = false;
								break;
							}
						}
						
					}
					
				}
				
			}
			
			if (compatibleAnswer) { //if the answer is good, stop checking for inputs
				break;
			} else {
				if (answerIndex != -1) {
					System.out.println("Answer is too ambiguous, please be more specific");
				} else {
					System.out.println("Input does not match any answers, please try again"); //input doesn't match any avaliable answers
				}
				
			}
			
		}
		
		System.out.println();
		
		System.out.println("Your answer was: " + question.getAnswers()[answerIndex]);
		
		System.out.println();
		
		if (question.getCorrectAnswer().equals(question.getAnswers()[answerIndex])) {
			System.out.println(correctMessage);	//you got the question right
			System.out.println();
			return true;
		} else {
			System.out.println(incorrectMessage); //you got the question wrong
			System.out.println();
			return false;
		}
		
	}
	
	/**
	 * A class representing a question to be asked, as well as all of its answers
	 * @author jacob
	 *
	 */
	static class Question {
		
		private String m_question, m_correctAnswer = "";
		private ArrayList<String> m_answers;	
		private ArrayList<Integer> m_problematicAnswers = new ArrayList<Integer>(); //list of all answer indices, where the answer is matched by another answer
		
		/**
		 * Contructor for question
		 * @param question the question to ask
		 * @param correctAnswer the correct answer
		 * @param answers all other potential answers
		 */
		public Question(String question, String correctAnswer, String... answers) {
		
			m_question = question;
			m_correctAnswer = correctAnswer;
			m_answers = new ArrayList<String>(Arrays.asList(answers));
			m_answers.add(m_correctAnswer);
			Collections.shuffle(m_answers);
			
			for (int i = 0; i < m_answers.size(); i++) { //i is the answer currently being checked
				
				for (int j = 0; j < m_answers.size(); j++) { //j is the answer its being checked against
					
					if (j == i) //skips comparisons if comparing against self
						continue;
					
					if (m_answers.get(i).matches("(?i)(.*|)" + m_answers.get(j)+ "(.*|)") && !m_problematicAnswers.contains(j)) { //adds problematic answers to array
						m_problematicAnswers.add(j); //updates list of problematic questions
					}
					
				}
				
			}
			
		}
		
		/**
		 * Gets the question to ask
		 * @return the question to ask
		 */
		public String getQuestion() {;
			return m_question;
		}
		
		/**
		 * Gets the answers
		 * @return an array containing all potential answers
		 */
		public String[] getAnswers() {
			return m_answers.toArray(new String[0]);
		}
		
		/**
		 * Gets the correct answer
		 * @return the correct answer
		 */
		public String getCorrectAnswer() {
			return m_correctAnswer;
		}
		
		/**
		 * Returns array of problematic answers
		 * @return an array containing all of the potentially problematic indices
		 */
		public Integer[] getProblematicIndex() {
			return m_problematicAnswers.toArray(new Integer[0]);
		}
		
	}
	
}

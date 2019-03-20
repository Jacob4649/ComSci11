package unit3.excercises1;

import java.util.Scanner;
import excercises1.ScannerUtils;

public class KlimczakE1Q1 {

	static Scanner m_input = new Scanner(System.in);
	static String m_firstName, m_lastName;
	static int m_grade, m_id, m_bDayMonth, m_bDayYear, m_bDayDate;
	static double m_avg;
	
	public static void main(String[] args) {
		System.out.println("What is your first name?");
		m_firstName = ScannerUtils.readWord(m_input);
		
		System.out.println("What is your last name?");
		m_lastName = ScannerUtils.readWord(m_input);
		
		System.out.println("What grade are you in?");
		m_grade = ScannerUtils.readInt(m_input);
		
		System.out.println("What is your student ID?");
		m_id = ScannerUtils.readInt(m_input);
		
		System.out.println("What is your birthday (mm/dd/yyyy)?");
		System.out.println("\tMonth (mm)?");
		m_bDayMonth = ScannerUtils.readInt(m_input);
		
		System.out.println("\tDate (dd)?");
		m_bDayDate = ScannerUtils.readInt(m_input);
		
		System.out.println("\tYear (yyyy)?");
		m_bDayYear = ScannerUtils.readInt(m_input);
		
		System.out.println("What is your academic average from the previous semester (round to one decimal place)?");
		m_avg = ScannerUtils.readDouble(m_input);
		
		System.out.println("Student Information"
				+ "\n\tName (last, first): " + m_lastName + " , " + m_firstName
				+ "\n\tGrade: " + m_grade
				+ "\n\tID: " + m_id
				+ "\n\tDate Of Birth (mm/dd/yyyy): " + m_bDayMonth + "/" + m_bDayDate + "/" + m_bDayYear
				+ "\n\tAcademic Average: " + m_avg);
	}
	
}

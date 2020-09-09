package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) throws FileNotFoundException {
		
		ArrayList<Dice> diceList = new ArrayList<Dice>();
		diceList = populateList(5, diceList);
		Hand what = new Hand(diceList);
		ArrayList<Integer> scoreList = new ArrayList<Integer>();
		HighScore scores = new HighScore(scoreList);
		ArrayList<Integer> topScores = new ArrayList<Integer>();
		
		
		System.out.println("Please select a number to determine your yahtzee score.");
		Scanner keyboard = new Scanner(System.in);
		int userChoice = keyboard.nextInt();
		

		for(int i = 1; i<6; i++) {
			int x = userChoice;
			int y = what.playRound(x);
			System.out.println("Roll " + i + ": " + what.toString());
			if(y>0) {
				scores.addScore(y);
				System.out.println("Score: " + y);
			} else {
				System.out.println("Score: big fat 0");
			}
		}
		
		int total = total(scoreList);
		if(total>0) {
		topScores.add(total);
		}
		System.out.println("Your total score is: " + total);
		
		ArrayList<String> previous = readFromFile("scores.txt");
		
		previous = addPrevious(previous, topScores);
		sort(previous);
		writeToFile("scores.txt", previous);
		
	}
		
		public static ArrayList<String> readFromFile(String filename) throws FileNotFoundException{
			ArrayList<String> allScores = new ArrayList<String>();
			 
			Scanner input = new Scanner(new File("scores.txt"));
			while (input.hasNext()) {
			    String word = input.next();
			    allScores.add(word);
			}
			return allScores;
			
			}
		public static void writeToFile(String fileName, ArrayList<String> scores) throws FileNotFoundException{
			PrintStream output = new PrintStream(new File(fileName));
			 
			for (int i = 0; i < scores.size(); i++) {
			    output.println(scores.get(i));
			}
			output.close();
			}
		public static ArrayList<String> sort(ArrayList<String> previous) {
			
			
			for(int j = 0; j<previous.size()-1; j++) {
				int minIndex = j;
				for(int k = j+1; k<previous.size(); k++) {
					if(Integer.parseInt(previous.get(k)) > Integer.parseInt(previous.get(minIndex))) {
						minIndex = k;
					}
				}
				String temp = previous.get(j);
				previous.set(j, previous.get(minIndex));
				previous.set(minIndex, temp);
				
			}
			return previous;
		}
		public static int total(ArrayList<Integer> scoreList) {
			int total = 0;
			for(int i = 0; i<scoreList.size(); i++) {
				total+=scoreList.get(i);
			}
			return total;
		
			}
		public static ArrayList<Dice> populateList(int size, ArrayList<Dice> diceList) {
			for(int i = 0; i<size; i++) {
				Dice cool = new Dice();
				diceList.add(cool);
			}
			return diceList;
		}
		public static ArrayList<String> addPrevious(ArrayList<String> previous, ArrayList<Integer> topScores) {
			for(int i = 0; i<topScores.size(); i++) {
				int x = topScores.get(i);
				previous.add(Integer.toString(x));
			}
			return previous;
		}
		}
		
	



package game;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Dice> diceList;
	
	public Hand(ArrayList<Dice> diceList) {
		this.diceList = diceList;
	}
	
	public ArrayList<Dice> roll() {
		for(int i = 0; i<diceList.size(); i++) {
			int x = (int) (Math.random()*6) +1;
			diceList.get(i).setRoll(x);
		}
		return diceList;
	}
	
	public int playRound(int yahtzee) {
		ArrayList<Dice> check = roll();
		int score = 0;
		
		for(int i = 0; i<check.size(); i++) {
			if(check.get(i).getRoll() == yahtzee) {
				score+=yahtzee;
			}
		}
		if(score>=(yahtzee*2)) {
			return score;
		} else {
			return 0;
		}
		
	}
	

	public String toString() {
		String s = "";
		for(int i = 0; i<diceList.size(); i++) {
			s+=diceList.get(i).getRoll();
			s+=" ";
		}
		return s;
	}
}

package game;


import java.util.ArrayList;


public class HighScore {

	private ArrayList<Integer> scoreList;
	
	public HighScore(ArrayList<Integer> scoreList) {
		this.scoreList = scoreList;
	}
	public void addScore(int x) {
		scoreList.add(x);
	}
	public String getScore() {
		String s = "";
		for(int i = 0; i<scoreList.size(); i++) {
			s+=scoreList.get(i);
			s+= " ";
		}
		return s;
	}
	public int getScore(int index) {
		return scoreList.get(index);
	}



	
}

package game;

public class Dice {
	private int roll;
	
	public void roll() {
		roll = (int) (Math.random()*5)+1;
	}
	
	public int getRoll() {
		return roll;
	}
	
	public void setRoll(int x) {
		roll = x;
	}
	
}

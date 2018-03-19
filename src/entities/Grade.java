package entities;

public class Grade extends Entity{
	int val;
	
	public Grade(int x, int y, int val) {
		posX = x;
		posY = y;
		radius = 10;
		this.val = val;
	}
}
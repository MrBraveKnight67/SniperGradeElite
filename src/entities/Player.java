package entities;

public class Player extends Entity{
	public int gpa;
	
	public Player(int x, int y) {
		posX = x;
		posY = y;
		radius = 10;
		gpa = 0;
	}
}
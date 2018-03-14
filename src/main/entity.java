package main;

public abstract class entity {
	public double posX;
	public double posY;
	public double radius;

	public boolean collides(int tX, int tY) {
		double diffX = Math.abs(tX-posX);
		double diffY = Math.abs(tY-posY);
		if(Math.sqrt((diffX*diffX + diffY*diffY)) <= radius) {
			return true;
		}
		return false;
	}
	
}

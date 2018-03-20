package entities;

import java.util.Random;

public class Grade extends Entity {
	int val;
	int speed;
	boolean captured;
	Random rand;

	public Grade(int x, int y, int val, int speed) {
		posX = x;
		posY = y;
		radius = 10;
		this.val = val;
		this.speed = speed;
		captured = false;
		rand = new Random();
	}

	public void update() {
		posX += rand.nextInt(speed);
		posY += rand.nextInt(speed);
	}

	public boolean isCaptured() {
		return captured;
	}
}
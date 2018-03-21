package entities;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Entity {
	public double[] gpa;
	public int speed;

	public Player(int x, int y, int speed) {
		posX = x;
		posY = y;
		radius = 15;
		// gpa[gpa, total grades, number of grades]
		gpa = new double[3];
		gpa[0] = 0;
		gpa[1] = 0;
		gpa[2] = 0;
		this.speed = speed;
		needed = true;
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/player.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
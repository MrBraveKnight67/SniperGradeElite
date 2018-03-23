package entities;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Entity {
	public double[] gpa;
	public int speed;
	private int pNum;

	public Player(int x, int y, int speed, int playerNumber) {
		posX = x;
		posY = y;
		radius = 15;
		pNum = playerNumber;

		// gpa[gpa, sum of grades, number of grades]
		gpa = new double[3];
		gpa[0] = 0;
		gpa[1] = 0;
		gpa[2] = 0;
		this.speed = speed;
		needed = true;
		try {
			if (pNum == 1) {
				img = ImageIO.read(getClass().getResourceAsStream("/player.png"));
			}else if (pNum == 2) {
				img = ImageIO.read(getClass().getResourceAsStream("/player2.jpg"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
package entities;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

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
		radius = 10;
		try {
			if (val == 4) {
				img = ImageIO.read(getClass().getResourceAsStream("/gradeA.png"));
			}else if (val == 3) {
				img = ImageIO.read(getClass().getResourceAsStream("/gradeB.jpg"));
			}else if (val == 2) {
				img = ImageIO.read(getClass().getResourceAsStream("/gradeC.png"));
			}else if (val == 1) {
				img = ImageIO.read(getClass().getResourceAsStream("/gradeD.png"));
			}else if (val == 0) {
				img = ImageIO.read(getClass().getResourceAsStream("/gradeF.png"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		rand = new Random();
	}

	public void update(Player player) {
		if (player.collides(posX, posY, radius)) {
			player.gpa[1] += val;
			player.gpa[2]++;
			player.gpa[0] = player.gpa[1] / player.gpa[2];
			System.out.println("" + player.gpa[0]);
			captured = true;
		}
		int xDir = rand.nextInt(10);
		int yDir = rand.nextInt(10);
		if (xDir > 4) {
			move(rand.nextInt(speed), 0);
		} else {
			move(-rand.nextInt(speed), 0);
		}

		if (yDir > 4) {
			move(0, rand.nextInt(speed));
		} else {
			move(0, -rand.nextInt(speed));
		}
	}

	public boolean isCaptured() {
		return captured;
	}
}
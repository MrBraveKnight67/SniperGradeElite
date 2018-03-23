package entities;

import java.awt.image.BufferedImage;

public abstract class Entity {
	public double posX;
	public double posY;
	public int radius;
	protected BufferedImage img;
	public boolean needed;

	public boolean collides(double tX, double tY, int tRadius) {
		double diffX = Math.abs(tX - posX);
		double diffY = Math.abs(tY - posY);
		if (Math.sqrt((diffX * diffX + diffY * diffY)) <= radius + tRadius) {
			return true;
		}
		return false;
	}

	public void setPosition(int x, int y) {
		move((int) (-posX + x), (int) (-posY + y));
	}

	public void move(int dx, int dy) {
		if (posX + dx > 320 - radius) {
			posX = 320 - radius;
		} else if (posX + dx < radius) {
			posX = radius;
		} else {
			posX += dx;
		}

		if (posY + dy > 240 - radius) {
			posY = 240 - radius;
		} else if (posY + dy < radius) {
			posY = radius;
		} else {
			posY += dy;
		}
	}

	public void draw(java.awt.Graphics2D g) {
		g.drawImage(img, (int) (posX - radius), (int) (posY - radius), null);
	}

}

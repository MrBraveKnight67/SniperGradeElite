package entities;

import java.awt.image.BufferedImage;

public abstract class Entity {
	public double posX;
	public double posY;
	public double radius;
	private BufferedImage img;

	public boolean collides(int tX, int tY) {
		double diffX = Math.abs(tX - posX);
		double diffY = Math.abs(tY - posY);
		if (Math.sqrt((diffX * diffX + diffY * diffY)) <= radius) {
			return true;
		}
		return false;
	}

	public void setPosition(int x, int y) {
		posX = x;
		posY = y;
	}
	
	public void move(int dx, int dy) {
		posX += dx;
		posY += dy;
	}

	public void draw(java.awt.Graphics2D g) {
		g.drawImage(img, (int) posX, (int) posY, null);
	}

}

package gameState;

import entities.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Level1State extends GameState {

	private BufferedImage bg;
	private Player player;
	private ArrayList<Grade> grades;
	private int speed;

	public Level1State(GameStateManager gsm) {
		this.gsm = gsm;
		init();
	}

	public void init() {

		try {
			bg = ImageIO.read(getClass().getResourceAsStream("/englishBackground.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		player = new Player(10, 10);
		populateEnemies();

	}

	private void populateEnemies() {

		grades = new ArrayList<Grade>();
		speed = 5;

		Grade g;
		int[] values = new int[] { 4, 3, 2, 1, 0, 3, 2 };
		Point[] points = new Point[] { new Point(200, 100), new Point(200, 100), new Point(200, 100),
				new Point(200, 100), new Point(200, 100), new Point(200, 100), new Point(200, 100) };
		for (int i = 0; i < points.length; i++) {
			g = new Grade(points[i].x, points[i].y, values[i], speed);
			grades.add(g);
		}

	}

	public void update() {

		// capture grades

		// update all grades
		for (int i = 0; i < grades.size(); i++) {
			Grade g = grades.get(i);
			g.update(player);
			if (g.isCaptured()) {
				grades.remove(i);
				i--;
				// explosions.add(new Explosion(e.getx(), e.gety()));
			}
		}

		// update explosions
		/*
		 * for (int i = 0; i < explosions.size(); i++) { explosions.get(i).update(); if
		 * (explosions.get(i).shouldRemove()) { explosions.remove(i); i--; } }
		 */

	}

	public void draw(Graphics2D g) {

		// draw bg
		g.drawImage(bg, 0, 0, null);

		// draw player
		player.draw(g);

		// draw enemies
		for (int i = 0; i < grades.size(); i++) {
			grades.get(i).draw(g);
		}

		// draw explosions
		/*
		 * for (int i = 0; i < explosions.size(); i++) {
		 * explosions.get(i).setMapPosition((int) tileMap.getx(), (int) tileMap.gety());
		 * explosions.get(i).draw(g); }
		 */

		// draw hud
		// hud.draw(g);

	}

	public void keyPressed(int k) {
		if (k == KeyEvent.VK_LEFT) {
			player.move(-player.speed, 0);
		}
		if (k == KeyEvent.VK_RIGHT) {
			player.move(player.speed, 0);
		}
		if (k == KeyEvent.VK_UP) {
			player.move(0, -player.speed);
		}
		if (k == KeyEvent.VK_DOWN) {
			player.move(0, player.speed);
		}
		if (k == KeyEvent.VK_Q) {
			System.exit(0);
		}
		if (k == KeyEvent.VK_W) {
		}
		if (k == KeyEvent.VK_E) {
		}
		if (k == KeyEvent.VK_R) {
		}
		if (k == KeyEvent.VK_F) {
		}

	}

	public void keyReleased(int k) {
		if (k == KeyEvent.VK_LEFT) {
		}
		if (k == KeyEvent.VK_RIGHT) {
		}
		if (k == KeyEvent.VK_UP) {
		}
		if (k == KeyEvent.VK_DOWN) {
		}
		if (k == KeyEvent.VK_W) {
		}
		if (k == KeyEvent.VK_E) {
		}

	}

}

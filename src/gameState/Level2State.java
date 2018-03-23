package gameState;

import entities.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Level2State extends GameState {

	private BufferedImage bg;
	private Player player;
	private ArrayList<Grade> grades;
	private Door door;
	private int gSpeed = 5;
	private int pSpeed = 10;

	public Level2State(GameStateManager gsm) {
		this.gsm = gsm;
		init();
	}

	public void init() {

		try {
			bg = ImageIO.read(getClass().getResourceAsStream("/Backgrounds/englishBackground.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		player = new Player(15, 15, pSpeed);
		populateEnemies();

	}

	private void populateEnemies() {
		grades = new ArrayList<Grade>();
		Grade g;
		int[] values = new int[] { 4, 4, 4, 4, 4, 4, 3 };
		Point[] points = new Point[] { new Point(200, 100), new Point(200, 100), new Point(200, 100),
				new Point(200, 100), new Point(200, 100), new Point(200, 100), new Point(200, 100) };
		for (int i = 0; i < points.length; i++) {
			g = new Grade(points[i].x, points[i].y, values[i], gSpeed);
			grades.add(g);
		}

	}

	public void update() {

		if (grades.size() <= 3) {
			if (door == null) {
				door = new Door(310, 230);
			} else if (door.updateB(player)) {
				door = null;
				goToNext();
			}
		}

		// update all grades
		for (int i = 0; i < grades.size(); i++) {
			Grade g = grades.get(i);
			g.update(player);
			if (!g.needed) {
				grades.remove(i);
				i--;
				// explosions.add(new Explosion(g.getx(), g.gety()));
			}
		}

		// update explosions
		/*
		 * for (int i = 0; i < explosions.size(); i++) { explosions.get(i).update(); if
		 * (explosions.get(i).shouldRemove()) { explosions.remove(i); i--; } }
		 */

	}

	public void draw(Graphics2D g) {

		// draw bg & door
		g.drawImage(bg, 0, 0, null);
		if(door != null) {
			door.draw(g);
		}

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

	public void goToNext() {
		//gsm.setState(GameStateManager.LEVEL3STATE);
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
	}

	public void keyReleased(int k) {
	}

}

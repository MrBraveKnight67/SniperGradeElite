package gameState;

import main.GamePanel;
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

	public Level1State(GameStateManager gsm) {
		this.gsm = gsm;
		init();
	}

	public void init() {

		try {
			bg = ImageIO.read(getClass().getResourceAsStream("/foothillBackground.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		player = new Player(10, 10);
		populateEnemies();

	}

	private void populateEnemies() {

		grades = new ArrayList<Grade>();

		Grade g;
		int[] values = new int[] { 4 };
		Point[] points = new Point[] { new Point(200, 100)};
		for (int i = 0; i < points.length; i++) {
			g = new Grade(points[i].x, points[i].y, values[i]);
			grades.add(g);
		}

	}

	public void update() {

		// attack enemies

		// update all enemies
		for (int i = 0; i < grades.size(); i++) {
			Grade g = grades.get(i);
			g.update();
			if (g.isCaptured()) {
				g.remove(i);
				i--;
				explosions.add(new Explosion(e.getx(), e.gety()));
			}
		}

		// update explosions
		for (int i = 0; i < explosions.size(); i++) {
			explosions.get(i).update();
			if (explosions.get(i).shouldRemove()) {
				explosions.remove(i);
				i--;
			}
		}

	}

	public void draw(Graphics2D g) {

		// draw bg
		bg.draw(g);

		// draw tilemap
		tileMap.draw(g);

		// draw player
		player.draw(g);

		// draw enemies
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).draw(g);
		}

		// draw explosions
		for (int i = 0; i < explosions.size(); i++) {
			explosions.get(i).setMapPosition((int) tileMap.getx(), (int) tileMap.gety());
			explosions.get(i).draw(g);
		}

		// draw hud
		hud.draw(g);

	}

	public void keyPressed(int k) {
		if (k == KeyEvent.VK_LEFT)
			player.setLeft(true);
		if (k == KeyEvent.VK_RIGHT)
			player.setRight(true);
		if (k == KeyEvent.VK_UP)
			player.setUp(true);
		if (k == KeyEvent.VK_DOWN)
			player.setDown(true);
		if (k == KeyEvent.VK_W)
			player.setJumping(true);
		if (k == KeyEvent.VK_E)
			player.setGliding(true);
		if (k == KeyEvent.VK_R)
			player.setScratching();
		if (k == KeyEvent.VK_F)
			player.setFiring();
	}

	public void keyReleased(int k) {
		if (k == KeyEvent.VK_LEFT)
			player.setLeft(false);
		if (k == KeyEvent.VK_RIGHT)
			player.setRight(false);
		if (k == KeyEvent.VK_UP)
			player.setUp(false);
		if (k == KeyEvent.VK_DOWN)
			player.setDown(false);
		if (k == KeyEvent.VK_W)
			player.setJumping(false);
		if (k == KeyEvent.VK_E)
			player.setGliding(false);
	}

}

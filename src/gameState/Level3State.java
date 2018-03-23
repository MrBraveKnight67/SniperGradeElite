package gameState;

import entities.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Level3State extends GameState {

	private BufferedImage bg;
	private Player player;
	private Player player2;
	private HUD hud;
	private HUD hud2;
	private ArrayList<Grade> grades;
	private ArrayList<Explosion> explosions;
	private Door door;
	private int gSpeed = 5;
	private int pSpeed = 15;
	private int pSpeed2 = 20;

	public Level3State(GameStateManager gsm, Player player, Player player2) {
		this.gsm = gsm;
		this.player = player;
		this.player2 = player2;
		init();
	}

	public void init() {

		try {
			bg = ImageIO.read(getClass().getResourceAsStream("/Backgrounds/englishBackground.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		player.setPosition(0, 160);
		player.speed = pSpeed;
		player2.setPosition(0, 160);
		player2.speed = pSpeed2;
		hud = new HUD(player, 15, 15);
		hud2 = new HUD(player2, 15, 213);
		populateGrades();
		explosions = new ArrayList<Explosion>();
	}

	private void populateGrades() {
		grades = new ArrayList<Grade>(7);
		Grade g;
		int[] values = new int[] { 4, 3, 3, 2, 2, 1, 0 };
		Point[] points = new Point[] { new Point(200, 100), new Point(200, 100), new Point(200, 100),
				new Point(200, 100), new Point(200, 100), new Point(200, 100), new Point(200, 100) };
		for (int i = 0; i < points.length; i++) {
			g = new Grade(points[i].x, points[i].y, values[i], gSpeed);
			grades.add(g);
		}

	}

	public void update() {

		// check for door
		if (grades.size() <= 3 && player.gpa[0] != 0) {
			if (door == null) {
				door = new Door(310, 230);
			} else if (door.updateB(player)) {
				door = null;
				goToNext();
			}
		}

		// update all grades & explosions
		for (int i = 0; i < grades.size(); i++) {
			Grade g = grades.get(i);
			g.update(player);
			g.update(player2);
			if (!g.needed) {
				grades.remove(i);
				i--;
				explosions.add(new Explosion(g.getX(), g.getY()));
			}
		}
		
		for (int i = 0; i < explosions.size(); i++) {
			Explosion e = explosions.get(i);
			e.update();
			if (!e.needed) {
				explosions.remove(i);
				i--;
			}
		}

	}

	public void draw(Graphics2D g) {

		// draw bg & door
		g.drawImage(bg, 0, 0, null);
		if (door != null) {
			door.draw(g);
		}

		player.draw(g);
		player2.draw(g);
		hud.draw(g);
		hud2.draw(g);

		// draw enemies & explosions
		for (int i = 0; i < grades.size(); i++) {
			grades.get(i).draw(g);
		}
		for (int i = 0; i < explosions.size(); i++) {
			explosions.get(i).draw(g);
		}

	}

	public void goToNext() {
		gsm.setState(GameStateManager.RESULTSTATE, player, player2);
	}

	public void keyPressed(int k) {
		if (k == KeyEvent.VK_LEFT) {
			player.move(player.speed, 0);
		}
		if (k == KeyEvent.VK_RIGHT) {
			player.move(-player.speed, 0);
		}
		if (k == KeyEvent.VK_UP) {
			player.move(0, player.speed);
		}
		if (k == KeyEvent.VK_DOWN) {
			player.move(0, -player.speed);
		}
		if (k == KeyEvent.VK_Q) {
			System.exit(0);
		}
		if (k == KeyEvent.VK_A) {
			player.move(player.speed, 0);
		}
		if (k == KeyEvent.VK_D) {
			player.move(-player.speed, 0);
		}
		if (k == KeyEvent.VK_W) {
			player.move(0, player.speed);
		}
		if (k == KeyEvent.VK_S) {
			player.move(0, -player.speed);
		}
	}

	public void keyReleased(int k) {
	}

}

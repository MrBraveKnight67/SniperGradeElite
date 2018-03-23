package gameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import entities.Player;

public class ResultState extends GameState {

	private BufferedImage bg;
	private Player player;

	private Color titleColor;
	private Font titleFont;
	private Font font;

	public ResultState(GameStateManager gsm, Player player) {

		this.gsm = gsm;
		this.player = player;

		try {
			bg = ImageIO.read(getClass().getResourceAsStream("/Backgrounds/foothillBackground.jpg"));

			titleColor = new Color(128, 0, 0);
			titleFont = new Font("Century Gothic", Font.PLAIN, 28);

			font = new Font("Arial", Font.PLAIN, 12);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void init() {
	}

	public void update() {
	}

	public void draw(Graphics2D g) {

		g.drawImage(bg, 0, 0, null);

		// draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("Sniper Grade Elite", 50, 40);
		
		//draw others
		g.setFont(font);
		g.setColor(Color.CYAN);
		g.drawString("Your GPA was " + String.format("%.2f", player.gpa[0]), 110, 70);
		g.drawString("Thus, your rank is...", 110, 90);
		g.setFont(titleFont);
		g.setColor(Color.ORANGE);
		g.drawString(getRank(player.gpa[0]), 30, 130);
		g.setFont(font);
		g.setColor(Color.CYAN);
		g.drawString("Press Q to quit.", 120, 160);
		g.drawString("(you could do this at any point in the game lol)", 35, 180);
	}
	
	private String getRank(double gpa) {
		return gsm.getRanks((int) (gpa * 2));
	}

	public void goToNext() {
	}

	public void keyPressed(int k) {
		if (k == KeyEvent.VK_Q) {
			System.exit(0);
		}
	}

	public void keyReleased(int k) {
	}

}

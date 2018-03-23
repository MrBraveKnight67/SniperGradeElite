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
		g.drawString("Sniper Grade Elite", 50, 70);
		
		//draw others
		g.setFont(font);
		g.setColor(Color.RED);
		g.drawString("Your GPA was " + String.format("%.2f", player.gpa[0]), 50, 80);
		g.drawString("Thus, your rank is...", 50, 100);
		g.setFont(titleFont);
		g.setColor(Color.GREEN);
		g.drawString(getRank(player.gpa[0]), 50, 120);
		g.setFont(font);
		g.setColor(Color.RED);
		g.drawString("Press Q to quit.", 50, 140);
		g.drawString("(you could do this at any point in the game lol)", 50, 160);
	}
	
	private String getRank(double gpa) {
		if (gpa < 1) {
			return "Faibralin";
		} else if (gpa < 1.5) {
			return "Kennyboi (no offense)";
		} else if (gpa < 2) {
			return "YaBoiBrian";
		} else if (gpa < 2.5) {
			return "Dutta";
		} else if (gpa < 3) {
			return "Warren";
		} else if (gpa < 3.5) {
			return "Shiladitya";
		} else if (gpa < 4) {
			return "Aadi";
		} else if (gpa == 4) {
			return "Rohith/sub-Kevin Li";
		}
		return "tooLazy fam";
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

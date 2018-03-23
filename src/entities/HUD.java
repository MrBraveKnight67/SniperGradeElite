package entities;

import java.awt.*;
import gameState.GameStateManager;

public class HUD {

	private Player player;
	private Font font;
	private int x, y;

	public HUD(Player player, int x, int y) {
		this.player = player;
		this.x = x;
		this.y = y;
		font = new Font("Arial", Font.PLAIN, 14);
	}

	public void draw(Graphics2D g, GameStateManager gsm) {
		String rank = getRank(player.gpa[0], gsm);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString("GPA: " + String.format("%.2f", player.gpa[0]), x, y);
		g.drawString("RANK: " + rank, x, y + 12);
	}

	public String getRank(double gpa, GameStateManager gsm) {
		return gsm.getRanks((int) (gpa * 2));
	}

	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

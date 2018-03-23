package entities;

import java.awt.*;

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

	public void draw(Graphics2D g) {
		String rank = getRank(player.gpa[0]);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString("GPA: " + String.format("%.2f", player.gpa[0]), x, y);
		g.drawString("RANK: " + rank, x, y + 12);
	}

	public String getRank(double gpa) {
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

	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

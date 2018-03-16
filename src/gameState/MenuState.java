package gameState;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class MenuState extends GameState {
	
	private BufferedImage bg;
	
	private int currentChoice = 0;
	private String[] options = {"Start", "Help", "Quit"};
	
	private Color titleColor;
	private Font titleFont;
	
	private Font font;
	
	public MenuState(GameStateManager gsm) {
		
		this.gsm = gsm;
		
		try {
			
			bg = ImageIO.read(getClass().getResourceAsStream("/background.gif"));
			
			titleColor = new Color(128, 0, 0);
			titleFont = new Font(
					"Century Gothic",
					Font.PLAIN,
					28);
			
			font = new Font("Arial", Font.PLAIN, 12);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void init() {}
	
	public void update() {}
	
	public void draw(Graphics2D g) {
		
		// draw bg
		g.drawImage(bg, GamePanel.WIDTH, GamePanel.HEIGHT, null);
		
		// draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("Sniper Grade Elite", 80, 70);
		
		// draw menu options
		g.setFont(font);
		for(int i = 0; i < options.length; i++) {
			if(i == currentChoice) {
				g.setColor(Color.BLACK);
			}
			else {
				g.setColor(Color.RED);
			}
			g.drawString(options[i], 145, 140 + i * 15);
		}
		
	}
	
	private void select() {
		if(currentChoice == 0) {
			gsm.setState(GameStateManager.LEVEL1STATE);
		}
		if(currentChoice == 1) {
			options[1] = "u get no help in school lol";
		}
		if(currentChoice == 2) {
			System.exit(0);
		}
	}
	
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER){
			select();
		}
		if(k == KeyEvent.VK_UP) {
			currentChoice--;
			if(currentChoice == -1) {
				currentChoice = options.length - 1;
			}
		}
		if(k == KeyEvent.VK_DOWN) {
			currentChoice++;
			if(currentChoice == options.length) {
				currentChoice = 0;
			}
		}
	}
	public void keyReleased(int k) {}
	
}

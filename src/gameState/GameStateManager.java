package gameState;

import entities.Player;

public class GameStateManager {
	
	private GameState[] gameStates;
	public int currentState;
	
	private Player player;
	private String[] ranks;
	
	public static final int NUMGAMESTATES = 5;
	public static final int MENUSTATE = 0;
	public static final int LEVEL1STATE = 1;
	public static final int LEVEL2STATE = 2;
	public static final int LEVEL3STATE = 3;
	public static final int RESULTSTATE = 4;
	
	public GameStateManager() {
		
		gameStates = new GameState[NUMGAMESTATES];
		
		currentState = MENUSTATE;
		ranks = new String[]{"Jasper", "Faibralin", "Allen", "Warren",
				"Junghwa", "Bilal", "Shreyas (2nd to Kevin Li)", "Rohith/sub-Kevin Li"};
		loadState(currentState);
		
	}
	
	private void loadState(int state) {
		if(state == MENUSTATE)
			gameStates[state] = new MenuState(this);
		if(state == LEVEL1STATE)
			gameStates[state] = new Level1State(this);
		if(state == LEVEL2STATE)
			gameStates[state] = new Level2State(this, player);
		if(state == LEVEL3STATE)
			gameStates[state] = new Level3State(this, player);
		if(state == RESULTSTATE)
			gameStates[state] = new ResultState(this, player);
	}
	
	private void unloadState(int state) {
		gameStates[state] = null;
	}
	
	public void setState(int state) {
		unloadState(currentState);
		currentState = state;
		loadState(currentState);
		gameStates[currentState].init();
	}

	public void setState(int state, Player player) {
		unloadState(currentState);
		currentState = state;
		this.player = player;
		loadState(currentState);
		gameStates[currentState].init();
	}

	public void update() {
		try {
			gameStates[currentState].update();
		} catch(Exception e) {}
	}
	
	public String getRanks(int i) {
		return ranks[i];
	}
	
	public void draw(java.awt.Graphics2D g) {
		try {
			gameStates[currentState].draw(g);
		} catch(Exception e) {}
	}
	
	public void keyPressed(int k) {
		try {
			gameStates[currentState].keyPressed(k);
		} catch(Exception e) {}
	}
	
}










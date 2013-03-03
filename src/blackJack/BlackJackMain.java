package blackJack;

public class BlackJackMain {

	public static void main(String[] args){	
		DrawBoard gui = new DrawBoard();
		GameState gs = new GameState(gui);
		
		gui.setGameState(gs);
		gui.setVisible(true);
	}
}

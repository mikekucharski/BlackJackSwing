package blackJack;

public class GameState {
	
	private DrawBoard GUI;
	private Deck deck;
	private Player player1;
	private Person dealer;
	private int bet;
	
	public GameState(DrawBoard g){
		GUI = g;
		deck = new Deck();
		player1 = new Player();
		dealer = new Person();
		dealer.panelIndex = 0;
		player1.panelIndex = 1;
		bet = 0;
	}
	
	public void buttonClick(String buttonText){
		if(buttonText == "Play"){
			if(deck.getNumberOfCards() < 20){
				deck = new Deck();
				GUI.displayDeckShuffled();
			}
			GUI.setRoundView();
			
			player1.hit(deck.drawFromDeck());
			player1.hit(deck.drawFromDeck());
			
			dealer.hit(deck.drawFromDeck());
			dealer.hit(deck.drawFromDeck());
			dealer.getCard(0).flipFaceDown(true);

			GUI.drawGame(deck, player1, dealer, player1.getCoins());
			
			if(blackJackCheck(player1))	{evaluateWinner();}
		}
		else if(buttonText == "Rules"){	
			RulesBox r = new RulesBox();
			r.setVisible(true);
		}else if(buttonText == "Deal"){	
			if(bet == 0){
				GUI.displayUserPrompt("Click on the chips to bet or click Max Bet.");
			}else{
				buttonClick("Play");
			}
		}else if(buttonText == "Max Bet"){	
			if(player1.getCoins() < 200){
				bet = player1.getCoins();
				player1.addCoins((player1.getCoins() * -1));
			}
			else{
				while(bet < 200){
					player1.addCoins(-1);
					bet += 1;
				}
			}
			GUI.drawGame(deck, player1, dealer, player1.getCoins());
		}else if(buttonText == "Reset Bet"){	
			player1.addCoins(bet);
			bet = 0;
			GUI.drawGame(deck, player1, dealer, player1.getCoins());
		}else if(buttonText == "Hit Me"){
			player1.hit(deck.drawFromDeck());
			GUI.drawGame(deck, player1, dealer, player1.getCoins());
			if(player1.getScore() > 21 || dealer.getScore() > 21){
	    		evaluateWinner();
			}
		}else if(buttonText == "Stand"){
			dealerTurn();
			evaluateWinner();
		}else if(buttonText == "Play Again"){
			if(player1.getCoins() > 0 )	{resetGame();}
			else{
				resetGame();
				player1.setCoins(1000);
				GUI.displayUserPrompt("You are out of coins. 1000 coins borrowed.");
				GUI.drawGame(deck, player1, dealer, player1.getCoins());
			}
		}else if(buttonText == "Exit")	{System.exit(0);}
	}
	
	public static boolean blackJackCheck(Person person)
	{
		if(person.getHandSize() == 2 && person.getScore() == 21 && person.getNumberOfAces() == 1)
			return true;
		
		return false;
	}
	
	//pass action
	public void labelClick(String toolTipText){
		int adjustment = 0;
		
		if(toolTipText == "Bets 1 coin")
			adjustment = 1;
		else if(toolTipText == "Bets 5 coins")
			adjustment = 5;
		else if(toolTipText == "Bets 25 coins")
			adjustment = 25;
		else if(toolTipText == "Bets 100 coins")
			adjustment = 100;
		
		if((bet + adjustment) <= 200 && (player1.getCoins() - adjustment) >= 0 ){
			bet += adjustment;
			player1.addCoins(adjustment*-1);
		}
		
		GUI.drawGame(deck, player1, dealer, player1.getCoins());
	}
	
	public int getBet(){
		return bet;
	}
	
	public void dealerTurn(){
		while(dealer.getScore() < 17){
			dealer.hit(deck.drawFromDeck());
			GUI.drawGame(deck, player1, dealer, player1.getCoins());
		}
	}
	
	public void evaluateWinner(){
		GUI.evaluateWinnerView();
		String message;
		
		if(blackJackCheck(player1))	{ 
			message = "You got Black Jack! You Win!";
			player1.addCoins((bet) * 2);
		}else if(player1.getScore() > 21)
			message = "Your Bust. You lose " + bet + " coins.";
		else if(dealer.getScore() > 21){
			message = "Dealer Busts. You win " + bet + " coins.";
			player1.addCoins((bet) * 2);
		}else{
			if(player1.getScore() > dealer.getScore()){
				message = "You won draw with a score of " + player1.getScore();
				player1.addCoins((bet) * 2);
			}else if(player1.getScore() < dealer.getScore())
				message = "Dealer won draw with score of " + dealer.getScore();
			else{
				message = "You and the dealer TIE with a score of " + player1.getScore();
				player1.addCoins(bet);
			}
		}
		
		GUI.displayUserPrompt(message);
		
		if(player1.getScore() <= 21 && !blackJackCheck(player1))
			dealer.getCard(0).flipFaceDown(false);

		GUI.drawGame(deck, player1, dealer, player1.getCoins());
	}
	
	public void resetGame(){
		player1.removeCards();
		dealer.removeCards();
		bet = 0;
		
		GUI.resetGameView();
		GUI.drawGame(deck, player1, dealer, player1.getCoins());
	}
}

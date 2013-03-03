package blackJack;

import java.util.ArrayList;

//inherited from person. main reason for player class: players have coins and the dealer does not
public class Player extends Person {
	
	int coins;

	public Player()
	{
		//1000 is a reasonable number of coins to start with
		coins = 1000;
		hand = new ArrayList<Card>();
	}
	
	//to subtract coins, just pass a negative value
	public void addCoins(int coinsToAdd)
	{
		coins += coinsToAdd;
	}
	
	//sets the players coins equal to a new value
	public void setCoins(int newCoinValue)
	{
		coins = newCoinValue;
	}
	
	//returns how many coins the player has
	public int getCoins()
	{
		return coins;
	}
}

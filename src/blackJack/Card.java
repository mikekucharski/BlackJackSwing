package blackJack;

public class Card {
	
	private boolean isFaceDown;
	//every card is defined by a suit and rank only
	private int rank;
	private int suit;
	
	//string arrays hold all the possible suits and ranks a card can have
	private String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
    private String[] ranks = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
	
	public Card(int s, int r) 
	{
		suit = s;
		rank = r;
		isFaceDown = false;
	}
	
	//copy constructor
	public Card(Card c)
	{
		suit = c.getSuit();
		rank = c.getRank();
		isFaceDown = false;
	}
	
	//converts card from integer format to string format
	public String toString()
	{
		return ranks[rank] + " of " + suits[suit];
	}
	
	//returns how many points a card is worth in the game Black Jack
	public int getRankValue() 
	{
		switch(rank)
		{
			case 0 : return 1;
			case 1 : return 2;
			case 2 : return 3;
			case 3 : return 4;
			case 4 : return 5;
			case 5 : return 6;
			case 6 : return 7;
			case 7 : return 8;
			case 8 : return 9;
			case 9 : return 10;
			case 10 : return 10;
			case 11 : return 10;
			case 12 : return 10;
			default: return 0;
		}
	}
	
	//returns the card's rank
	public int getRank() 
	{
		return rank;
	}
	
	//returns the card's suit
	public int getSuit() 
	{
		return suit;	
	}
	
	public void flipFaceDown(boolean b)
	{
		isFaceDown = b;
	}
	
	public boolean isCardFlipped()
	{
		return isFaceDown;
	}
}

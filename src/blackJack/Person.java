package blackJack;

import java.util.ArrayList;

//Person can be a player or the dealer
public class Person {
	
	//each person has a dynamic array of cards as their hand
	ArrayList<Card> hand;
	int panelIndex;
	
	public Person()
	{
		hand = new ArrayList<Card>();
	}
	
	//sum up the value of each card in a the persons hand. If there is at least one ace,
	//   make one of the aces an 11 (add 10 to score) if the players score wont go over 21
	public int getScore()
	{
		int score = 0;
		
		for(int i = 0; i < getHandSize(); i++)
			score += hand.get(i).getRankValue();
		
		if( (score + 10 <= 21) && getNumberOfAces() >= 1)
			score += 10;
		
		return score;
	}
	
	//cycles through hand and returns number of aces found
	public int getNumberOfAces()
	{
		int numberOfAces = 0;
		
		for(int i = 0; i < getHandSize(); i++)
		{	
			if(hand.get(i).getRankValue() == 1)
				numberOfAces++;	
		}
		
		return numberOfAces;
	}
	
	//returns number of cards in hand
	public int getHandSize()
	{
		return hand.size();
	}
	
	//removes all the cards in hand
	public void removeCards()
	{
		hand.clear();
	}
	
	//adds one card to player's hand
	public void hit(Card newCard)
	{
		hand.add(newCard);
	}
	
	//returns the card at the given index
	public Card getCard(int i)
	{
		return hand.get(i);
	}
	
	public int getPanelIndex()
	{
		return panelIndex;
	}
}

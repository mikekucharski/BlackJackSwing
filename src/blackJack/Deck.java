package blackJack;

import java.util.Random;

public class Deck {

	private Card[] deckOfCards;
	private int cardsleft;
	private final int DECK_NUM_CARDS = 52;
	
	//default constructor, fill array with all 52 cards and shuffles them
	Deck()
	{
		cardsleft = 52;
		deckOfCards = new Card[DECK_NUM_CARDS];
		int index = 0;
		
		for(int suit = 0; suit <= 3; suit++)
		{
			for(int rank = 0; rank <= 12; rank++)
			{
				deckOfCards[index] = new Card(suit, rank);
				index++;	
			}
		}
		shuffle();
	}
	
	//returns the top(last) card of the deck. also sets the last card to null and decrements cardsLeft
	public Card drawFromDeck()
	{
		Card draw = deckOfCards[cardsleft-1];
		deckOfCards[cardsleft-1] = null;
		cardsleft--;
		return draw;
	}
	
	//gets a random number between 0 and 51. takes the card at that index and swaps it with the last card in the deck. repeats cardsLeft times
	public void shuffle()
	{
		int numCards = cardsleft-1;
		Random randomGenerator = new Random();
        while (numCards > 1) 
        {
        	int randomInt = randomGenerator.nextInt(51);
            Card temp = deckOfCards[numCards];
            deckOfCards[numCards] = deckOfCards[randomInt];
            deckOfCards[randomInt] = temp;
            numCards--;
        }
	}
	
	//returns the number of cards left in the deck
	public int getNumberOfCards()
	{
		return cardsleft;
	}
}

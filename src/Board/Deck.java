package Board;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards;

//	public Board.Deck(){
////		cards = new ArrayList<>();
////	}

	public Deck(String size) {
		switch (size) {
			case "Full":
				cards = createDeck();
				break;
			default:
				cards = new ArrayList<>();
				break;
		}
	}

	private ArrayList<Card> createDeck() {
		ArrayList<Card> deck = new ArrayList<>();
		Card.Suit suit;
		int value;
		Card card;
		for (value = 1; value < 14; value++) {
			suit = Card.Suit.Clubs;
			card = new Card(suit,value,false);
			deck.add(card);

			suit = Card.Suit.Diamonds;
			card = new Card(suit,value,false);
			deck.add(card);

			suit = Card.Suit.Spades;
			card = new Card(suit,value,false);
			deck.add(card);

			suit = Card.Suit.Hearts;
			card = new Card(suit,value,false);
			deck.add(card);
		}
		return deck;
	}

	public void addCard(Card card){
		cards.add(card);
	}

	public void shuffle(){
		ArrayList shuffledCards = new ArrayList();
		Random rand = new Random();
		while(cards.size()>0){
			int value = rand.nextInt(cards.size());
			shuffledCards.add(cards.get(value));
			cards.remove(value);
		}
		this.cards = shuffledCards;
	}

	public Card removeCard(){
		Card c = cards.get(cards.size()-1);
		cards.remove(cards.size()-1);
		return c;
	}

	public int getSize() {
		return cards.size();
	}

	public boolean contains(Card card) {
		return cards.contains(card);
	}
}

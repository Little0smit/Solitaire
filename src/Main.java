public class Main {
	public static Deck deck;
	public static void main(String[] args) {
		deck = new Deck();
		Card.Suit suit;
		int value;
		Card card;
		for (value = 1; value < 14; value++) {
			suit = Card.Suit.Clubs;
			card = new Card(suit,value,true);
			deck.addCard(card);

			suit = Card.Suit.Diamonds;
			card = new Card(suit,value,true);
			deck.addCard(card);

			suit = Card.Suit.Spades;
			card = new Card(suit,value,true);
			deck.addCard(card);

			suit = Card.Suit.Hearts;
			card = new Card(suit,value,true);
			deck.addCard(card);
		}
		System.out.println(deck.getSize());
		deck.shuffle();
		System.out.println("\nEnd");
	}
}

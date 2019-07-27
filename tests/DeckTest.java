import Board.Card;
import Board.Deck;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeckTest {

	public Deck deck;
	public Card c1,c2,c3,c4,c5;
	@Before
	public void setUp() throws Exception {
		deck = new Deck("");
		c1 = new Card(Card.Suit.Spades, 1,false);
		c2 = new Card(Card.Suit.Hearts, 1,false);
		c3 = new Card(Card.Suit.Diamonds, 1,false);
		c4 = new Card(Card.Suit.Clubs, 1,false);
		c5 = new Card(Card.Suit.Spades, 10,false);


	}

	@Test
	public void addCard() {
		assertEquals(deck.getSize(),0);
		deck.addCard(c1);
		deck.addCard(c2);
		assertEquals(deck.getSize(),2);
	}

	@Test
	public void shuffle() {
		Deck d2 = new Deck("");
		deck.addCard(c1);
		deck.addCard(c2);
		deck.addCard(c3);
		deck.addCard(c4);
		deck.addCard(c5);

		d2.addCard(c1);
		d2.addCard(c2);
		d2.addCard(c3);
		d2.addCard(c4);
		d2.addCard(c5);
		deck.shuffle();

		assertNotEquals(d2.removeCard(), deck.removeCard());
	}

	@Test
	public void removeSoloCard() {
		deck.addCard(c1);
		assert deck.contains(c1);
		Card card = deck.removeCard();
		assertEquals(card,c1);
		assert !deck.contains(c1);

	}
}
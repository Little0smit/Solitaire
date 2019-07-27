import Board.Card;
import Board.Stack;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StackTest {


	public Stack stack;
	public Card c1,c2,c3,c4,c5;

	@Before
	public void setUp() throws Exception {
		stack = new Stack(0);
		c1 = new Card(Card.Suit.Spades, 1,false);
		c2 = new Card(Card.Suit.Hearts, 2,false);
		c3 = new Card(Card.Suit.Clubs, 3,false);
		c4 = new Card(Card.Suit.Diamonds, 4,false);
		c5 = new Card(Card.Suit.Spades, 5,false);
	}

	@Test
	public void checkRemoveCardValid() {
		stack.systemAddCard(c5);
		stack.systemAddCard(c1);
		stack.systemAddCard(c2);
		stack.systemAddCard(c3);
		stack.systemAddCard(c4);
		ArrayList<Card> cards = stack.checkRemoveCard(c1);
		assertTrue(stack.contains(c1));
		assertTrue(cards.size()==4);
	}

	@Test
	public void removeCard() {
		stack.systemAddCard(c5);
		stack.systemAddCard(c1);
		stack.systemAddCard(c2);
		stack.systemAddCard(c3);
		stack.systemAddCard(c4);
		stack.removeCard(c1);
		assertFalse(stack.contains(c1));
		assertTrue(stack.getSize()==1);
	}

	@Test
	public void addCardsValid() {
		stack.systemAddCard(c5);
		ArrayList<Card> cards = new ArrayList<>();
		cards.add(c4);
		cards.add(c3);
		cards.add(c2);
		cards.add(c1);
		assertTrue(stack.addCards(cards));
	}

	@Test
	public void addCardsInvalidFirstCard() {
		stack.systemAddCard(c1);
		ArrayList<Card> cards = new ArrayList<>();
		cards.add(c4);
		cards.add(c3);
		cards.add(c2);
		cards.add(c1);
		assertFalse(stack.addCards(cards));
	}

	@Test
	public void addCardsInvalidMidCard() {
		stack.systemAddCard(c5);
		ArrayList<Card> cards = new ArrayList<>();
		cards.add(c4);
		cards.add(c3);
		cards.add(c1);
		cards.add(c2);
		assertFalse(stack.addCards(cards));
	}

	@Test
	public void getTopCard() {
		stack.systemAddCard(c5);
		stack.systemAddCard(c3);
		assertEquals(stack.getTopCard(),c3);
	}

	@Test
	public void getStackPos() {
		assertEquals(0,stack.getStackPos());
	}
}
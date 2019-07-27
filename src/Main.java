import Board.Card;
import Board.Deck;
import Board.DiscardStack;
import Board.Stack;

public class Main {
	public static Deck deck;
	private static Stack s1, s2, s3, s4, s5, s6, s7;
	private static DiscardStack	 discClubs, discDiamonds, discHearts, discSpades;
	public static void main(String[] args) {
		initialise();
		deck = new Deck("Full");
		deck.shuffle();
		dealCards();
		flipTopCards();
		System.out.println("\nEnd");
	}

	private static void initialise() {
		deck = new Deck("Full");
		s1 = new Stack(0);
		s2 = new Stack(1);
		s3 = new Stack(2);
		s4 = new Stack(3);
		s5 = new Stack(4);
		s6 = new Stack(5);
		s7 = new Stack(6);

		discClubs = new DiscardStack(Card.Suit.Clubs);
		discDiamonds = new DiscardStack(Card.Suit.Diamonds);
		discHearts = new DiscardStack(Card.Suit.Hearts);
		discSpades = new DiscardStack(Card.Suit.Spades);
	}

	private static void dealCards() {
		int startInt = 0;
		do {
			switch (startInt) {
				case 0:s1.systemAddCard(deck.removeCard());
				case 1:s2.systemAddCard(deck.removeCard());
				case 2:s3.systemAddCard(deck.removeCard());
				case 3:s4.systemAddCard(deck.removeCard());
				case 4:s5.systemAddCard(deck.removeCard());
				case 5:s6.systemAddCard(deck.removeCard());
				case 6:s7.systemAddCard(deck.removeCard());
			}
			startInt++;
		} while (startInt <7);
	}

	private static void flipTopCards() {
		s1.setTopCardVisible();
		s2.setTopCardVisible();
		s3.setTopCardVisible();
		s4.setTopCardVisible();
		s5.setTopCardVisible();
		s6.setTopCardVisible();
		s7.setTopCardVisible();
	}
}

public class Card {
	enum Suit {Spades, Hearts, Diamonds, Clubs};
	private Suit suit;
	private int value;
	private boolean visible;

	public Card(Suit suit, int value, boolean visible){
		this.suit = suit;
		this.value = value;
		this.visible = visible;
	}

	public Suit getSuit() {
		return suit;
	}

	public int getValue() {
		return value;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible() {
		this.visible = true;
	}

	public void setInvisible() {
		this.visible = false;
	}
}

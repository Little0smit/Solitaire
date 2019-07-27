package Exceptions;

import Board.Card;

public class IncorrectSuitException extends Exception {
	 Enum<Card.Suit> suitEnum;

	public IncorrectSuitException(Enum<Card.Suit> suit) {
		suitEnum = suit;
	}

	public String toString() {
		return "Incompatible Suit: " + suitEnum;
	}
}

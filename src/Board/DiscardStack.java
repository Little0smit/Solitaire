package Board;

import Exceptions.IncorrectSuitException;
import Exceptions.IncorrectValueException;

import java.util.ArrayList;

public class DiscardStack{
	private Enum<Card.Suit> suitEnum;
	private ArrayList<Card> cards;
	private int topCardValue;

	public DiscardStack(Enum<Card.Suit> suit) {
		suitEnum = suit;
		cards = new ArrayList<>();
		topCardValue = -1;
	}

	public boolean addCard(Card card) throws IncorrectSuitException, IncorrectValueException {
		if (!card.getSuit().equals(suitEnum)){
			throw new IncorrectSuitException(card.getSuit());
		}
		if (card.getValue()!= topCardValue+1){
			throw new IncorrectValueException(card.getValue());
		}
		cards.add(card);
		topCardValue = card.getValue();
		return true;
	}

	public Card removeCard(){
		Card removedCard = cards.get(cards.size()-1);
		cards.remove(cards.size()-1);
		topCardValue--;
		return removedCard;
	}

	public boolean contains(Card card) {
		return cards.contains(card);
	}
}

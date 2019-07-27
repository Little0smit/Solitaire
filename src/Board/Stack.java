package Board;

import Exceptions.IncorrectSuitException;
import Exceptions.IncorrectValueException;

import java.util.ArrayList;

public class Stack {
	private int stackPos;
	private ArrayList<Card> cards;
	public Stack(int stackPos){
		this.stackPos = stackPos;
		cards = new ArrayList<>();
	}

	/**
	 * Returns all cards from card given to top of deck inclusive
	 * @param card the card in the stack to return from
	 * @return an ArrayList of the cards from card to top of stack
	 */
	public ArrayList<Card> checkRemoveCard(Card card){
		ArrayList<Card> removedCards = new ArrayList<>();
		int j = cards.indexOf(card);
		if(j==-1) return removedCards;
		for (int i = cards.size() - j; i > 0 ; i--) {
			removedCards.add(cards.get(j));

		}
		//TODO check card stack to remove is valid.
		return removedCards;
	}

	/**
	 * Removes all cards from card given to top of deck inclusive
	 * @param card the card in the stack to remove from
	 */
	public void removeCard(Card card){
		//TODO check card stack to remove is valid.
		int j = cards.indexOf(card);
		if(j==-1) return;
		for (int i = cards.size() - j; i > 0 ; i--) {
			cards.remove(j);
		}

		return;
	}

	/**
	 * Adds a batch of cards to the stack.
	 * Removes all cards added if one in stack is invalid.
	 * @param newCards ArrayList of cards to add, in descending order
	 * @return boolean whether add was completed.
	 */
	public boolean addCards(ArrayList<Card> newCards){
		try{
			for (Card c : newCards) {
				if(addCard(c) == false){
					//Remove all cards added if one failed to be added
					removeCard(newCards.get(0));
					return false;
				}
			}
		} catch (IncorrectSuitException e) {
			//Possibly log to console why move failed.
			//Remove all cards added if one failed to be added
			removeCard(newCards.get(0));
			return false;
		} catch (IncorrectValueException e) {
			//Possibly log to console why move failed.
			//Remove all cards added if one failed to be added
			removeCard(newCards.get(0));
			return false;
		}
		return true;
	}

	/**
	 * Adds one card to the current stack, checking it is opposite colour and the correct value
	 * @param card the card to be added to the stack
	 * @return Whether the addition was valid or not
	 */
	private boolean addCard(Card card) throws IncorrectSuitException, IncorrectValueException {
		if(getSize()==0){
			if(card.getValue()!=13){
				throw new IncorrectValueException(card.getValue());
			}
			cards.add(card);
			return true;
		}
		Card topCard = getTopCard();
		//Checks new suit is opposite colour to current
		switch (topCard.getSuit()){
			case Spades:
			case Clubs:
				if(card.getSuit()== Card.Suit.Spades||card.getSuit()== Card.Suit.Clubs){
					throw new IncorrectSuitException(card.getSuit());
				}
				break;
			case Hearts:
			case Diamonds:
				if(card.getSuit()== Card.Suit.Hearts||card.getSuit()== Card.Suit.Diamonds){
					throw new IncorrectSuitException(card.getSuit());
				}
				break;
		}

		//checks value is 1 below current value
		if(card.getValue() != getTopCard().getValue()-1){
			throw new IncorrectValueException(card.getValue());
		}

		cards.add(card);
		return true;
	}

	/**
	 * Adds one card to the current stack.
	 * @param card the card to be added
	 */
	public void systemAddCard(Card card){
		cards.add(card);
	}

	public Card getTopCard(){
		return cards.get(cards.size()-1);
	}

	public int getStackPos(){
		return stackPos;
	}

	public int getSize() {
		return cards.size();
	}

	public boolean contains(Card card) {
		return cards.contains(card);
	}

	public void setTopCardVisible() {
		Card c = getTopCard();
		c.setVisible();
	}
}

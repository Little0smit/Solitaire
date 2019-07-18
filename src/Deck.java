import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards;

	public Deck(){
		cards = new ArrayList<>();
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

	public ArrayList<Card> removeCard(Card card){
		ArrayList<Card> removedCards = new ArrayList<>();
		int j = cards.indexOf(card);
		if(j==-1) return removedCards;
		for (int i = cards.size() - j; i > 0 ; i--) {
			removedCards.add(cards.get(j));
			cards.remove(j);
		}
		return removedCards;
	}

	public int getSize() {
		return cards.size();
	}

	public boolean contains(Card card) {
		return cards.contains(card);
	}
}

package classes;

public class DeckTest {

	public static void main(String[] args) {
		Deck myDeck = new Deck();
		for (int suit = 1; suit <= Deck.numSuits; suit++) {
			for (int rank = 1; rank <= Deck.numRanks; rank++) {
				Card currentCard = myDeck.getCard(suit, rank);
				System.out.println (currentCard);
			}
		}
	}
}

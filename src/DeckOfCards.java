import java.util.Random;

public class DeckOfCards {

	public static void main(String[] args) {
		String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[][] deck = new String[suits.length * ranks.length][2];
        int cardIndex = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[cardIndex][0] = rank;
                deck[cardIndex][1] = suit;
                cardIndex++;
            }
        }
        Random random = new Random();
        for (int i = deck.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            String[] temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
        String[][][] playerCards = new String[4][9][2];
        
        for (int player = 0; player < 4; player++) {
            for (int card = 0; card < 9; card++) {
                playerCards[player][card] = deck[player * 9 + card];
            }
        }
        for (int player = 0; player < 4; player++) {
            System.out.println("Player " + (player + 1) + " cards:");
            for (int card = 0; card < 9; card++) {
                System.out.println(playerCards[player][card][0] + " of " + playerCards[player][card][1]);
            }
            System.out.println();
        }

	}

}

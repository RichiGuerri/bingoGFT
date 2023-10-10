package bingo;

import java.util.ArrayList;

public class Player {
    private int index;
    private Card[] cards;

    public Player(int index, int dimCard) {
        this.index = index;
        this.cards = new Card[dimCard];
        this.generateNumbers();
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public int getIndex() {
        return index;
    }

    public void generateNumbers() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < 15 * cards.length; i++) {
            int rnd = (int) ((Math.random() * 90) + 1);
            if (!numbers.contains(rnd)) {
                numbers.add(rnd);
                continue;
            }
            i--;
        }

        for (int i = 0; i < cards.length; i++) {
            cards[i] = new Card(numbers.subList((i * 15), (i * 15) + 15).stream().mapToInt(j -> j).toArray());
        }

    }

    public void checkNumber(int num) {
        for (Card c : cards)
            c.checkNumber(num);
    }

    public boolean checkWin() {
        for (Card c : cards) {
            if (c.checkWin())
                return true;
        }
        return false;
    }

    public void printCards() {
        for (int c = 0; c < cards.length; c++) {
            System.out.println("------ Card number " + c + " of player " + index + " ------");
            int[][] n = cards[c].getNumbers();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) 
                    System.out.print(n[i][j] + "  ");
                System.out.println();
            }   
        }
    }
}

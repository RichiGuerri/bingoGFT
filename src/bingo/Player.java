package bingo;

public class Player {
    private int index;
    private CardBlock cardBlock;

    public Player(int index, int dimCard) {
        this.index = index;
        this.cardBlock = new CardBlock(dimCard);
    }

    public int getIndex() {
        return index;
    }

    public void checkNumber(int num) {
        for (Card c : cardBlock.getCards())
            c.checkNumber(num);
    }

    public boolean checkWin() {
        for (Card c : cardBlock.getCards()) {
            if (c.checkWin())
                return true;
        }
        return false;
    }

    public void printCards() {
        cardBlock.printCards(index);
    }
}

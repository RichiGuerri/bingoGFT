package bingo;

import java.util.ArrayList;

public class Table {
    private Player[] players;

    public Table(int dimPlayer, int dimCard) {
        this.players = new Player[dimPlayer];

        for (int i = 0; i < dimPlayer; i++) {
            this.players[i] = new Player(i, dimCard);
            this.players[i].printCards();
        }
    }

    public void play() {
        ArrayList<Integer> extracted = new ArrayList<Integer>();
        boolean victory = false;
        Player winner = null;
        while (!victory) {
            int rnd = (int) ((Math.random() * 90) + 1);
            if (extracted.contains(rnd))
                continue;
            System.out.println("Number " + rnd + " extracted.");
            extracted.add(rnd);
            for (Player p : players) {
                p.checkNumber(rnd);
                if (p.checkWin()) {
                    victory = true;
                    winner = p;
                }
            }
        }
        if (victory) {
            System.out.println("Victory by player n." + winner.getIndex());
        }
    }
}

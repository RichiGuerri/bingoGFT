package bingo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int dimPlayer = 0;
        int dimCard = 0;

        if (args.length == 0) {
            System.out.print("Give me number of players and how many cards: ");
            try (Scanner scanner = new Scanner(System.in)) {
                if (scanner.hasNextInt()) {
                    dimPlayer = scanner.nextInt();
                } else {
                    System.err.println("Bad input, discarded: " + scanner.next());
                }
                if (scanner.hasNextInt()) {
                    dimCard = scanner.nextInt();
                } else if (!scanner.hasNextInt() || dimCard > 6) {
                    System.err.println("Bad input, discarded: " + scanner.next());
                }
            }
        } else if (args.length == 2) {
            dimPlayer = Integer.parseInt(args[0]);
            dimCard = Integer.parseInt(args[1]);
        } else {
            System.err.println("Incorrect number of arguments.");
        }
        if (dimPlayer > 0 && dimCard > 0 && dimCard <= 6) {
            Table table = new Table(dimPlayer, dimCard);
            table.play();
        }
    }
}
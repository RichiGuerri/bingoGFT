package bingo;

import java.util.Arrays;

public class Card {
    private int[][] numbers;
    private boolean[][] checked;

    public Card(int[] numbers) {
        this.checked = new boolean[3][5];
        this.numbers = new int[3][5];

        for (int i = 0; i < 3; i++)
            Arrays.fill(checked[i], false);

        Arrays.sort(numbers);

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 5; j++)
                this.numbers[i][j] = numbers[(i * 5) + j];
    }

    public void checkNumber(int num) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 5; j++)
                if (this.numbers[i][j] == num)
                    this.checked[i][j] = true;
    }

    public boolean checkWin() {
        int trues = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 5; j++)
                if (this.checked[i][j])
                    trues++;
        if (trues == 5) {
            return true;
        }
        return false;
    }

    public int[][] getNumbers() {
        return numbers;
    }
}

package ru.Javahome.Snake.Main;

public class Referee {

    public static boolean checkWin(char[][] field) {
        boolean win;
        int count = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == 'x') count++;
            }
        }

        return win;
    }

    public boolean isAnyStringWin(char[][] field){
        boolean
    }
}

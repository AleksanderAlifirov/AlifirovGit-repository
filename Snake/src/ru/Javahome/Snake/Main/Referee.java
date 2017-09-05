package ru.Javahome.Snake.Main;

public class Referee {

    public static boolean checkWin(char[][] field) {

        int count;


        return;
    }

    public boolean isAnyStringWin(char[][] field){
        boolean win = false;
        int countZero;
        int countCross;
        for (int i = 0; i < 3; i++){
            countZero = 0;
            countCross = 0;
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == 'x') countCross++;
                if (field[i][j] == 'o') countZero++;
            }
            if ((countZero == 3) || (countCross == 3)) {
                win = true;
                break;
            }
        }

        return win;
    }

    public boolean isColumnWin (char[][] field){
        boolean win = false;
        int countZero;
        int countCross;
        for (int j = 0; j < 3; j++){
            countZero = 0;
            countCross = 0;
            for (int i = 0; i < 3; i++) {
                if (field[i][j] == 'x') countCross++;
                if (field[i][j] == 'o') countZero++;
            }
            if ((countZero == 3) || (countCross == 3)) {
                win = true;
                break;
            }
        }
        return win;
    }

    public boolean isDiagWin(char[][] field, String side){
        boolean win = false;
        int countZero;
        int countCross;
        switch(side){
         case "right" :
            for (int j = 0; j < 3; j++){
                countZero = 0;
                countCross = 0;
                for (int i = 0; i < 3; i++) {
                    if (field[i][i] == 'x') countCross++;
                    if (field[i][i] == 'o') countZero++;
                }
                if ((countZero == 3) || (countCross == 3)) {
                    win = true;
                    break;
                }
            }
            break;

         case "left" :
             for (int j = 0; j < 3; j++){
                 countZero = 0;
                 countCross = 0;
                 for (int i = 0; i < 3; i++) {
                     if (field[i][2 - i] == 'x') countCross++;
                     if (field[i][2 - i] == 'o') countZero++;
                 }
                 if ((countZero == 3) || (countCross == 3)) {
                     win = true;
                     break;
                 }
             }

        }

        return win;
    }
}

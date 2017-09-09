package ru.Javahome.Snake.Main;

public class Referee {
    private char[][] field;

    public Referee(char[][] gameField) {
             this.field = gameField;

    }

    public boolean checkWin() {
        boolean win = false;

        if (isAnyStringWin() == true || isColumnWin() == true || isDiagWin("right") == true ||
                isDiagWin("left") == true ) {
            System.out.println("Победитель ");
            win = true;
        }

        return win; // разобраться с победителем, доделать выбор клетки компьютером, т.к. он выбирает самую последнюю
    }

    public boolean isAnyStringWin(){
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

    public boolean isColumnWin (){
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

    public boolean isDiagWin(String side){
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
         break;
        }

        return win;
    }
}

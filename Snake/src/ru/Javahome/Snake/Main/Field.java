package ru.Javahome.Snake.Main;

public class Field {
    private boolean emptySpacePresent;
    private char symbol;
    private char[][] gameField;

    public Field(char[][] gameField, boolean emptySpacePresent){
        this.gameField = gameField;
        this.emptySpacePresent = emptySpacePresent;
    }

    public void initField(){
        for(int i=0; i < 3; i++){
            for (int j=0; j < 3; j++)
                gameField[i][j] = '*';
        }
    }

    public void printField(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                System.out.print(gameField[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public boolean isCellEmpty(int i, int j){

        if (gameField[i][j] == 'o' || gameField[i][j] == 'x') {emptySpacePresent = false;
        } else emptySpacePresent = true;

        return emptySpacePresent;
    }

    public char getGameField(int i, int j) {
        return gameField[i][j];
    }

    public char[][] getGameField() {
        return gameField;
    }

    public void setGameField(int i, int j, char symbol) {
        gameField[i][j] = symbol;
    }
}

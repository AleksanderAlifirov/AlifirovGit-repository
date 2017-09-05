package ru.Javahome.Snake.Main;

public class Field {
    private boolean empty = true;
    private char symbol;
    private char[][] gameField;

    public Field(){

            }

    public void initField(){
        for(int i=0; i < 3; i++){
            for (int j=0; j < 3; j++)
                gameField[i][j] = '0';
        }
    }

    public void printField(char[][] field){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++)
                System.out.println(field[i][j] + " ");
            System.out.println("\n");
        }
    }

    public boolean isFieldEmpty(int i, int j){
        if (gameField[i][j] == 'o' || gameField[i][j] == 'x') {empty = false;}
        return empty;
    }


}

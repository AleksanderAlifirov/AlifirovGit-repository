package ru.Javahome.Snake.Main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import static ru.Javahome.Snake.Main.TypeOfCell.*;

public class ComputerPlayer extends Cell implements Player   {
    private ArrayList<Cell> cell = new ArrayList<Cell>();
    private int i;
    private int j;
    private int index;
    private int moveNumber;

    @Override
    public void inputSymbol(Field field) {

        index = -1;
        if (cell.size() >= 8) {
            Random random = new Random();
            index = random.nextInt(cell.size());
           // i = random.nextInt(2);
            //j = random.nextInt(2);
        } else {
            index = chooseIndexForDefense(cell, field);
        }
        if (index == -1) index = chooseOptimalIndexForWin(cell, field);
    }

    public Cell getCell(int index) {
        return cell.get(index);
    }

    public int getIndex() {
        return index;
    }

    @Override
    public void checkField(Field field) {
        cell.clear();
        System.out.println("ASUS думает...");
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (field.isCellEmpty(i, j)) {
                    if (i == 0 && j == 0) cell.add(new Cell(i, j, LEFT_UPPER_CORNER));
                    if (i == 2 && j == 0) cell.add(new Cell(i, j, LEFT_LOWER_CORNER));
                    if (i == 2 && j == 2) cell.add(new Cell(i, j, RIGHT_LOWER_CORNER));
                    if (i == 0 && j == 2) cell.add(new Cell(i, j, RIGHT_UPPER_CORNER));
                    if (i > 0 && i < 2 && j > 0 && j < 2 ) cell.add(new Cell(i, j, TypeOfCell.CENTER_AREA));
                    if (i == 2 && 0 < j  && j < 2) cell.add(new Cell(i, j, TypeOfCell.LOWER_BOUNDARY));
                    if ( 0 < i && i < 2 && j == 2) cell.add(new Cell(i, j, TypeOfCell.RIGHT_BOUNDARY));
                    if (i == 0 && 0 < j  && j < 2) cell.add(new Cell(i, j, TypeOfCell.UPPER_BOUNDARY));
                    if (0 < i && i < 2 && j == 0 ) cell.add(new Cell(i, j, TypeOfCell.LEFT_BOUNDARY));

                }
            }
        }

        cell.trimToSize();
    }

    @Override
    public void moveNumberIncrease() {
        moveNumber++;
    }

    public int chooseOptimalIndexForWin(ArrayList<Cell> cell, Field gameField){
        int place = -1;
        //TypeOfCell typeOfCell = null;
        //Iterator<Cell> iter = cell.iterator();
     for(Cell o : cell) {
         switch (o.getTypeOfCell()) {
             case RIGHT_UPPER_CORNER:
                 if (gameField.getCellGameField(getI(o) + 1, getJ(o)) == 'o' || gameField.getCellGameField(getI(o), getJ(o) - 1) == 'o' ||
                         gameField.getCellGameField(getI(o) + 1, getJ(o) - 1) == 'o') place = cell.indexOf(o);
                 break;
             case RIGHT_LOWER_CORNER:
                 if (gameField.getCellGameField(getI(o) - 1, getJ(o)) == 'o' || gameField.getCellGameField(getI(o), getJ(o) - 1) == 'o' ||
                         gameField.getCellGameField(getI(o) - 1, getJ(o) - 1) == 'o') place = cell.indexOf(o);
                 break;
             case LEFT_LOWER_CORNER:
                 if (gameField.getCellGameField(getI(o), getJ(o) + 1) == 'o' || gameField.getCellGameField(getI(o) - 1, getJ(o)) == 'o' ||
                         gameField.getCellGameField(getI(o) - 1, getJ(o) + 1) == 'o') place = cell.indexOf(o);
                 break;
             case LEFT_UPPER_CORNER:
                if (gameField.getCellGameField(getI(o), getJ(o) + 1) == 'o' || gameField.getCellGameField(getI(o) + 1, getJ(o)) == 'o' ||
                        gameField.getCellGameField(getI(o) + 1, getJ(o) + 1) == 'o') place = cell.indexOf(o);
                 break;
             case CENTER_AREA:
                 if (gameField.getCellGameField(getI(o) + 1, getJ(o)) == 'o' || gameField.getCellGameField(getI(o), getJ(o) + 1) == 'o' ||
                       gameField.getCellGameField(getI(o) - 1, getJ(o)) == 'o' || gameField.getCellGameField(getI(o), getJ(o) - 1) == 'o' ||
                       gameField.getCellGameField(getI(o) + 1, getJ(o) + 1) == 'o' || gameField.getCellGameField(getI(o) - 1, getJ(o) - 1) == 'o' ||
                       gameField.getCellGameField(getI(o) + 1, getJ(o) - 1) == 'o' || gameField.getCellGameField(getI(o) - 1, getJ(o) + 1) == 'o') place = cell.indexOf(o);
                 break;
             case LOWER_BOUNDARY:
                 if (gameField.getCellGameField(getI(o), getJ(o) + 1) == 'o' || gameField.getCellGameField(getI(o), getJ(o) - 1) == 'o' ||
                         gameField.getCellGameField(getI(o) - 1, getJ(o)) == 'o') place = cell.indexOf(o);
                 break;
             case UPPER_BOUNDARY:
                 if (gameField.getCellGameField(getI(o), getJ(o) + 1) == 'o' || gameField.getCellGameField(getI(o) , getJ(o) - 1) == 'o' ||
                         gameField.getCellGameField(getI(o) + 1, getJ(o)) == 'o') place = cell.indexOf(o);
                 break;
             case RIGHT_BOUNDARY:
                 if (gameField.getCellGameField(getI(o), getJ(o) - 1) == 'o' || gameField.getCellGameField(getI(o) + 1, getJ(o)) == 'o' ||
                         gameField.getCellGameField(getI(o) - 1, getJ(o)) == 'o') place = cell.indexOf(o);
                 break;
             case LEFT_BOUNDARY:
                 if (gameField.getCellGameField(getI(o), getJ(o) + 1) == 'o' || gameField.getCellGameField(getI(o) + 1, getJ(o)) == 'o' ||
                         gameField.getCellGameField(getI(o) - 1, getJ(o)) == 'o') place = cell.indexOf(o);
                 break;
         }
     }

        return place;
    }


    public int chooseIndexForDefense(ArrayList<Cell> cell, Field gameField){
        int place = -1;

        for(Cell o : cell) {
            switch (o.getTypeOfCell()) {
                case RIGHT_UPPER_CORNER:
                    if (gameField.getCellGameField(getI(o) + 1, getJ(o)) == 'x'  && gameField.getCellGameField(getI(o) + 2, getJ(o)) == 'x' ||
                            gameField.getCellGameField(getI(o), getJ(o) - 1) == 'x' && gameField.getCellGameField(getI(o), getJ(o) - 2) == 'x' ||
                            gameField.getCellGameField(getI(o) + 1, getJ(o) - 1) == 'x' && gameField.getCellGameField(getI(o) + 2, getJ(o) - 2) == 'x') place = cell.indexOf(o);
                    break;
                case RIGHT_LOWER_CORNER:
                    if (gameField.getCellGameField(getI(o) - 1, getJ(o)) == 'x' && gameField.getCellGameField(getI(o) - 2, getJ(o)) == 'x' ||
                            gameField.getCellGameField(getI(o), getJ(o) - 1) == 'x' && gameField.getCellGameField(getI(o), getJ(o) - 2) == 'x' ||
                            gameField.getCellGameField(getI(o) - 1, getJ(o) - 1) == 'x' && gameField.getCellGameField(getI(o) - 2, getJ(o) - 2) == 'x') place = cell.indexOf(o);
                    break;
                case LEFT_LOWER_CORNER:
                    if (gameField.getCellGameField(getI(o), getJ(o) + 1) == 'x' && gameField.getCellGameField(getI(o), getJ(o) + 2) == 'x' ||
                            gameField.getCellGameField(getI(o) - 1, getJ(o)) == 'x' && gameField.getCellGameField(getI(o) - 2, getJ(o)) == 'x' ||
                            gameField.getCellGameField(getI(o) - 1, getJ(o) + 1) == 'x' && gameField.getCellGameField(getI(o) - 2, getJ(o) + 2) == 'x') place = cell.indexOf(o);
                    break;
                case LEFT_UPPER_CORNER:
                    if (gameField.getCellGameField(getI(o), getJ(o) + 1) == 'x' && gameField.getCellGameField(getI(o), getJ(o) + 2) == 'x' ||
                            gameField.getCellGameField(getI(o) + 1, getJ(o)) == 'x' && gameField.getCellGameField(getI(o) + 2, getJ(o)) == 'x' ||
                            gameField.getCellGameField(getI(o) + 1, getJ(o) + 1) == 'x' && gameField.getCellGameField(getI(o) + 2, getJ(o) + 2) == 'x') place = cell.indexOf(o);
                    break;
                case CENTER_AREA:
                    if (gameField.getCellGameField(getI(o) + 1, getJ(o)) == 'x' && gameField.getCellGameField(getI(o) - 1, getJ(o)) == 'x' ||
                            gameField.getCellGameField(getI(o), getJ(o) + 1) == 'x' && gameField.getCellGameField(getI(o), getJ(o) + 1) == 'x' ||
                            gameField.getCellGameField(getI(o) + 1, getJ(o) + 1) == 'x' && gameField.getCellGameField(getI(o) - 1, getJ(o) - 1) == 'x' ||
                            gameField.getCellGameField(getI(o) + 1, getJ(o) - 1) == 'x' && gameField.getCellGameField(getI(o) - 1, getJ(o) + 1) == 'x') place = cell.indexOf(o);
                    break;
                case LOWER_BOUNDARY:
                    if (gameField.getCellGameField(getI(o), getJ(o) + 1) == 'x' && gameField.getCellGameField(getI(o), getJ(o) - 1) == 'x' ||
                            gameField.getCellGameField(getI(o) - 1, getJ(o)) == 'x' && gameField.getCellGameField(getI(o) - 2, getJ(o)) == 'x') place = cell.indexOf(o);
                    break;
                case UPPER_BOUNDARY:
                    if (gameField.getCellGameField(getI(o), getJ(o) + 1) == 'x' && gameField.getCellGameField(getI(o) , getJ(o) - 1) == 'x' ||
                            gameField.getCellGameField(getI(o) + 1, getJ(o)) == 'x' && gameField.getCellGameField(getI(o) + 2, getJ(o)) == 'x') place = cell.indexOf(o);
                    break;
                case RIGHT_BOUNDARY:
                    if (gameField.getCellGameField(getI(o), getJ(o) - 1) == 'x' && gameField.getCellGameField(getI(o), getJ(o) - 2) == 'x'||
                            gameField.getCellGameField(getI(o) + 1, getJ(o)) == 'x' && gameField.getCellGameField(getI(o) - 1, getJ(o)) == 'x') place = cell.indexOf(o);
                    break;
                case LEFT_BOUNDARY:
                    if (gameField.getCellGameField(getI(o), getJ(o) + 1) == 'x' && gameField.getCellGameField(getI(o), getJ(o) + 2) == 'x' ||
                            gameField.getCellGameField(getI(o) + 1, getJ(o)) == 'x' && gameField.getCellGameField(getI(o) - 1, getJ(o)) == 'x') place = cell.indexOf(o);
                    break;
            }
        }



        /*    for (int i=0; i < gameField.getSize(); i++){
                for (int j = 0; j < gameField.getSize(); i++){
                    if (gameField.getCellGameField(i, j) == 'x')
                }
            }*/

        return place;
    }
}

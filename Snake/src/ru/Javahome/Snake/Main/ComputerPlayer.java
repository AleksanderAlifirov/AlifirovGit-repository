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
        } else index = chooseOptimalIndex(cell, field);
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
                    if (i == 0 && j!= 0) cell.add(new Cell(i, j, TypeOfCell.UPPER_BOUNDARY));
                    if (i == 2 && 0 < j  && j < 2) cell.add(new Cell(i, j, TypeOfCell.LOWER_BOUNDARY));
                    if ( 0 < i && i < 2 && j == 2) cell.add(new Cell(i, j, TypeOfCell.RIGHT_BOUNDARY));
                    if (i == 0 && 0 < j  && j < 2) cell.add(new Cell(i, j, TypeOfCell.UPPER_BOUNDARY));
                    if (0 < i && i < 2 && j == 0 ) cell.add(new Cell(i, j, TypeOfCell.UPPER_BOUNDARY));

                }
            }
        }

        cell.trimToSize();
    }

    @Override
    public void moveNumberIncrease() {
        moveNumber++;
    }

    public int chooseOptimalIndex(ArrayList<Cell> cell, Field gameField){
        int place = -1;
        TypeOfCell typeOfCell = null;
        //Iterator<Cell> iter = cell.iterator();
     for(Cell o : cell) {
         switch (o.getTypeOfCell()) {
             case RIGHT_UPPER_CORNER:
                 break;
             case RIGHT_LOWER_CORNER:
                 break;
             case LEFT_LOWER_CORNER:
                 break;
             case LEFT_UPPER_CORNER:
                 break;
             case CENTER_AREA:
                 break;
             case LOWER_BOUNDARY:
                 break;
             case UPPER_BOUNDARY:
                 break;
             case RIGHT_BOUNDARY:
                 break;
             case LEFT_BOUNDARY:
                 break;
         }
     }
      //  for(Cell o : cell){
        //    if (gameField.getGameField(getI(o) + 1, getJ(o)) == 'o' || gameField.getGameField(getI(o), getJ(o) + 1) == 'o' ||
            //        gameField.getGameField(getI(o) - 1, getJ(o)) == 'o' || gameField.getGameField(getI(o), getJ(o) + 1) == 'o' ||
          //          gameField.getGameField(getI(o) + 1, getJ(o) + 1) == 'o' || gameField.getGameField(getI(o) - 1, getJ(o) - 1) == 'o' ||
              //      gameField.getGameField(getI(o) + 1, getJ(o) - 1) == 'o' || gameField.getGameField(getI(o) - 1, getJ(o) + 1) == 'o') {
             //place = cell.indexOf(o);
           // }
       // }

        return place;
    }
}

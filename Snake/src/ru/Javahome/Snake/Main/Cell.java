package ru.Javahome.Snake.Main;

public class Cell {
    private int i;
    private int j;
    private TypeOfCell typeOfCell;

    public Cell(int i, int j, TypeOfCell typeOfCell) {
        this.i = i;
        this.j = j;
        this.typeOfCell = typeOfCell;
    }

    public Cell(){

    }

    public int getI(Cell cell) {
        return cell.i;
    }

    public int getJ(Cell cell) {
        return cell.j;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public TypeOfCell getTypeOfCell() {
        return typeOfCell;
    }
}

package ru.Javahome.Snake.Main;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private String name;
    private int moveNumber;
    private int i;
    private int j;

    public HumanPlayer(String name){
        this.name = name;
    }

    @Override
    public void inputSymbol(Field field) {

        boolean move = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите позицию для хода");
     do {
         do {
             System.out.println("Введите номер строки от 0 до 2 : ");
             i = sc.nextInt();
             if ((i >= 0) && (i <= 2)) move = true;
         } while (move == false);

         move = false;
         do {
             System.out.println("Введите номер столбца от 0 до 2 : ");
             j = sc.nextInt();
             if ((j >= 0) && (i <= 2)) move = true;
         } while (move == false);

         if (field.isCellEmpty(i, j)) move = true;
         else {
            System.out.println("К сожалению эта ячейка занята. Введите другие координаты");
             move = false;
            }
     }while (move == false);
    }
    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public String getName() {
        return name;
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    @Override
    public void checkField(Field field) {
        System.out.println("Человек думает...");

    }

    @Override
    public void moveNumberIncrease() {
        moveNumber++;
    }
}

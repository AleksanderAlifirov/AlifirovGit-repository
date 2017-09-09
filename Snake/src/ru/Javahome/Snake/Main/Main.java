package ru.Javahome.Snake.Main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        char[][] gameField = new char[3][3];

        Scanner sc = new Scanner(System.in);
        System.out.println("****** ИГРА КРИСТИКИ-НОЛИКИ ***********");
        System.out.println("****** Компьютер против Человека******* ПОЛЕ 3Х3");
        System.out.println("");
        Field pole = new Field(gameField, false);
        pole.initField();
        pole.printField();
        Referee referee = new Referee(gameField);
        HumanPlayer player1 = new HumanPlayer("Василий");
        System.out.println ("Здравствуйте! Меня зовут Василий");
        ComputerPlayer compPlayer = new ComputerPlayer();
        System.out.println ("Здравствуйте! Меня зовут ASUS");

        do{
            if (player1.getMoveNumber() >= 4) {System.out.println("НИЧЬЯ"); break;}
            player1.checkField(pole);
            player1.inputSymbol(pole);
            pole.setGameField(player1.getI(), player1.getJ(), 'x');
            player1.moveNumberIncrease();
            pole.printField();
            if (referee.checkWin()) {
                System.out.print( " " + player1.getName());
                break;
            }
            compPlayer.checkField(pole);
            compPlayer.inputSymbol(pole);
            pole.setGameField(compPlayer.getI(compPlayer.getCell(compPlayer.getIndex())), compPlayer.getJ(compPlayer.getCell(compPlayer.getIndex())), 'o');
            compPlayer.moveNumberIncrease();
            pole.printField();
            if (referee.checkWin()){
                System.out.println ("Победитель ASUS");
                break;
            }
        } while (true);



    }

}

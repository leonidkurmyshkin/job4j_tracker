package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            System.out.println("Спичек на столе: " + count);
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.print(player + ", введите число от 1 до 3: ");
            int matches = Integer.parseInt(input.nextLine());
            if (count - matches < 0 || matches < 1 || matches > 3) {
                System.out.println("Столько спичек взять не получится.");
                continue;
            }
            count = count - matches;
            turn = !turn;
        }
        System.out.println("Выиграл "
                + (!turn ? "первый" : "второй")
                + " игрок");
    }
}
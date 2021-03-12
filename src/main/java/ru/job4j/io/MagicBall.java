package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        new Scanner(System.in).nextLine();
        String answer;
        switch (new Random().nextInt(3)) {
            case 0 : answer = "Да";
                break;
            case 1 : answer = "Нет";
                break;
            default : answer = "Может быть";
        }
        System.out.println(answer);
    }
}

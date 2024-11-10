package org.example;

import java.util.Random;
import java.util.Scanner;

public class VirusHanter {
    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;
        int attempts = 0;
        int bestAttempts = 100;

        System.out.println("Вредные хакеры взломали компьютер! Найди вирус, угадай число от 1 до 100!");

        while (true) {
            System.out.print("Введи число: ");
            if (scanner.hasNextInt()) {
                int guess = scanner.nextInt();
                attempts++;

                if (guess == secretNumber) {
                    System.out.println("Ты победил! Вирус уничтожен! Загаданное число - " + secretNumber + ".");
                    System.out.println("Количество попыток: " + attempts);
                    System.out.println("Лучшее количество попыток: " + bestAttempts);
                    if (attempts < bestAttempts) {
                        bestAttempts = attempts;
                    }
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Я сам в шоке, но загаданное число больше, брат!");
                } else {
                    System.out.println("Не ожидал от тебя такого. Загаданное число меньше, брат!");
                }
            } else {
                System.out.println("Введи число, пожалуйста!");
                scanner.next();
            }

            if (scanner.hasNext("RESULT") || scanner.hasNext("result")) {
                System.out.println("Текущее количество попыток: " + attempts);
                System.out.println("Лучшее количество попыток: " + bestAttempts);
                scanner.next();
            }
        }
        scanner.close();
    }
}

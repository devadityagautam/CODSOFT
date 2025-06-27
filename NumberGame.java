package org.example;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        boolean play = true;
        while (play) {
            int s;
            int att = 0;
            int MAX_att = 10;
            int ran = r.nextInt(100) + 1;
            System.out.println("I have guessed a number between 1 to 100. Try to guess that number in 10 attempts !");
            while (true) {
                System.out.println("Enter your guess : ");
                s = sc.nextInt();
                att++;
                if (ran == s) {
                    System.out.println("You guessed correctly in " + att + " attempts. Well done ");
                    break;
                }
                if (ran < s) {
                    System.out.println("You guessed a large number. Try again ");
                } else {
                    System.out.println("You guessed a small number. Try again ");
                }
                if (att >= MAX_att) {
                    System.out.println("You have reached maximum number of attempts. The guessed number was " + ran);
                    break;
                }

            }
            System.out.println("Do you want to play another round (yes/no)");
            String res = sc.next();
            play = res.equalsIgnoreCase("yes");
        }
        System.out.println("Thanks for Playing!");
    }
}

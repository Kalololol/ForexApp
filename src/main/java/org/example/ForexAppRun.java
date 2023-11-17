package org.example;

import java.util.Scanner;

public class ForexAppRun {
    private String controller = "";
    private boolean finish = false;
    private Scanner input = new Scanner(System.in);
    public void Start(){
        System.out.println("Witaj w aplikacji Forexowy Księgowy");
        do{
            System.out.println("Menu");
            System.out.println("1. Oblicz transakcje jednostkową");
            System.out.println("2. Wczytaj listę transakcji");
            System.out.println("0. Zakończ");

            System.out.printf("Wybierz: ");
            controller = input.next();

        }while(!controller.equals("0"));
    }
}

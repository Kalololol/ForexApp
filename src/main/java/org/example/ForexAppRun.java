package org.example;

import logic.CSVMapper;
import logic.CalculateTransaction;
import model.Transaction;

import java.util.List;
import java.util.Scanner;

public class ForexAppRun {
    private String controller = "";
    private Scanner input = new Scanner(System.in);
    private final CalculateTransaction calculateTransaction = new CalculateTransaction();
    private final CSVMapper csvMapper = new CSVMapper();
    public void actionLoop(){
        boolean finish = true;

        System.out.println("Witaj w aplikacji Forexowy Księgowy");
        do{
            System.out.println("Menu");
            System.out.println("1. Oblicz transakcje jednostkową");
            System.out.println("2. Wczytaj listę transakcji");
            System.out.println("0. Zakończ");

            System.out.printf("Wybierz: ");
            controller = input.next();
            switch (controller){
                case "1":
                    calculateOneTransaction();
                    break;
                case "2":
                    readListTransaction();
                    break;
                case "0":
                    System.out.println("Zakończyłeś pracę programu.");
                    finish = false;
                    break;
                default:
                    System.out.println("Niepoprawny wybór, spróbuj jeszcze raz.");
            }

        }while(finish);
    }

    private void calculateOneTransaction ( ){
        boolean done = false;
        String codeCurrency = "";
        String dateTransaction = "";
        System.out.println("Podaj rok: YYYY ");
        dateTransaction += input.next();
        System.out.println("Podaj miesiąc: MM ");
        dateTransaction += "-" + input.next();
        System.out.println("Podaj dzień: DD ");
        dateTransaction += "-" + input.next();
        System.out.println("Podaj wartość transakcji:");
        double valueTransaction = input.nextDouble();


        do {
            System.out.println("Wybierz walutę transakcji: ");
            System.out.println("1. USD");
            System.out.println("2. EUR");
            codeCurrency = input.next();
            switch (codeCurrency) {
                case "1":
                    codeCurrency = "usd";
                    done = false;
                    break;
                case "2":
                    codeCurrency = "eur";
                    done = false;
                    break;
                default:
                    System.out.println("Wybierz ponownie walutę");
                    done = true;
            }
        }while (done);

        Transaction transaction = calculateTransaction.manualCalculate(valueTransaction, codeCurrency, dateTransaction);

        System.out.println(transaction.toString());
    }

    private void readListTransaction(){
        System.out.println("Podaj nazwę pliku do wczytania: ");
        String fileName = input.next();

        List<Transaction> list = csvMapper.readingFromFile(fileName);
        calculateTransaction.transactionList(list);
        for (Transaction transaction : list){
            System.out.println(transaction.toString());
        }
    }





}

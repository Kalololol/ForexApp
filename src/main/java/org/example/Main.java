package org.example;


public class Main {
    public static void main(String[] args) {

        ForexAppRun forexAppRun = new ForexAppRun();
        forexAppRun.actionLoop();
//        CSVMapper csvMapper = new CSVMapper();
//        CalculateTransaction calculateTransaction = new CalculateTransaction();
//
//        ArrayList<Transaction> transactionArrayList = csvMapper.readingFromFile("test");
//
//        for (Transaction transaction : transactionArrayList){
//            System.out.println("----------------------");
//            System.out.println("Data: " + transaction.getDateTransaction());
//            System.out.println();
//            System.out.println("Wartość pozycji: " + transaction.getValueCurrency() + " " + transaction.getCodeCurrency());
//            System.out.println("Kurs 1 " + transaction.getCodeCurrency() + ": " + transaction.getValuePln() + " PLN");
//            System.out.println("Wartość pozycji po przeliczeniu : " + transaction.getResultTransaction() + " PLN");
//            System.out.println("Czy przeliczenie wykonano poprawnie: " + transaction.getIsDone());
//
//        }
//
//        ArrayList<Transaction> transactionsAfterConvert = calculateTransaction.TransactionList(transactionArrayList);
//
//        System.out.println("Po wykonaniu obliczeń");
//        for (Transaction transaction : transactionsAfterConvert){
//            System.out.println("Data: " + transaction.getDateTransaction());
//            System.out.println();
//            System.out.println("Wartość pozycji: " + transaction.getValueCurrency() + " " + transaction.getCodeCurrency());
//            System.out.println("Kurs 1 " + transaction.getCodeCurrency() + ": " + transaction.getValuePln() + " PLN");
//            System.out.println("Wartość pozycji po przeliczeniu : " + transaction.getResultTransaction() + " PLN");
//            System.out.println("Czy przeliczenie wykonano poprawnie: " + transaction.getIsDone());
//        }
//
//        double precentResult = calculateTransaction.percentageResult(transactionsAfterConvert);
//        System.out.println("Udało się przeliczyć " + precentResult + "% transakcji");






    }
    }


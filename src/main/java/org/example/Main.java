package org.example;


import api.CurrencyDownloadApi;
import logic.JsonMapper;
import model.Currency;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        CurrencyDownloadApi currencyDownloadApi = new CurrencyDownloadApi();
//        String result = currencyDownloadApi.getCurrencyExchangeRate("usd", "2023-11-11");
//
//        JsonMapper jsonMapper = new JsonMapper();
//        Currency currency = jsonMapper.jsonMapToCurrency(result);
//
//        String data = currency.getDate().toString();
//        System.out.println(data);

        File file = new File("test.csv");

        Path plik = Paths.get("test.csv");
        ArrayList<String> odczyt = new ArrayList();
        try {
            odczyt = (ArrayList<String>) Files.readAllLines(plik);
            for (String czytaj : odczyt){
                System.out.println(czytaj);
                String[] liniaDaneString = czytaj.split(",");
                for(String tekst : liniaDaneString){
                    System.out.println(tekst);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    }


package org.example;


import api.CurrencyDownloadApi;
import model.Currency;

public class Main {
    public static void main(String[] args) {
        CurrencyDownloadApi api = new CurrencyDownloadApi();
        Currency currency = new Currency();
//        System.out.println(api.getCurrency("usd", "2023-10-31"));
//        api.getCurrency("usd", "2023-09-29");
//        System.out.println(api.getCurrencyAcctualCourse("usd"));

        String result = "{\"table\":\"A\",\"currency\":\"dolar amerykański\",\"code\":\"USD\",\"rates\":[{\"no\":\"211/A/NBP/2023\",\"effectiveDate\":\"2023-10-31\",\"mid\":4.1684}]}";

        String result1 = api.getCurrency("usd","2023-11-03");
        System.out.println(result1);
    }
    }


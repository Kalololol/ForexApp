package org.example;


import api.CurrencyDownloadApi;
import logic.JsonMapper;
import model.Currency;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        CurrencyDownloadApi api = new CurrencyDownloadApi();
       // Currency currency = new Currency(new Date(2023, 11, 2), "usd", 4.3212);


      // System.out.println(api.getCurrencyExchangeRate("ussd", "2023-10-31"));
       // System.out.println(api.getCurrencyAcctualCourse("usd"));

       // String result = "{\"table\":\"A\",\"currency\":\"dolar amerykański\",\"code\":\"USD\",\"rates\":[{\"no\":\"211/A/NBP/2023\",\"effectiveDate\":\"2023-10-31\",\"mid\":4.1684}]}";

//        String result1 = api.getCurrencyExchangeRate("eur","2023-111-03");
//        System.out.println(result1);

     //   String test = api.getCurrencyExchangeRate("usd", "2023-10-31");
        JsonMapper jsonMapper = new JsonMapper();
        String jsonResult = "{\"table\":\"A\",\"currency\":\"dolar ameryka�ski\",\"code\":\"USD\",\"rates\":[{\"no\":\"211/A/NBP/2023\",\"effectiveDate\":\"2023-11-02\",\"mid\":4.1963}]}";

        Currency currency = jsonMapper.jsonMapToCurrency(jsonResult);
        System.out.println(currency.getDate());
        System.out.println();
        String result = jsonMapper.currencyMapToJson(currency);
        System.out.println(result);
    }
    }


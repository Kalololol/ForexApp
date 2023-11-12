package org.example;


import api.CurrencyDownloadApi;
import logic.JsonMapper;
import model.Currency;

public class Main {
    public static void main(String[] args) {
        CurrencyDownloadApi currencyDownloadApi = new CurrencyDownloadApi();
        String result = currencyDownloadApi.getCurrencyExchangeRate("usd", "2023-11-110");
        System.out.println(result);

        Currency currency = null;
        JsonMapper jsonMapper = new JsonMapper();

        System.out.println(jsonMapper.currencyMapToJson(currency));





    }
    }


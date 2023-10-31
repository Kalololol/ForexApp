package org.example;

import api.Currency;
import api.CurrencyDownloadApi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CurrencyDownloadApi api = new CurrencyDownloadApi();
        Currency currency = new Currency();
        System.out.println(api.getCurrency("usd", "2023-10-31"));
        api.getCurrency("usd", "2023-09-29");
        System.out.println(api.getCurrencyAcctualCourse("usd"));
        }
    }


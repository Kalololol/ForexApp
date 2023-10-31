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
        api.getCurrency("usd", "2023-10-01");
        api.getCurrency("usd", "2023-09-29");
        api.getCurrencyAcctualCourse("usd");
        }
    }


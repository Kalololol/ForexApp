package logic;

import api.CurrencyDownloadApi;
import model.Currency;
import model.Transaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CalculateTransaction {
    //Istnieje możliwość zapisania transakcji poprzez podanie kwoty transakcji, przesłanej waluty i daty do pliku poprzez konsolę;
    private CurrencyDownloadApi currencyDownloadApi = new CurrencyDownloadApi();
    private JsonMapper jsonMapper = new JsonMapper();
    public Transaction Calculate(double valueTransaction, String codeCurrency, String dateTransaction){

        Double valuePLN = CalculateValue(codeCurrency, dateTransaction);

        double convertTransaction = valueTransaction * valuePLN;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateTransaction, formatter);

        Transaction transaction = new Transaction(date, codeCurrency, valueTransaction, valuePLN, convertTransaction);

        return transaction;
    }
    public double CalculateValue(String codeCurrency, String dateTransaction){
        String downloadCourse = currencyDownloadApi.getCurrencyExchangeRate(codeCurrency, dateTransaction);
        Currency currency = jsonMapper.jsonMapToCurrency(downloadCourse);
        return currency.getMid();
    }
}

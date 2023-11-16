package logic;

import api.CurrencyDownloadApi;
import model.Currency;
import model.Transaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CalculateTransaction {
    private CurrencyDownloadApi currencyDownloadApi = new CurrencyDownloadApi();
    private JsonMapper jsonMapper = new JsonMapper();
    public Transaction manualCalculate(double valueTransaction, String codeCurrency, String dateTransaction){

        Double valuePLN = CalculateValue(codeCurrency, dateTransaction);

        double convertTransaction = valueTransaction * valuePLN;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateTransaction, formatter);

        Transaction transaction = new Transaction(date, codeCurrency, valueTransaction, valuePLN, convertTransaction);

        return transaction;
    }
        public Transaction automaticCalculate(Transaction transaction){

        String date = transaction.getDateTransaction().toString();
        Double valuePLN = CalculateValue(transaction.getCodeCurrency(), date);

        double convertTransaction = transaction.getValueCurrency() * valuePLN;

        transaction.setValuePln(valuePLN);
        transaction.setResultTransaction(convertTransaction);

        return transaction;
    }

    public ArrayList<Transaction> TransactionList(ArrayList<Transaction> transactionArrayList){
        ArrayList<Transaction> result = new ArrayList<>();
        for(Transaction transaction : transactionArrayList){
            result.add(automaticCalculate(transaction));
            //jesli zwróci null to zapisać obiekt do osobnej listy
            // moze dodac nowy parametr w modelu aby finalna liste potem dzielic na dwie
            // ta z dobrymi wynikami i blednymi
            // potem obliczymy zakress % 
        }
        return result;
    }

    public double CalculateValue(String codeCurrency, String dateTransaction){
        String downloadCourse = currencyDownloadApi.getCurrencyExchangeRate(codeCurrency, dateTransaction);
        Currency currency = jsonMapper.jsonMapToCurrency(downloadCourse);
        return currency.getMid();
    }
}

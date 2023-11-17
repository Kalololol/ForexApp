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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateTransaction, formatter);

        Double valuePLN = CalculateValue(codeCurrency, dateTransaction);

        if(valuePLN == null) {
            Transaction transaction =  new Transaction(date, codeCurrency, valueTransaction, 0.00, 0.00, false);;
            return transaction;
        }

        double convertTransaction = valueTransaction * valuePLN;
        Transaction transaction = new Transaction(date, codeCurrency, valueTransaction, valuePLN, convertTransaction, true);

        return transaction;
    }

    public ArrayList<Transaction> TransactionList(ArrayList<Transaction> transactionArrayList){
        ArrayList<Transaction> result = new ArrayList<>();
        for(Transaction transaction : transactionArrayList){
            result.add(automaticCalculate(transaction));
        }
        return result;
    }
    public Transaction automaticCalculate(Transaction transaction){

        String date = transaction.getDateTransaction().toString();
        Double valuePLN = CalculateValue(transaction.getCodeCurrency(), date);

        if(valuePLN == null) {
            transaction.setValuePln(0.00);
            transaction.setResultTransaction(0.00);
            transaction.setDone(false);
            return transaction;
        }

        double convertTransaction = transaction.getValueCurrency() * valuePLN;
        transaction.setValuePln(valuePLN);
        transaction.setResultTransaction(convertTransaction);
        transaction.setDone(true);

        return transaction;
    }

    public double CalculateValue(String codeCurrency, String dateTransaction){
        String downloadCourse = currencyDownloadApi.getCurrencyExchangeRate(codeCurrency, dateTransaction);
        Currency currency = jsonMapper.jsonMapToCurrency(downloadCourse);
        return currency.getMid();
    }
    public double percentageResult(ArrayList<Transaction> transactionArrayList){
        int sum = 0;
        double average = 0.00;
        for (Transaction transaction : transactionArrayList){
            if(transaction.getIsDone() == true){
                sum++;
            }
        }
        average = sum / transactionArrayList.size() * 100;

        return average;
    }
}

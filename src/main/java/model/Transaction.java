package model;

import java.time.LocalDate;

public class Transaction {
    private LocalDate dateTransaction;
    private String codeCurrency;
    private double valueCurrency;
    private double valuePln;

    public Transaction(LocalDate dateTransaction, String codeCurrency, double valueCurrency) {
        this.dateTransaction = dateTransaction;
        this.codeCurrency = codeCurrency;
        this.valueCurrency = valueCurrency;
    }

    public void setResultTransaction(double resultTransaction) {
        this.resultTransaction = resultTransaction;
    }

    private double resultTransaction;

    public Transaction(LocalDate dateTransaction, String codeCurrency, double valueCurrency, double valuePln, double resultTransaction) {
        this.dateTransaction = dateTransaction;
        this.codeCurrency = codeCurrency;
        this.valueCurrency = valueCurrency;
        this.valuePln = valuePln;
        this.resultTransaction = resultTransaction;
    }


    public LocalDate getDateTransaction() {
        return dateTransaction;
    }

    public String getCodeCurrency() {
        return codeCurrency;
    }

    public double getValueCurrency() {
        return valueCurrency;
    }

    public double getValuePln() {
        return valuePln;
    }

    public double getResultTransaction() {
        return resultTransaction;
    }
}


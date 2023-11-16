package model;

import java.time.LocalDate;

public class TransactionDTO {
    private String dateTransaction;
    private String codeCurrency;
    private String valueCurrency;


    public TransactionDTO(String dateTransaction, String codeCurrency, String valueCurrency) {
        this.dateTransaction = dateTransaction;
        this.codeCurrency = codeCurrency;
        this.valueCurrency = valueCurrency;
    }
}

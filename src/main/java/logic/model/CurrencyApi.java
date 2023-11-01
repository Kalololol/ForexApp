package logic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CurrencyApi {
    @JsonProperty("table")
    private String table;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("code")
    private String code;
    private List<RateApi> rateApis;

    public CurrencyApi(){}
    public CurrencyApi(String table, String currency, String code, List<RateApi> rateApis) {
        this.table = table;
        this.currency = currency;
        this.code = code;
        this.rateApis = rateApis;
    }
    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<RateApi> getRates() {
        return rateApis;
    }

    public void setRates(List<RateApi> rateApis) {
        this.rateApis = rateApis;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "table='" + table + '\'' +
                ", currency='" + currency + '\'' +
                ", code='" + code + '\'' +
                ", rates=" + rateApis +
                '}';
    }
}

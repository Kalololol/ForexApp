package logic;

import logic.model.CurrencyApi;
import logic.model.RateApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Currency;

import java.util.List;

public class JsonMapper {
    private ObjectMapper objectMapper = new ObjectMapper();

    public Currency mapToCurrency(String objectJson){
        CurrencyApi currencyApi;
        Currency result = new Currency();
        try {
            currencyApi = objectMapper.readValue(objectJson, CurrencyApi.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        List<RateApi> rateApiList = currencyApi.getRates();
        RateApi rateApi = rateApiList.get(0);

        result.setCode(currencyApi.getCode());
        result.setDate(rateApi.getEffectiveDate());
        result.setMid(rateApi.getMid());

        return result;
    }
}


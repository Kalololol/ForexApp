import api.CurrencyDownloadApi;
import logic.JsonMapper;
import model.Currency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.function.BooleanSupplier;

public class CurrencyTest {
    private CurrencyDownloadApi currencyDownloadApi = new CurrencyDownloadApi();
    private JsonMapper jsonMapper = new JsonMapper();

    String jsonCourseUsd = currencyDownloadApi.getCurrency("usd","2023-11-03");
    String jsonResult = "{\"table\":\"A\",\"currency\":\"dolar ameryka�ski\",\"code\":\"USD\",\"rates\":[{\"no\":\"211/A/NBP/2023\",\"effectiveDate\":\"2023-11-02\",\"mid\":4.1963}]}";


    Currency currencyTest = new Currency(new Date(2023-10-31), "usd", 4.1963);
    @Test
    public void jsonMapperTest(){
        Assertions.assertEquals(jsonMapper.mapToCurrency(jsonResult), currencyTest);
    }
}


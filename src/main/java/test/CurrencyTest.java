import api.CurrencyDownloadApi;
import logic.JsonMapper;
import model.Currency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class CurrencyTest {
    private CurrencyDownloadApi currencyDownloadApi = new CurrencyDownloadApi();
    private JsonMapper jsonMapper = new JsonMapper();

    @Test
    public void jsonMapToCurrencyTest(){
        String jsonResult = "{\"table\":\"A\",\"currency\":\"dolar ameryka�ski\",\"code\":\"USD\",\"rates\":[{\"no\":\"211/A/NBP/2023\",\"effectiveDate\":\"2023-11-02\",\"mid\":4.1963}]}";
        Currency jsonResultMapToCurrency = jsonMapper.jsonMapToCurrency(jsonResult);

        LocalDate date = LocalDate.of(2023, 11, 2);
        Currency currencyTest = new Currency(date, "usd", 4.1963);

        Assertions.assertEquals(jsonResultMapToCurrency.getCode().toLowerCase(), currencyTest.getCode());
        Assertions.assertEquals(jsonResultMapToCurrency.getDate(), currencyTest.getDate());
        Assertions.assertEquals(jsonResultMapToCurrency.getMid(), currencyTest.getMid());
    }
    
}


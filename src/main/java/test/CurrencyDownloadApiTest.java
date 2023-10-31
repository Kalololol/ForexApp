import api.CurrencyDownloadApi;
import api.USDExchangeRateToPLN;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class CurrencyDownloadApiTest {
    private CurrencyDownloadApi currencyDownloadApi = new CurrencyDownloadApi();
    private USDExchangeRateToPLN usdExchangeRateToPLN = new USDExchangeRateToPLN();

    @Test
    public void getCurrencyTest(){
        double test = currencyDownloadApi.getCurrency("usd", "2023-10-31");
        double result = 4.1684;

        Assertions.assertEquals(result, test );
    }
}


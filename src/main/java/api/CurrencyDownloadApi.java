package api;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CurrencyDownloadApi {
     private final HttpClient client = HttpClient.newBuilder().build();
     ObjectMapper objectMapper = new ObjectMapper();

     public double getCurrency(String code, String courseDay) {
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
          try {
               Date date = dateFormat.parse(courseDay);
               return courseDownload(code, date);
          } catch (ParseException e) {
               e.printStackTrace();
          }
          return 0;
     }
     public double getCurrencyAcctualCourse(String code) {
          Date todayDay = new Date();
          return courseDownload(code, todayDay);
     }
     public double courseDownload(String code, Date day){
          String result = "";
          USDExchangeRateToPLN usdExchangeRateToPLN = new USDExchangeRateToPLN();
          usdExchangeRateToPLN.setCourseDate(day);

          try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String formattedDate = dateFormat.format(day);
                    HttpResponse<String> response;

                    do {
                         URI uri = URI.create(("http://api.nbp.pl/api/exchangerates/rates/a/" + code + "/" + formattedDate));
                         HttpRequest request = HttpRequest.newBuilder()
                                 .uri(uri)
                                 .GET()
                                 .build();
                         response = client.send(request, HttpResponse.BodyHandlers.ofString());
                         if(response.statusCode() == 404){
                              Calendar calendar = Calendar.getInstance();
                              calendar.setTime(day);
                              calendar.add(Calendar.DAY_OF_YEAR, -1);
                              day = calendar.getTime();
                              formattedDate = dateFormat.format(day);
                         }
                    }while (response.statusCode() == 404);

                    result = response.body();

                    Currency currency = objectMapper.readValue(result, Currency.class);
                    List<Rate> rateList = currency.getRates();
                    Rate rate = rateList.get(0);
//                    usdExchangeRateToPLN.setCode(currency.getCode());
//                    usdExchangeRateToPLN.setMidValue(rate.getMid());
                    return rate.getMid();

               } catch (IOException e) {
                    throw new RuntimeException(e);
               } catch (InterruptedException e) {
                    throw new RuntimeException(e);
               }
     }
}

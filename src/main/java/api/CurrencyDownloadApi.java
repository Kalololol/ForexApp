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

public class CurrencyDownloadApi {
     private final HttpClient client = HttpClient.newBuilder().build();
     ObjectMapper objectMapper = new ObjectMapper();

     public String getCurrency(String code, String courseDay) {
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         Date date = new Date();
          try {
               date = dateFormat.parse(courseDay);
          } catch (ParseException e) {
               e.printStackTrace();
          }
          return courseDownload(code, date);
     }
     public String getCurrencyAcctualCourse(String code) {
          Date todayDay = new Date();
          return courseDownload(code, todayDay);
     }
     public String courseDownload(String code, Date day){
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

                    return response.body();

               } catch (IOException e) {
                    throw new RuntimeException(e);
               } catch (InterruptedException e) {
                    throw new RuntimeException(e);
               }
     }
}

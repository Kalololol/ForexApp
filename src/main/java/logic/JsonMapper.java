package logic;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import model.CurrencyDTO;
import model.RateDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Currency;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class JsonMapper {
    private final ObjectMapper objectMapper = new ObjectMapper();
    public Currency jsonMapToCurrency(String objectJson){

        try {
            CurrencyDTO currencyDTO = objectMapper.readValue(objectJson, CurrencyDTO.class);
            List<RateDTO> rateDTOList = currencyDTO.getRates();
            RateDTO rateDTO = rateDTOList.get(0);

//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            Date date = date = dateFormat.parse(rateDTO.getEffectiveDate());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(rateDTO.getEffectiveDate(), formatter);

            Currency result = new Currency(date, currencyDTO.getCode(), rateDTO.getMid());
            return result;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    public String currencyMapToJson (Currency currency){
        String result = "";
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
            objectMapper.setDateFormat(df);
            return objectMapper.writeValueAsString(currency);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}


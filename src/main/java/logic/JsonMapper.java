package logic;

import model.CurrencyDTO;
import model.RateDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.Currency;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class JsonMapper {
    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    public Currency jsonMapToCurrency(String objectJson){
        try {
            if (objectJson == null) {
                return null;
            }
            CurrencyDTO currencyDTO = objectMapper.readValue(objectJson, CurrencyDTO.class);
            List<RateDTO> rateDTOList = currencyDTO.getRates();
            RateDTO rateDTO = rateDTOList.get(0);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(rateDTO.getEffectiveDate(), formatter);

            Currency result = new Currency(date, currencyDTO.getCode(), rateDTO.getMid());
            return result;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
    public String currencyMapToJson (Currency currency){
        try {
//            if (currency == null){
//                return null;
//            }
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
            objectMapper.setDateFormat(df);
            return objectMapper.writeValueAsString(currency);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}


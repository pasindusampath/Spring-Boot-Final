package lk.ijse.gdse63.hotel_micro_service.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lk.ijse.gdse63.hotel_micro_service.dto.PricesDTO;
import org.springframework.core.convert.converter.Converter;
import java.util.ArrayList;

public class StringToPricesListConverter implements Converter<String, ArrayList<PricesDTO>> {

    @Override
    public ArrayList<PricesDTO> convert(String source) {
        return new Gson().fromJson(source, new TypeToken<ArrayList<PricesDTO>>() {
        });
    }

}
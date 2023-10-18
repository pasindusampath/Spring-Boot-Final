package lk.ijse.gdse63.springfinal.util;


import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.util.ArrayList;

public class StringToLocalDateConverter implements Converter<String, LocalDate> {


    @Override
    public LocalDate convert(String source) {
        return LocalDate.parse(source);
    }
}
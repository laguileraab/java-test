package com.truedebug.Utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Compare {
    public LocalDate compare(){
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String storedDate = simpleDateFormat.format(person.getDate());
        LocalDate date = LocalDate.parse(storedDate);
        return date;
    }
}

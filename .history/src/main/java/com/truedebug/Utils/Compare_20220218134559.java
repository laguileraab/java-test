package com.truedebug.Utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Compare {
    public LocalDate compareDate(Date datestored){
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String storedDate = simpleDateFormat.format(dateStored);
        LocalDate date = LocalDate.parse(storedDate);
        return date;
    }
}

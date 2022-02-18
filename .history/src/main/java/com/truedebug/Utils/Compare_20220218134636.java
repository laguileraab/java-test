package com.truedebug.Utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Compare {
    
    static public LocalDate compareDate(Date dateStored){
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String storedDate = simpleDateFormat.format(dateStored);
        LocalDate date = LocalDate.parse(storedDate);
        return date;
    }
}

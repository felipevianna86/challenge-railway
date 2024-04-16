package com.example.challengerailway;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static Integer getYearByDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }
}

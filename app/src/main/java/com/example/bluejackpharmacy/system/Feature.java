package com.example.bluejackpharmacy.system;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class Feature {

    public static String getTimeGreetings() {
        DateFormat dateFormat = new SimpleDateFormat("HH");
        Calendar cal = Calendar.getInstance();
        int hour = Integer.parseInt(dateFormat.format(cal.getTime()));

        if(hour <= 10){
            return "Good Morning";
        }else if(hour <= 14){
            return "Good Day";
        }else if(hour <= 18){
            return "Good Afternoon";
        } else {
            return "Good Evening";
        }
    }

    public static String getCurrecntyFormat(double value) {
        NumberFormat IDR = NumberFormat.getNumberInstance(new Locale("in", "ID"));
        return "IDR " + IDR.format(value);
    }

}

package com.example.bluejackpharmacy.system;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;

public class Feature {

    public static String getTimeGreetings() {
        int hour = Calendar.getInstance().HOUR_OF_DAY;

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

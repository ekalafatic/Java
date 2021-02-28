package com.ek.hackerRank;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class javaDateTime {
    private static String day;
    private static String stringDay(int value) {
        switch (value) {
            case 1:
                day = "Sunday";
                break;
            case 2:
                day = "Monday";
                break;
            case 3:
                day = "Tuesday";
                break;
            case 4:
                day = "Wednesday";
                break;
            case 5:
                day = "Thursday";
                break;
            case 6:
                day = "Friday";
                break;
            case 7:
                day = "Saturday";
                break;
        }
        return day;
    }
    public static void main(String[] args){
        Calendar fecha1 = Calendar.getInstance();
        // OJO!!!! es el nº de mes +1
        fecha1.set(2015, 6, 8);

        Calendar fecha2 = new GregorianCalendar(2016,7,5);

        System.out.println(fecha1.getTime());
        System.out.println(fecha2.getTime());
        System.out.println(fecha1.get(Calendar.DAY_OF_WEEK));
        System.out.println(fecha2.get(Calendar.DAY_OF_WEEK));
        System.out.println(stringDay(fecha1.get(Calendar.DAY_OF_WEEK)));
        System.out.println(stringDay(fecha2.get(Calendar.DAY_OF_WEEK)));
    }
}

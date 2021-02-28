package com.ek.hackerRank;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */
    private static String stringDay;

    public static String findDay(int month, int day, int year) {
        Calendar date = Calendar.getInstance();
        date.set(year,month-1,day);
        System.out.println(date.getTime());

        switch (date.get(Calendar.DAY_OF_WEEK)){
            case 1:
                stringDay = "Sunday";
                break;
            case 2:
                stringDay = "Monday";
                break;
            case 3:
                stringDay = "Tuesday";
                break;
            case 4:
                stringDay = "Wednesday";
                break;
            case 5:
                stringDay = "Thursday";
                break;
            case 6:
                stringDay = "Friday";
                break;
            case 7:
                stringDay = "Saturday";
                break;
        }
        return stringDay;
    }
}

public class javaDateTimeSol extends Result{
    public static void main(String[] args) throws IOException {
        System.out.println(findDay(8,5,2015));
    }
}


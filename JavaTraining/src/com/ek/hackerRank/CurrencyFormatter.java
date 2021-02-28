package com.ek.hackerRank;

//https://www.hackerrank.com/challenges/java-currency-formatter/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
import java.util.*;
import java.text.*;


public class CurrencyFormatter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        // US format
        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("US: " + n.format(payment));

        // Indian format
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        String moneyString = formatter.format(payment);
        System.out.println("Indian: " + moneyString);

        // China format
        n = NumberFormat.getCurrencyInstance(Locale.CHINA);
        System.out.println("China: " + n.format(payment));

        // France format
        n = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        System.out.println("France: " + n.format(payment));

        /*
        NumberFormat nF = NumberFormat.getCurrencyInstance();
        String money = nF.getCurrency().getDisplayName();
        System.out.println(money);

        // US money setted
        nF.setCurrency(Currency.getInstance(Locale.US));
        money = nF.getCurrency().getDisplayName();
        System.out.println(money);
        */

//        System.out.println("US: " + us);
//        System.out.println("India: " + india);
//        System.out.println("China: " + china);
//        System.out.println("France: " + france);
    }
}

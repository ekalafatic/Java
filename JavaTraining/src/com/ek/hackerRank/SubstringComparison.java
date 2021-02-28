package com.ek.hackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-string-compare/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen

public class SubstringComparison {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        ArrayList<String> substringList = new ArrayList<String>();
        int endPoint = k;

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        // Take the substrings
        for (int i = 0; i<=s.length()-k; i++){
            substringList.add(s.substring(i,endPoint));
            endPoint += 1;
//            System.out.println(substringList);
        }

        // Max substring
        largest = Collections.max(substringList); // Also can use compareTo

        // Min substring
        smallest = Collections.min(substringList);

        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}

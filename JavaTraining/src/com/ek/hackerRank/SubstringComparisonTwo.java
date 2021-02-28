package com.ek.hackerRank;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-string-compare/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen

/* Alternativa porque al querido hacker rank no le gusta que use listas*/

public class SubstringComparisonTwo {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0,k);
        String largest = s.substring(0,k);
        String substring;
        int endPoint = k;

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        // Take the substrings
        for (int i = 0; i<=s.length()-k; i++){
            substring = s.substring(i,endPoint);
            endPoint += 1;

            if (smallest.compareTo(substring) > 0){
                // Si alfabéticamente está antes (mayor a 0), es menor
                smallest = substring;
            }
            if(largest.compareTo(substring) < 0){
                // Si alfabéticamente substring está después
                largest = substring;
            }
        }

        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}

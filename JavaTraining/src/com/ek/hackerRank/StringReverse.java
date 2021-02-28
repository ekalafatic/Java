package com.ek.hackerRank;
import java.util.*;

//https://www.hackerrank.com/challenges/java-string-reverse/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen

public class StringReverse {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        StringBuilder A2 = new StringBuilder();
        A2.append(A);
        A2.reverse();
        String isPalindrome;

        if(A.compareTo(A2.toString()) == 0){
            isPalindrome = "Yes";
        } else {
            isPalindrome = "No";
        }

        System.out.println(isPalindrome);
    }
}

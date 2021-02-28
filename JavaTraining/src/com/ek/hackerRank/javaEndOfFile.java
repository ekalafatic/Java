package com.ek.hackerRank;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-end-of-file/problem

public class javaEndOfFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int line = 0;
        while(sc.hasNext()){
            System.out.println(++line + " " + sc.nextLine());
        }
    }
}

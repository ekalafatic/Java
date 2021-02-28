package com.ek.hackerRank;
import java.util.*;
//https://www.hackerrank.com/challenges/java-1d-array-introduction/problem

public class oneDArray {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        // Creo el nuevo arreglo
        int[] a = new int[n];
        int n2;
        for (int i = 0; i<a.length; i++){
            n2 = scan.nextInt();
            a[i]= n2;
        }
        scan.close();

        // Prints each sequential element in array a
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}

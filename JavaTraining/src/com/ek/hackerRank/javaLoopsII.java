package com.ek.hackerRank;
// https://www.hackerrank.com/challenges/java-loops/problem?h_r=next-challenge&h_v=zen

import java.util.Scanner;

public class javaLoopsII {
    public static void main(String []argh){
        int s;
        int pow;
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            s = a;
            // Recorre n (potencias)
            for(int h=0; h<n; h++){
                pow = ((int) Math.pow(2, h));
                s= s + pow*b;
                System.out.printf("%d ",s);
            }
            System.out.println();

        }
        in.close();
    }
}

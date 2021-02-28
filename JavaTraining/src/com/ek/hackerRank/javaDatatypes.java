package com.ek.hackerRank;


import java.util.Scanner;
import java.lang.*;

public class javaDatatypes{

    public static void main(String []argh){
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        long bitsInt = ((long) Math.pow(2, 31));
        long bitsLong = ((long) Math.pow(2, 63)); // notar que va a almacenar 2^63 - 1 ya que es el max de long

//        System.out.println("Number of one bits = " + Integer.bitCount(t));
        for(int i=0;i<t;i++)
        {
            try
            {
                long x=sc.nextLong();
                System.out.println(x+" can be fitted in:");
                if(x>=-128 && x<=127) System.out.println("* byte");
                if(x>=-32768 && x<=32767) System.out.println("* short");
                if(x>=-bitsInt && x<=bitsInt-1) System.out.println("* int");
                if(x>=-bitsLong-1 && x<=bitsLong) System.out.println("* long");
            }
            catch(Exception e)
            {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }

        }
    }
}

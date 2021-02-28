package com.ek.interviews;

import java.io.*;

import static java.util.stream.Collectors.joining;


//class Result {
//
//    public static void fizzBuzz(int n) {
//        // Write your code here
//
//        for(int i = 1; i<=n; i++){
//            if (i%3 == 0 && i%5 == 0){
//                System.out.println("FizzBuzz");
//            } else if(i%3 == 0 && i%5 != 0){
//                System.out.println("Fizz");
//            } else if(i%5 == 0 && i%3 != 0){
//                System.out.println("Buzz");
//            } else{
//                System.out.println(i);
//            }
//        }
//
//    }
//
//}

public class FizzBuzz {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

//        Result.fizzBuzz(n);

        bufferedReader.close();
    }
}
package com.ek.hackerRank;

import java.util.Scanner;

/*
*** Hacker rank problem ***

Input Format

Every line of input will contain a String followed by an integer.
Each String will have a maximum of  alphabetic characters, and each integer will be in the inclusive range from  to .

Output Format

In each line of output there should be two columns:
The first column contains the String and is left justified using exactly  characters.
The second column contains the integer, expressed in exactly  digits; if the original input has less than three digits,
you must pad your output's leading digits with zeroes.

Sample Input

java 100
cpp 65
python 50
Sample Output

================================
java           100
cpp            065
python         050
================================
Explanation
Each String is left-justified with trailing whitespace through the first 15 characters. The leading digit of the integer
is the 16th character, and each integer that was less than  digits now has leading zeroes.

*/
public class javaOutputFormatting {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // Caracteres hasta el primer número
        Integer spacesLength = -15;
        int twoFigures;
        int threeFigures;

        System.out.println("================================");
        for(int i=0;i<3;i++)
        {
            String s1=sc.next();
            int x=sc.nextInt();
            twoFigures = Integer.signum(x-10);
            threeFigures = Integer.signum(x-100);

            // The String part should have 15 characters
            System.out.printf("%"+ spacesLength.toString() +"s", s1);
            // Si le resto 100 a x y es negativo, son 2 cifras
            if(twoFigures == -1){
                System.out.printf("0"+"0"+"%d %n",x);
            }else if(threeFigures == -1){
                System.out.printf(0+"%d %n",x);
            }else {
                System.out.printf("%d %n",x);
            }
        }
        System.out.println("================================");
    }
}
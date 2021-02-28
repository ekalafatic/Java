package com.ek.hackerRank;
import java.util.Scanner;

public class Anagrams {

    static boolean isAnagram(String a, String b) {
        int aCounter;
        int bCounter;
        int aLength = 0;

        // Si no tienen el mismo tamaño no son anagramas
        if(a.length() != b.length()){
            return false;
        }

        // Supongo el mismo tamaño
        while(aLength != a.length()){
            aCounter = 0;
            bCounter = 0;
            char aChar;
            char aChari;
            char bChari;
            char aCharUpper;
            char aCharUpperi;
            char bCharUpperi;

            for (int i = 0; i<a.length(); i++){
                aChar = a.charAt(aLength);
                aChari = a.charAt(i);
                bChari = b.charAt(i);
                aCharUpper = Character.toUpperCase(aChar);
                aCharUpperi = Character.toUpperCase(aChari);
                bCharUpperi = Character.toUpperCase(bChari);


                if(aChar == aChari || aCharUpper == aCharUpperi){
                    aCounter++;
                }
                if(aChar == bChari || aCharUpper == bCharUpperi){
                    bCounter++;
                }
            }

            // Si no tienen la misma frecuencia
            if(aCounter != bCounter){
                break;
            }
            aLength++;
        }


        // Si se verificaron todos los char
        if(aLength == a.length()){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        String b = scan.nextLine();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}

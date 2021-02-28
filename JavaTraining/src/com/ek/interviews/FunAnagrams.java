package com.ek.interviews;

import java.util.*;

import static com.ek.interviews.Result.funWithAnagrams;
import static java.util.stream.Collectors.joining;


class Result {

    /*
     * Complete the 'funWithAnagrams' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY text as parameter.
     */
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

//    public static boolean haveNumber(String t){
//
//    }

    public static List<String> funWithAnagrams(List<String> text) {
        // Comparo cada palabra
        List<String> s = new ArrayList<String>();

        for (int i = 0; i<text.size()-1; i++){
            for (int j = i+1; j<text.size(); j++){
                if(isAnagram(text.get(i),text.get(j))){
                    s.add(text.get(j));
                }
            }
            System.out.println(i);
            System.out.println(s);
            for(int h = 0; h<s.size(); h++){
                System.out.println("text antes de borrar: " + text);
                text.remove(text.indexOf(s.get(h)));
                System.out.println("text despues de borrar: " + text);
            }
            s.clear();
        }


        Collections.sort(text);

        return text;
    }

}

public class FunAnagrams {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        List<String> t = new ArrayList<String>();
//        ArrayList<String> substringList = new ArrayList<String>();

        for (int i = 0; i<n; i++){
            t.add(sc.next());
        }
        System.out.println(funWithAnagrams(t));
    }
}
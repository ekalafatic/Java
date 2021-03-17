package com.ek.interviews;
// Download apache commons
//import org.apache.commons.lang3.StringUtils;
import java.text.Normalizer;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/** REPETICIÓN DE PALABRAS UTILIZANDO HASH TABLE **/

public class WordRepetition {

    public static String quitaDiacriticos(String s) {
        s = Normalizer.normalize(s, Normalizer.Form.NFD);
        s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return s;
    }

    public static Hashtable conteoPalabra(String phrase){
        Hashtable<String, Integer> dict = new Hashtable<>();
        int oldValue = 0;

        // Se divide en palabras en un arreglo y se quitan símbolos
        String[] words = phrase.split("[. , ' ' ? ´ !]+");

        for(int i = 0; i<words.length; i++){
            words[i] = quitaDiacriticos(words[i]).toLowerCase();
            if(dict.containsKey(words[i])){
                oldValue = dict.get(words[i].toString());
                oldValue++;
                dict.put(words[i].toString(), oldValue);
            }else{
                dict.put(words[i].toString(), 1);
            }
        }

        return dict;
    }


    public static void main(String[] args) {

        System.out.println(conteoPalabra("Hola, cómo estás? hola como ja"));

    }
}

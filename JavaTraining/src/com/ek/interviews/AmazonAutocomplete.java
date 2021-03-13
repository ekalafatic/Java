package com.ek.interviews;

import java.lang.reflect.Array;
import java.util.*;

public class AmazonAutocomplete {
    public static ArrayList<String> stringDivided(String s, int cwords){

        // cwords: cantidad de letras a dividir
        ArrayList<String> sList = new ArrayList<String>();

        if(s.isEmpty() || cwords < 1){
            throw new NullPointerException("String s or cwords shouldn't be empty");
        }

        int end = 0;

        for (int i = 0; i<s.length(); i++){
            end = i + cwords;
            sList.add(s.substring(i,end));
        }

        return sList;


    }

    public static List threeKeywordSuggestionsDict(int numreviews, List<String> repository, String customQuery){

        /// MEJORAR!

        List<String> cql = new ArrayList<String>();
        List<String> keywords = new ArrayList<String>();
        Hashtable<String, List<String>> dict = new Hashtable<>();
        List<String> value = new ArrayList<String>();
        int cQLength = customQuery.length();
        int i = 1;
        int mKeywordsSuggestion = 3;

        if(cQLength >= 2 ){
            while(i < cQLength){
                cql.add(customQuery.substring(0,i+1));
                i+=1;
            }

            Collections.sort(cql);
            Collections.sort(repository);


            for (String s : repository) {
                for(String scql : cql){
                    s = s.toLowerCase();
                    scql = scql.toLowerCase();
                    if(s.startsWith(scql)){
                        if(dict.containsKey(scql)){
                            value = new ArrayList<String>();
                            value = dict.get(scql);
                            value.add(s);
                            dict.put(scql,value);
                        }else{
                            value = new ArrayList<String>();
                            value.add(s);
                            dict.put(scql,value);
                        }
                    }
                }
            }

//             Obtención de valores
            for ( String key : dict.keySet() ) {
                System.out.println(dict.get(key));
            }

            System.out.println(dict);



        }

        return keywords;

        /// Simplest solution

        /// Do a unit test
    }

    public static List threeKeywordSuggestions(int numreviews, List<String> repository, String customQuery){
        List<String> currentKeywords = new ArrayList<String>();
        List<List<String>> keywords = new ArrayList<List<String>>();
        int cQLength = customQuery.length();
        int i = 1;
        String cqs = "";

        // repository string sorted
        Collections.sort(repository);

        System.out.println("customQuery:");
        // if customQuery have minimum 2 letters
        if(cQLength >= 2 ){
            while(i < cQLength){
                cqs = customQuery.substring(0,i+1);
                System.out.print(cqs+" ");
                i+=1;

                // Loop through repository with one part of customQuery
                for (String s : repository) {
                    s = s.toLowerCase();
                    cqs = cqs.toLowerCase();

                    if(currentKeywords.size() == 3){
                        break;
                    }

                    if (s.startsWith(cqs)) {
                        if (s.startsWith(cqs)) {
                            currentKeywords.add(s);
                        }
                    }
                }

                // Add the current keywords list to general keywords list
                keywords.add(currentKeywords);
                currentKeywords = new ArrayList<String>();
            }
        }
        System.out.println();
        return keywords;

    }

    public static void main(String[] args) {
        List<String> keywords = new ArrayList<String>();
        List<String> repository = new ArrayList<>(List.of("mobile", "mouse", "mooneypoo", "mousepad", "mountain", "morocco", "monitor"));
        int numreviews = repository.size();
        String customQuery = "mouse";

        keywords = threeKeywordSuggestions(numreviews, repository , customQuery);

        System.out.println(keywords);

    }

}


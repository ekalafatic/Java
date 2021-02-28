package com.ek.interviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LetraRepetida {

    // Complete the contarLetra function below.
    static String contarLetra(String cadena) {
        String salida;

        // Divido en letras y creo una lista
        ArrayList<String> substringList = new ArrayList<String>();
        ArrayList<Integer> frequency = new ArrayList<Integer>();
        int mayorFrecuencia;
        int indexMayorFrecuencia;
        char A;

        int endPoint = 1;

        for (int i = 0; i<=cadena.length()-1; i++){
            substringList.add(cadena.substring(i,endPoint));
            endPoint += 1;
        }

        for(int i = 0; i<cadena.length();i++){
            frequency.add(Collections.frequency(substringList,substringList.get(i)));
        }

        System.out.println(substringList);
        System.out.println(frequency);
        mayorFrecuencia = Collections.max(frequency);
        indexMayorFrecuencia = frequency.indexOf(mayorFrecuencia);

        salida = "La letra que más se repite es la " + substringList.get(indexMayorFrecuencia).toUpperCase() + " con " + mayorFrecuencia + " repeticiones";

        return salida;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.close();

        s = contarLetra(s);
        System.out.println(s);
    }
}

package com.ek.interviews;

import java.util.ArrayList;
import java.util.List;

/*
    Dado un array de enteros, retornar un nuevo array tal que cada elemento en el índice i del nuevo array sea el producto de todos los números en el array original exceptuando el elemento en la posición i

    Ejemplo 1: si el input es [1, 2, 3, 4, 5], el output debería ser [120, 60, 40, 30, 24].
    Ejemplo 2: Si el input es [3, 2, 1], el output debería ser [2, 3, 6].

*/

public class Hexacta {
    private ArrayList<Integer> a1 = new ArrayList<Integer>(List.of(1,2,3,4));

    public static ArrayList multiplication(ArrayList<Integer> a){
        ArrayList<Integer> a2 = new ArrayList<Integer>();
        int mult = 1;

        for(int i=0; i<a.size(); i++ ){
            mult = mult * a.get(i);
        }

        for(int j=0; j<a.size(); j++ ){
            a2.add(mult/a.get(j));
        }

        return a2;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>(List.of(1,2,3,4));

        a = multiplication(a);
        System.out.println(a);

    }
}

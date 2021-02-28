package com.ek.interviews;

// Detectar si los paréntesis, corchetes y llaves están bien cerrados
// Hacer con stack y hash table

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class OpenClosed {
    public static void main(String[] args) {
        /**  SOLUCIÓN CON PILA **/
/*        Stack<Character> stack = new Stack<Character>();
        String phrase = "({[()]}";

        System.out.println(stack);
        for (int i = 0; i<phrase.length(); i++){
            if(isOpen(phrase.charAt(i))){
                stack.push(phrase.charAt(i));
                System.out.println(phrase.charAt(i));
                System.out.println(i + ": " + stack);
            }else if(!stack.isEmpty()){
                stack.pop();
                System.out.println(i + ": " + stack);
            }
        }
        if(!stack.isEmpty()){
            System.err.println("Debes cerrar bien la oración");
        }*/

        /** Solución con contador (más eficiente) **/
        String phrase = "({[()]})}";
        int cont = 0;

        for (int i = 0; i<phrase.length(); i++){
            if(isOpen(phrase.charAt(i))){
                cont = cont +1;
            }else{
                cont = cont -1;
            }
        }
        if(cont !=0){
            System.err.println("Tienes una llave, corchete o paréntesis mal cerrado");
        }
    }

    private static boolean isOpen(Object peek) {
        List<String> elems = new ArrayList<>(List.of("{", "[", "("));
        if(peek != "" && elems.contains(peek.toString())){
            return true;
        }else {
            return false;
        }
    }
}

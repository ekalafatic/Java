package com.ek.interviews;

import java.text.Normalizer;
import java.util.*;

public class Methods {

    public static String limpiarString(String cadena) {
        String limpio =null;
        if (cadena !=null) {
            String valor = cadena;
            valor = valor.toUpperCase();
            // Normalizar texto para eliminar acentos, dieresis, cedillas y tildes
            limpio = Normalizer.normalize(valor, Normalizer.Form.NFD);
            // Quitar caracteres no ASCII excepto la enie, interrogacion que abre, exclamacion que abre, grados, U con dieresis.
            limpio = limpio.replaceAll("[^\\p{ASCII}(N\u0303)(n\u0303)(\u00A1)(\u00BF)(\u00B0)(U\u0308)(u\u0308)]", "");
            // Regresar a la forma compuesta, para poder comparar la enie con la tabla de valores
            limpio = Normalizer.normalize(limpio, Normalizer.Form.NFC);
            limpio = limpio.toLowerCase(Locale.ROOT);
        }
        return limpio;
    }

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

        /** Lectura. Recordar nextLine en Strings **/
        /*
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int k = scan.nextInt();
        scan.close();
         */

        String phrase = "Hola, cómo estás";
        String word = "Hola";
        String word2 = "cómo";
        String manana = "mañana";
        int number = 2;
        boolean b;


          /*******************/
         /***** Strings *****/
        /*******************/

        /** Comparación de strings **/

        b = word2.equals("cómo"); // true

        /** Divisón de palabras **/
        // https://www.geeksforgeeks.org/split-string-java-examples/

        // Crea un vector con cada palabra de la frase y quita los espacios
        String[] arr = phrase.split(" ");

        // Crea un vector con cada palabra de la frase y quita espacios, comas y puntos
        String[] words = phrase.split("\\P{L}+");

        // Otra forma es poner en un vector todo lo que queremos excluir
        String str = "word1, word2 word3@word4?word5.word6";
        String[] words2 = str.split("[. , ' ? ´ @ !]+"); // word1 word2 word3 word4 word5 word6
        for(int i = 0; i<words2.length; i++){
            System.out.println(words2[i]);
        }

        /** Limpieza de strings **/
        // Quita acentos
        String wordSinD = quitaDiacriticos(word2); // como

        // Reemplaza lo de la izquierda por lo de la derecha, si pongo ^ adelante
        word = "mañana";
        word = word.replaceAll("[ñ]", ""); // maana



          /*********************/
         /***** HashTable *****/
        /*********************/

        // https://www.geeksforgeeks.org/hashtable-in-java/

        // Se define el tipo <key,valor>
        Hashtable<String, Integer> hasht = new Hashtable<>();

        // Ingreso de valor
        hasht.put("key1",1);

        // Obtención de valor
        hasht.get("key1"); //1

        // Verificar contención de clave
        hasht.containsKey("key1"); //true

        // Obtención de primera key
        hasht.keySet().toArray()[0].toString();

        // Obtención de todas las key
        for ( String key : hasht.keySet() ) {
            key.toString();
        }


        // Conteo de palabras con tabla hash
        System.out.println(conteoPalabra("Hola, cómo estás? hola como va"));



          /*****************/
         /***** STACK *****/
        /*****************/
//        https://www.geeksforgeeks.org/stack-class-in-java/

        // Default initialization of Stack, puede tener cualquier tipo
        Stack stack = new Stack();

        //Stack sólo de String
        Stack<String> stack2 = new Stack<String>();

        // pushing the elements
        stack.push(4);
        stack.push("Hola");
        stack.push("geek");
        
        // Top element
        stack.peek();

        // Quitar elemento top
        stack.pop();

        // True si es vacío
        stack.empty();

        // Si un el stack contiene cierto elemento, si lo encuentra devuelve la posición
        stack.search("hola");


          /******************/
         /***** LISTAS *****/
        /******************/
//        https://www.geeksforgeeks.org/list-interface-java-examples/
        // Lista con elementos iniciados
        List<String> elems = new ArrayList<>(List.of("{", "[", "("));

        // Java menor a 9
        List<String> strings = new ArrayList<>(
                Arrays.asList("Hello", "world")
        );

          /******************/
         /**** VECTORES ****/
        /******************/

          /****************/
         /**** ARRAYS ****/
        /****************/
//        http://www.manualweb.net/java/arrays-java/#:~:text=Un%20array%20Java%20es%20una,puede%20producirse%20en%20otros%20lenguajes.
        // Los array en Java son tanto vectores matemáticos como matrices, pero no tienen muchos métodos, evitar usarlos

        // Array de 5 elementos (vector).
        char array[] = {'a','b','c','d','e'};

        // Array de 4x4 elementos (matriz).
        int array2[][] = { {1,2,3,4}, {5,6,7,8}};

    }
}

package com.ek.interviews;

import javax.swing.*;
import java.io.IOException;
import java.text.Normalizer;
import java.util.*;
import java.util.function.Predicate;

public class Methods {

    public static ArrayList<String> stringDivided(String s, int cwords){

        // cwords: cantidad de letras a dividir
        ArrayList<String> sList = new ArrayList<String>();

        if(s.isEmpty() || cwords < 1){
//            JOptionPane.showMessageDialog (null, "String s or cwords shouldn't be empty", "stringDivided error", JOptionPane.ERROR_MESSAGE);
            throw new NullPointerException("String s or cwords shouldn't be empty");
        }

        int end = 0;

        for (int i = 0; i<s.length(); i++){
            end = i + cwords;
            sList.add(s.substring(i,end));
        }

        return sList;
    }

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

        // Extrae una parte del string pasándo como parámetro un punto de inicio y final
//        word.substring(i,endPoint);

        System.out.println("Word: " + word);
        System.out.println("Tamaño de word: " + word.length());

        ArrayList<String> slist = new ArrayList<String>();

        slist = stringDivided(word , 0);

        System.out.println("Salida stringDivided: " + slist);

        word = word.toLowerCase();


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

        // Obtención de valores
        for ( String key : hasht.keySet() ) {
            hasht.get(key);
        }



        // Conteo de palabras con tabla hash
        System.out.println(conteoPalabra("Hola, cómo estás? hola como va"));



          /*****************/
         /***** STACK *****/
        /*****************/
//        https://www.geeksforgeeks.org/stack-class-in-java/
//        Estructuras tipo LIFO

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

        Iterator iteratorStack = stack.iterator();
        System.out.println("Iterando Stack");
        while (iteratorStack.hasNext()) {
            System.out.println(iteratorStack.next() + " ");
        }


        /*************************/
         /***** COLAS (QUEUE) *****/
        /*************************/
//        ESTRUCTURA TIPO FIFO
//        https://www.geeksforgeeks.org/queue-data-structure/
        Queue<Object> cola = new LinkedList<>();

        // Se agregan elementos
        cola.add("Hola");
        cola.add(2);
        cola.add("jaja");
        cola.add(5.4);
        System.out.println("COLA: " + cola);

        // Devuelve el head de la cola (primer elemento), el q se va a eliminar
        cola.peek();

        // Remueve el head de la cola y devuelve true si se removió correctamente.
        // También remueve un objeto específico (aunque se pierde el sentido de la cola)
        cola.remove();

        // Remueve el objeto head de la cola y lo devuelve
        Object removido = cola.poll();

        // Devuelve true si la cola contiene el objeto
        cola.contains("hola");

        cola.isEmpty();

        // Remueve todo
        cola.clear();

        // Añadir lista a cola
        List<Object> l = new LinkedList<>();
        l.add("naranja");
        l.add("pera");
        cola.addAll(l);

        // Ver si contiene toda una lista
        cola.containsAll(l); // true

        // Remueve todo un grupo de objetos
        cola.removeAll(l);

        // Comparación de colas
        cola.addAll(l);
        Queue<Object> cola2 = new LinkedList<>();
        cola2.addAll(l);
        cola.equals(cola2); // true

        // If directo en cola (no se cómo hacer la comparación con Objects)
        Queue<Integer> cola3 = new LinkedList<>();
        cola3.add(1);
        cola3.add(9);
        cola3.add(11);
        Predicate<Integer> pr= a->(a>10);
        cola3.removeIf(pr); // [1, 9]

        // OTROS
        // Similar a peek, pero imprime "NoSuchElementException" cuando la cola está vacía
        cola.element();
        // Igual a add() pero en vez de lanzar una excepción cuando la cola está llena, devuelve falso
        cola.offer("algo");

        Iterator iteratorCola = cola.iterator();
        System.out.println("Iterando cola");
        while (iteratorCola.hasNext()) {
            System.out.println(iteratorCola.next() + " ");
        }


          /******************/
         /***** LISTAS *****/
        /******************/
//        https://www.geeksforgeeks.org/list-interface-java-examples/
        // Lista con elementos iniciados
        List<String> l1 = new ArrayList<>(List.of("{", "[", "("));

        // Java menor a 9
        List<String> strings = new ArrayList<>(
                Arrays.asList("Hello", "world")
        );



        List<Object> l2 = new LinkedList<>();
        l2.add(2);
        l2.add(3);
        l2.add(5);

        // Añadir colección
        l2.addAll(l1);

        l2.size();

        l2.clear();

        Object ind = 2;
        l2.remove(ind);

        l2.add("primer_valor");
        l2.remove(0);

        l2.isEmpty();

        l2.add("primer_valor");
        // Reemplaza elemento de la pos 0 por valor
        l2.set(0,"reemplaza_primer_valor");

        l2.indexOf(4); //1

        // Comparación de listas
        l2.equals(l1); //false

        l2.contains(4); //true

        l2.containsAll(l1); //true

        // Ordena colecciones, pero si es de un tipo específico
        Collections.sort(l1);

          /******************/
         /**** VECTORES ****/
        /******************/
//        https://www.geeksforgeeks.org/java-util-vector-class-java/

          /****************/
         /**** ARRAYS ****/
        /****************/
//        http://www.manualweb.net/java/arrays-java/#:~:text=Un%20array%20Java%20es%20una,puede%20producirse%20en%20otros%20lenguajes.
        // Los array en Java son tanto vectores matemáticos como matrices, pero no tienen muchos métodos, evitar usarlos

        // Array de 5 elementos (vector).
        char array[] = {'a','b','c','d','e'};

        int arreglo[] = new int[2];
        arreglo[0] = 1;
        arreglo[1] = 2;
//        System.out.println(arreglo[0]);

        // Array de 4x4 elementos (matriz).
        int array2[][] = { {1,2,3,4}, {5,6,7,8}};

    }
}

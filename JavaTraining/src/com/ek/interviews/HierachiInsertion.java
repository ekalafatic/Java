package com.ek.interviews;
import  com.ek.estructuras.Arbol;
import com.ek.estructuras.BinaryTree;
import com.ek.estructuras.Node;
import com.ek.estructuras.Nodo;

import java.util.ArrayList;
import java.util.List;

public class HierachiInsertion {
    public static void main(String[] args) {
        Arbol tree = new Arbol();
        Nodo root = new Nodo(1);
        Nodo n1 = new Nodo(2);

        n1.setPadre(root);


        tree.addNodo(n1);

//        System.out.println(tree.recorrerIzquierda(n1).getValor());

        //----------------------------------------
        BinaryTree bt = new BinaryTree();
        List<Node> pathBt = new ArrayList<Node>();

        bt.add(4);
        bt.add(2);
        bt.add(6);
        bt.add(7);
        bt.add(5);
        bt.add(1);
        bt.add(3);

        /*
                     4
                   /   \
                  2     6
                 / \   / \
                1   3 5   7
        */

//        System.out.println(bt.getRoot().value);

        pathBt = bt.path(3);
        System.out.println("Path de 3");
        for (int i = 0; i<pathBt.size(); i++){
            System.out.println(pathBt.get(i));
        }

        // Devuelve true si contiene
        System.out.println(bt.containsNode(6));
        bt.delete(6);
        System.out.println(bt.containsNode(6));

        pathBt = bt.path(5);
        System.out.println("Path de 5");
        for (int i = 0; i<pathBt.size(); i++){
            System.out.println(pathBt.get(i));
        }
                /*
                     4
                   /   \
                  2     7
                 / \   /
                1   3 5
        */
        bt.add(8);
        pathBt = bt.path(8);
        System.out.println("Path de 8");
        for (int i = 0; i<pathBt.size(); i++){
            System.out.println(pathBt.get(i));
        }
        /*
                     4
                   /   \
                  2     7
                 / \   / \
                1   3 5   8
        */

        bt.add(15);
        bt.add(20);
        bt.add(11);

        /*
                      4
                   /     \
                  2       7
                 / \    /   \
                1   3  5     8
                              \
                               15
                              /  \
                             11   20
        */

        bt.delete(7);
        /*
                      4
                   /     \
                  2       8
                 / \    /   \
                1   3  5     15
                            /   \
                           11    20
        */


        pathBt = bt.pathNode(20);
        System.out.println("Path de 20");
        for (int i = 0; i<pathBt.size(); i++){
            System.out.println(pathBt.get(i).value);
        }

        System.out.println("hijo izquierdo de 15: " + pathBt.get(2).left.value);


        Integer v = bt.getFather(20);
        System.out.println("Padre del nodo 20: " + v);

        System.out.println("Recorrido in order");
        bt.traverseInOrder(bt.getRoot());
        System.out.println();
        System.out.println("Recorrido pre order");
        bt.traversePreOrder(bt.getRoot());
        System.out.println();
        System.out.println("Recorrido post order");
        bt.traversePostOrder(bt.getRoot());
        System.out.println();
        System.out.println("BFS");
        bt.traverseLevelOrder();
    }
}

package com.ek.estructuras;
//import com.ek.estructuras.Node;

// This code is a modification of https://www.baeldung.com/java-binary-tree made by Emiliano E. Kalafatic
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    Node root;
    public BinaryTree(){
        this.root = null;
    }

    public void setRoot(Node n){
        this.root = n;
    }

    public Node getRoot(){
        return this.root;
    }

    // Inserta el nodo con recursividad
    public Node  insertNode (Node currentNode, int newValue){
        // Current Node puede ser la raiz del árbol como una subraíz
        if (currentNode == null) {
            return new Node(newValue);
        }

        // Si el nuevo valor es menor al valor del nodo actual, se inserta a la izquierda de este
        if (newValue < currentNode.value) {
            currentNode.left = insertNode(currentNode.left, newValue);
        }
        // Si el nuevo valor es mayor al valor del nodo actual, se inserta a la derecha de este
        else if (newValue > currentNode.value) {
            currentNode.right = insertNode(currentNode.right, newValue);
        }
        // Si el nuevo valor  no es ni igual ni menor, quiere decir que ya existe y no se inserta
        else {
            return currentNode;
        }

        return currentNode;
    }

    public void add(int value) {
        root = insertNode(root, value);
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private List pathRecursive(Node current, int value, List<Integer> path) {

        path.add(current.value);

        if (current == null) {
            return path;
        }

//        if (value == current.value) {
//            return path;
//        }

        // Si el nuevo valor es menor al valor del nodo actual, se inserta a la izquierda de este
        if (value < current.value) {
            pathRecursive(current.left, value, path);
        }
        // Si el nuevo valor es mayor al valor del nodo actual, se inserta a la derecha de este
        else if (value > current.value) {
            pathRecursive(current.right, value, path);
        }
        // Si el nuevo valor  no es ni igual ni menor, quiere decir que ya existe y no se inserta
        else {
            return path;
        }
        return path;
    }

    public List path(int value) {
        List<Integer> path = new ArrayList<Integer>();
        return pathRecursive(root, value, path);
    }

    private List pathNodeRecursive(Node current, int value, List<Node> path) {

        path.add(current);

        if (current == null) {
            return path;
        }

//        if (value == current.value) {
//            return path;
//        }

        // Si el nuevo valor es menor al valor del nodo actual, se inserta a la izquierda de este
        if (value < current.value) {
            pathNodeRecursive(current.left, value, path);
        }
        // Si el nuevo valor es mayor al valor del nodo actual, se inserta a la derecha de este
        else if (value > current.value) {
            pathNodeRecursive(current.right, value, path);
        }
        // Si el nuevo valor  no es ni igual ni menor, quiere decir que ya existe y no se inserta
        else {
            return path;
        }
        return path;
    }

    public List pathNode(int value) {
        List<Node> path = new ArrayList<Node>();
        return pathNodeRecursive(root, value, path);
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            if (current.left == null && current.right == null) {
                return null;
            }

            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            if(current.left != null && current.right != null){
                int smallestValue = findSmallestValue(current.right);
                current.value = smallestValue;
                current.right = deleteRecursive(current.right, smallestValue);
                return current;
            }
        }

        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }

        current.right = deleteRecursive(current.right, value);
        return current;
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    public Integer getFather(int value){
        List<Integer> path = new ArrayList<Integer>();
        int index;
        path = path(value);
        index = path.indexOf(value);
        // El padre será el anterior en el camino desde la raíz
        System.out.println(index);
        return path.get(index-1);
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.value);
        }
    }

    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        // En caso de que se quiera obtenerlo como lista
        List<Node> bfs = new LinkedList();
        bfs.add(root);

        while (!nodes.isEmpty()) {

            Node node = nodes.remove();

            System.out.print(" " + node.value);

            if (node.left != null) {
                nodes.add(node.left);
                bfs.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
                bfs.add(node.right);
            }
        }

//        System.out.println();
//        for(int i = 0; i<bfs.size(); i++){
//            System.out.print(bfs.get(i).value+" ");
//        }
    }

}

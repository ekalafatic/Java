package com.ek.estructuras;

public class Node {
//    public Node father;
    public Node right;
    public Node left;
//    public int index;
    public int value;

    public Node(int value){
//        this.index = index;
        this.value = value;
//        this.father = null;
        this.right = null;
        this.left = null;
    }

    public Node getRight() {
        return right;
    }

    public Node getLeft() {
        return left;
    }

    public int getValue() {
        return value;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setValue(int value) {
        this.value = value;
    }


}

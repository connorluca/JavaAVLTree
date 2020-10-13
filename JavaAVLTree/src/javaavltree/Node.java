/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaavltree;

/**
 *
 * @author conno
 */
public class Node<T extends Comparable> {
    private Node left;
    private Node right;
    private Node parent;
    private int balanceFactor;//if the depth on left is greater = - if right + if the depth difference is 2 or more reblance
    //when we add a new node it's parent will be incremented or decremented based on whether we are adding a right or left child
    private Comparable<T> data;

    public Node(Comparable<T> data) {
        this.data = data;
        left = null;
        right=null;
        balanceFactor=0;
        parent=null;
    }
    
    public Node getLeft() {
        return left;
    }

    public Node getParent() {
        return parent;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getBalanceFactor() {
        return balanceFactor;
    }

    public void setBalanceFactor(int balanceFactor) {
        this.balanceFactor = balanceFactor;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    

    public Comparable<T> getData() {
        return data;
    }

    public void setData(Comparable<T> data) {
        this.data = data;
    }
    
}

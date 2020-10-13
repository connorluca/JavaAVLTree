/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaavltree;

/**
 * This is not a traditional AVL tree as it uses a balance value rather than a
 * height and the nodes all have connections to there parents so that when a new
 * node is added the balance value may move up the tree until it finds a balance
 * issue bal<=-2 or bal>=2
 *
 * @author conno
 */
public class JavaAVLTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JavaAVLTree run = new JavaAVLTree();
        run.createTree();
    }

    public void createTree() {
        CatFactory catFactory = new CatFactory();
        Node root = new Node(catFactory.createRandomCat());
        for (int i = 0; i < 50; i++) {
            Node newNode = new Node(catFactory.createRandomCat());
            addNode(root, newNode);
            while (root.getParent() != null) {
                root = root.getParent();//ensures the root is always the root of the tree
            }
        }
    }

    /*
    root refers to the root of a perspective subtree not necessarilly the entire tree
    returns whatever the root node of the entire tree will be after updating
     */
    private void addNode(Node root, Node newNode) {

        int switchControl = newNode.getData().compareTo(root.getData());
        switch (switchControl) {
            case -1:
                //newNode<root
                if (root.getLeft() == null) {
                    root.setLeft(newNode);
                    newNode.setParent(root);
                    fixBalanceValues(newNode, root, -1);
                } else {
                    addNode(root.getLeft(), newNode);
                }

            default:
                //newNode==root || newNode>root
                if (root.getRight() == null) {
                    root.setRight(newNode);
                    newNode.setParent(root);
                    fixBalanceValues(newNode, root, 1);
                } else {
                    addNode(root.getRight(), newNode);
                }

        }
    }

    /*
    Because values(objects) are passed by reference if root is the root of the entire tree the correct elemetn will always occupy the correct place
    @param balanceAdjustment the amount parents balance will be adjusted based on the side the node is added to
     */
    private void fixBalanceValues(Node newNode, Node root, int balanceAdjustment) {
        root.setBalanceFactor(root.getBalanceFactor() + balanceAdjustment);
        //if balance is zero it's balanced we don't have to do anything
        //if it's -2 or 2 we have found where the imbalance occurs and now must correct it
        //if we are at the root(parent is null) and none of the other conditions are met the tree is still balanced and we do nothing
        while (root.getParent() != null && root.getBalanceFactor() != 0 && root.getBalanceFactor() != -2 && root.getBalanceFactor() != 2) {
            root = root.getParent();
            root.setBalanceFactor(root.getBalanceFactor() + balanceAdjustment);
        }
        if (root.getBalanceFactor() == 0) {
            return;
        } else if (root.getBalanceFactor() == 2) {
            Node b, c;
            b = root.getRight();
            if (b.getBalanceFactor() == 1) {
                c = b.getRight();
                //left rotation
                b.setParent(root.getParent());
                c.setLeft(b.getLeft());
                b.setLeft(root);
                root.setParent(b);
                root.setRight(null);
                b.setBalanceFactor(0);
                c.setBalanceFactor(0);
                if (root.getLeft() != null) {
                    root.setBalanceFactor(-1);
                } else {
                    root.setBalanceFactor(0);
                }
            } else {//balance==-1
                //right left rotation
                c = b.getLeft();
                c.setParent(root.getParent());
                root.setRight(c.getLeft());
                root.setParent(c);
                b.setLeft(c.getRight());
                b.setParent(c);
                c.setRight(b);

                c.setBalanceFactor(0);
                if (b.getRight() == null) {
                    b.setBalanceFactor(0);
                } else if (b.getLeft() == null) {
                    b.setBalanceFactor(1);
                } else {
                    b.setBalanceFactor(0);
                }
                if (root.getLeft() == null) {
                    root.setBalanceFactor(0);
                } else if (root.getRight() == null) {
                    root.setBalanceFactor(-1);
                } else {
                    root.setBalanceFactor(0);
                }
            }
        } else if (root.getBalanceFactor() == -2) {
            Node b, c;
            b = root.getLeft();
            if (b.getBalanceFactor() == -1) {
                c = b.getLeft();
                b.setParent(root.getParent());
                root.setLeft(b.getRight());
                root.setParent(b);
                b.setRight(root);
                b.setBalanceFactor(0);
                if (c.getLeft() == null) {
                    c.setBalanceFactor(0);
                } else {
                    c.setBalanceFactor(-1);
                }

            } else {//balance==1
                c = b.getRight();
                b.setRight(c.getLeft());
                root.setLeft(c.getRight());
                c.setParent(root.getParent());
                c.setLeft(b);
                c.setRight(root);
                b.setParent(c);
                root.setParent(c);
                c.setBalanceFactor(0);
                if (root.getRight() == null) {
                    root.setBalanceFactor(0);
                } else if (root.getLeft() == null) {
                    root.setBalanceFactor(1);
                } else {
                    root.setBalanceFactor(0);
                }
                if (b.getRight() == null) {
                    b.setBalanceFactor(0);
                } else if (b.getLeft() == null) {
                    b.setBalanceFactor(1);
                } else {
                    b.setBalanceFactor(0);
                }
            }
        }

    }
}

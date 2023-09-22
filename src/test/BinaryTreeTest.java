package test;

import tree.BinaryTree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree<Integer, String> integerStringBinaryTree = new BinaryTree<>();
        integerStringBinaryTree.put(1,"123");
        integerStringBinaryTree.put(2,"234");
        integerStringBinaryTree.put(3,"345");
        integerStringBinaryTree.preOrder();
        System.out.println("the number of node" + integerStringBinaryTree.size());
    }
}

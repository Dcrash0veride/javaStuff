
/*
Populate BST with the integers that are provided as input and then to poutput the whole tree inOrder traversal

Input = the first line is T: The number of integers to be inserted into the tree. Actual values follow

Output = One line containing all the values in the appropriate order
 */

import java.util.Scanner;

public class Solution {

    static class binarySearchTree {

        Node root;

        binarySearchTree() {
            root = null;
        }

        private Node insert(Node parent, int value) {
            if (parent == null) {
                Node newNode = new Node();
                newNode.value = value;
                return newNode;
            } else if (value <= parent.value) {
                parent.left = insert(parent.left, value);
                return parent;
            } else {
                parent.right = insert(parent.right, value);
                return parent;
            }
        }

        void insert(int value) {
            root = insert(root, value);
        }

        public void inOrder(Node node) {
            if (node == null) {
                return;
            }
            inOrder(node.left);
            System.out.print(node.value + " ");
            inOrder(node.right);
        }

    }

    static class Node {
        public int value;
        public Node left;
        public Node right;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        binarySearchTree myTree = new binarySearchTree();
        for (int i = 0; i < T; i++) {
            int value = sc.nextInt();
            myTree.insert(value);
        }
        myTree.inOrder(myTree.root);
    }
}

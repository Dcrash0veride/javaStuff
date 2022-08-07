import java.util.LinkedList;
import java.util.Queue;

public class binarySearchTree {

    Node root;

    binarySearchTree(){
        root = null;
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    void levelOrder() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            System.out.print(currentNode.value + " ");
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
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
    static class Node {
        public int value;
        public int height;
        public Node left;
        public Node right;
    }

    public static void main(String[] args) {
        binarySearchTree newBST = new binarySearchTree();
        newBST.insert(70);
        newBST.insert(50);
        newBST.insert(90);
        newBST.insert(30);
        newBST.insert(10);
        newBST.insert(100);
        newBST.insert(87);
        newBST.preOrder(newBST.root);
        System.out.println(" ");
        newBST.inOrder(newBST.root);
        System.out.println(" ");
        newBST.postOrder(newBST.root);
        System.out.println(" ");
        newBST.levelOrder();

    }
}

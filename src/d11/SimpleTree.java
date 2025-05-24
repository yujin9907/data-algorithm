package d11;

import java.util.ArrayDeque;
import java.util.Deque;

// 트리는 자체적으로 리컬시브하기 때문에 모든 로직을 그렇게 짜는 게 편하다
public class SimpleTree {

    class Node {
        char data;
        Node left;
        Node right;

        Node(char d) {
            data = d;
            left = null;
            right = null;
        }

        public Node(char data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public String toString() {
            return "" + data;
        }
    }

    Node root;
    char[] array;

    SimpleTree() {
        root = null;
        array = new char[20]; // max 라고 치자
    }

    public Node makeTree(char ch) {
        root = new Node(ch);
        return root;
    }

    public Node makeTree(SimpleTree leftSubtree, char ch, SimpleTree rightSubtree) {
//			root = new Node(ch);
//			root.left=leftSubtree.root;
//			root.right=rightSubtree.root;

        root = new Node(ch, leftSubtree.root, rightSubtree.root);
        return root;
    }

    public void showTree() {
        System.out.println("<Tree in Nodes>");
//        showTree(root);

        System.out.println("<week12>");

        inorder(root);
        System.out.println();

        preorder(root);
        System.out.println();

        postorder(root);
        System.out.println();

        levelorder(root);
        System.out.println();
    }

    private void showTree(Node p) { // TODO 중위표기법?
        if (p != null) {
            showTree(p.left);
            System.out.print(p.data);
            showTree(p.right);
        }
    }

    public void inorder(Node p) {
        if (p != null) {
            showTree(p.left);
            System.out.print(p.data);
            showTree(p.right);
        }
    }

    public void preorder(Node p) {
        if (p != null) {
            System.out.print(p.data);
            showTree(p.left);
            showTree(p.right);
        }
    }

    public void levelorder(Node p) {
        Deque<Node> queue = new ArrayDeque<>();

        queue.addLast(root);
        while (!queue.isEmpty()) {
            Node node = queue.removeFirst();

            if (node != null) System.out.print(node.data);
            if (node.left != null) queue.addLast(node.left);
            if (node.right != null) queue.addLast(node.right);
        }
    }

    public void postorder(Node p) {
        if (p != null) {
            showTree(p.left);
            showTree(p.right);
            System.out.print(p.data);
        }
    }

    public void toArray() {
        toArray(root, 1);
        System.out.println("<Tree in Array>");
        for (int i = 1; i <= 7; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void toArray(Node p, int i) {
        if (p != null) {
            array[i] = p.data;
            toArray(p.left, i * 2);
            toArray(p.right, i * 2 + 1);
        }
    }

    public int getNodeCount() {
        return getNodeCount(root);
    }

    private int getNodeCount(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + getNodeCount(node.left) + getNodeCount(node.right);
        }
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(Node p) {
        if (p == null) {
            return 0;
        } else {
            return 1 + Math.max(getHeight(p.left), getHeight(p.right));
        }
    }

    public boolean contains(char d) {
        return contains(root, d);
    }

    private boolean contains(Node node, char d) {
        if (node == null) {
            return false;
        } else {
            if (node.data == d) {
                return true;
            } else {
                return contains(node.left, d) || contains(node.right, d);
            }
        }
    }

    public static void main(String[] args) {
        // a*b+c%d

        SimpleTree t1 = new SimpleTree();
        t1.makeTree('a');
        SimpleTree t2 = new SimpleTree();
        t2.makeTree('b');
        SimpleTree t3 = new SimpleTree();
        t3.makeTree('c');
        SimpleTree t4 = new SimpleTree();
        t4.makeTree('d');

        SimpleTree t5 = new SimpleTree();
        t5.makeTree(t1, '*', t2);
        SimpleTree t6 = new SimpleTree();
        t6.makeTree(t3, '%', t4);

        SimpleTree t7 = new SimpleTree();
        t7.makeTree(t5, '+', t6);

        t7.showTree();
        t7.toArray();

        System.out.println(t7.getNodeCount());
        System.out.println(t7.getHeight());

        System.out.println(t7.contains('a'));
        System.out.println(t7.contains('k'));

        // week 12
        t7.showTree();
    }

}
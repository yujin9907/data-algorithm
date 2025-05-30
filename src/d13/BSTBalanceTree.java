package d13;


import java.util.ArrayDeque;
import java.util.Deque;

// 바이너리 서치 트리 - 로테이트 left, right (balance)
public class BSTBalanceTree {

    class Node {
        int key;
        Node left, right;
        Node parent;

        Node(int d) {
            key = d;
            left = null;
            right = null;
            parent = null;
        }

        Node(int d, Node p) {
            key = d;
            left = null;
            right = null;
            parent = p;
        }

        public String toString() {
            return "" + key + " ";
        }
    }

    Node root;

    public BSTBalanceTree() {
        root = null;
    }

    public void insert(int d) {
        if (root == null) {
            root = new Node(d);
        }
        else {
            Node prt = null; // 부모
            insert(root, d, prt);
        }
    }

    private Node insert(Node node, int d, Node p) {
        if (node == null) return new Node(d, p);

        if (d<node.key) {
            node.left = insert(node.left, d, node);
        } else {
            node.right = insert(node.right, d, node);
        }
        return node;
    }

    public void showTree() {
        System.out.println();
        showTree(root);
        System.out.println();
    }

    private void showTree(Node p) {
        if (p!=null) {
            showTree(p.left);
            System.out.print(p.toString());
            showTree(p.right);
        }

    }

    public boolean search(int d) {
        return search(root, d);
    }
    private boolean search(Node node, int d) {
        if (node==null) return false;

        if (d == node.key) {
            return true;
        }

        if (d < node.key) {
            return search(node.left, d);
        } else {
            return search(node.right, d);
        }
    }


    public void rotateLeft() {
        rotateLeft(root);
    }
    private void rotateLeft(Node pp) { // pp == parent of parent
        if (pp == root) {
            root = pp.right;
            pp.right.parent = null;
            pp.right.left = pp;
            pp.parent = pp.right;
//            pp.right = root.left;
            pp.right = null; // TODO : 원래 위에로 썼다가 왜 null 로 바꿈?
        } else {
            // pp 가 parent 의 왼/오 일 때
            if (pp == pp.parent.left) {
                pp.parent.left = pp.right;
                pp.right.parent = pp.parent;
                pp.right.left = pp;
                pp.parent = pp.right;
                pp.right =  null;
            } else {
                pp.parent.right = pp.right;
                pp.right.parent = pp.parent;
                pp.right.left = pp;
                pp.parent = pp.right;
                pp.right =  null;
            }
        }
    }

    public void showLevel() {
        if (root != null) {
            showLevel(root);
        }
    }

    private void showLevel(Node node) { // 레벨 구현하기 복습
        Deque<Node> q = new ArrayDeque<>();
        q.add(node);
        int currentLevel = -1;
        while (!q.isEmpty()) {
            Node p = q.removeFirst();
            if (currentLevel < level(p)) {
                currentLevel++;
                System.out.print("\nLevel "+currentLevel+" : ");
            }
            System.out.print(p.key);
            if (p.left != null) q.add(p.left);
            if (p.right != null) q.add(p.right);
        }
    }

    private int level(Node node) {
        if (node==root) {
            return 0;
        } else {
            return 1+level(node.parent);
        }
    }

    public static void main(String[] args) {
        int[] keys = {4, 7, 5, 1, 0, 3, 9, 2, 6, 8};


        BSTBalanceTree t = new BSTBalanceTree();

        for (int i = 0; i < keys.length; i++) {
            t.insert(keys[i]);
            t.showTree();
        }

        System.out.println("\nBefore rotate left:");
        t.showLevel();

        System.out.println("\nAfter rotate left:");
        t.rotateLeft();
        t.showLevel();

        System.out.println("\nAfter rotate left:");
        t.rotateLeft();
        t.showLevel();

//        t.rotateLeft();
//        t.showLevel();
//
//        t.rotateLeft();
//        t.showLevel();

    }
}

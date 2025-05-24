package d12;

import java.awt.*;


// 바이너리 서치 트리
public class BST {

    class Node {
        int key;
        Node left, right;

        Node(int d) {
            key = d;
            left = null;
            right = null;
        }

        public String toString() {
            return "" + key + " ";
        }
    }

    Node root;

    public BST() {
        root = null;
    }

    // TODO Insert 리커전, 이터럴 둘 다 이해 특히 리커전
    public void insert(int d) {
        if (root == null) {
            root = new Node(d);
        }
        else {
//            Node parent = null; // 위로 가기 위한 연결
//            Node node = root;
//
//            while (node != null) { // null 이 돼서 나오면, parent 는 그 null 의 부모를 가지고 있음
//                parent = node;
//                if (d<node.key) {
//                    node = node.left;
//                } else {
//                    node = node.right;
//                }
//            }
//
//            Node newNode = new Node(d);
//            if (d<parent.key) {
//                parent.left = newNode;
//            } else {
//                parent.right = newNode;
//            }
            insert(root, d);
        }
    }

    private Node insert(Node node, int d) {
        if (node == null) return new Node(d);

        if (d<node.key) {
            node.left = insert(node.left, d);
            return node;
        } else {
            node.right = insert(node.right, d);
            return node;
        }
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

    public void delete(int d) {
        Node parent = null;
        Node node = root;

        while (node != null && node.key != d) {
            parent = node;
            if (d<node.key) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        if (node!=null) { // node.key == d
            if (node == root) {
                root = deleteANode(root);
            } else {
                if (node.key < parent.key) {
                    parent.left = deleteANode(node);
                } else {
                    parent.right = deleteANode(node);
                }
            }
        }
    }

    // TODO : predecessor 해보기 (과제)
    // 헷갈리는 거 있으면 강의자료 보고 해보기
    // 바이너리 서치트리는 필수 내용 중 하나입니다.
    private Node deleteANode(Node node) {
        // case1 : no child
        if (node.left==null && node.right==null) return null;

        // case2 : 1 child
        else if (node.left == null && node.right != null) return node.right; // ie. node.right != null
        else if (node.right == null && node.left != null) return node.left; // ie. node.left != null

        // case3 : 2 child
        else {
            // successor or predecessor : 중 하나 선택 (구현하는 사람 마음)
            Node s = node.right;
            Node parent = node;

            while (s.left != null) {
                parent = s;
                s = s.left;
            }
            // now, s means successor
            node.key = s.key;
            if (s==node.right) {
                node.right = s.right;
            } else {
                parent.left = s.right;
            }
            return node;
        }

    }

    public static void main(String[] args) {
        int[] keys = {4, 7, 5, 1, 0, 3, 9, 2, 6, 8};


        BST t = new BST();

        for (int i = 0; i < keys.length; i++) {
            t.insert(keys[i]);
            t.showTree();
        }


        System.out.println(t.search(3));
        System.out.println(t.search(11));

        t.delete(3);
        System.out.println("\nAfter delete 3 (case2 : only left child)");
        t.showTree();
        t.delete(4);
        System.out.println("\nAfter delete 4 (case3) ");
        t.showTree();
        t.delete(2);
        System.out.println("\nAfter delete 2 (case1 : right end) :");
        t.showTree();
        t.delete(10);
        System.out.println("\nAfter delete 10 (Not Found) :");
        t.showTree();

    }
}

package sample;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinarySearchTreeExam {

	class Node {
		int key;
		Node left, right, parent;
		
		Node(int d){
			key = d;
			left=null;
			right=null;
			parent=null;
		}
		
		public String toString() {
			return ""+key+" ";
		}
	}
	
	Node root;
	
	public BinarySearchTreeExam() {
		root=null;
	}
	
	public void insert(int d) {
		if (root==null) {
			root = new Node(d);
		}
		else {
			insert(root, d, null);
		}	
	}

	private void insert(Node node, int d, Node parent) {
		if (node==null) { // insert here !
			Node newNode = new Node(d);
			if (d <parent.key) {
				parent.left = newNode;
				newNode.parent = parent;
			}
			else { //d >parent.key
				parent.right = newNode;
				newNode.parent = parent;
			}
		}
		else if (d <node.key) 
			insert(node.left, d, node);
		else // d > node.key
			insert(node.right, d, node);
	}
	private void insertIter( int d) {
	// 3-1) add your code...

		
		
		
		
		
		
	}
	
	public void showLevel() {
		System.out.print("\n=== Level-Order ===");

		Deque<Node> q = new ArrayDeque<Node>();
		if (root==null)
			return;
		q.add(root); // addLast
		int curLevel = -1;
		while(!q.isEmpty()) {
			Node node = q.removeFirst();
			if (curLevel<level(node)) {
				curLevel++;
				System.out.print("\nLevel "+curLevel+" : ");
			}
			System.out.print(node.key+" ");
			if (node.left!=null) q.add(node.left);
			if (node.right!=null) q.add(node.right);
		}
	}
	
	private int level(Node node) {
		if (node==root) return 0;
		else return 1+level(node.parent);
	}
	
	public boolean search(int d) {
		return search(root, d);
	}

	private boolean search(Node node, int d) {
		if (node==null)
			return false;
		if (node.key==d)
			return true;
		if (d<node.key)
			return search(node.left, d);
		else
			return search(node.right, d);
	}
	
	private void rotateLeft(Node pp) {
		if (pp==root) {
			root = pp.right;
			pp.right.parent = null;
			pp.right.left = pp;
			pp.parent = pp.right;
			pp.right=null;
		}
		else {
			if (pp==pp.parent.left) {
				pp.parent.left =pp.right;
				pp.right.parent = pp.parent;
				pp.right.left = pp;
				pp.parent =pp.right;
				pp.right=null;
				
			}
			else {
				pp.parent.right =pp.right;
				pp.right.parent = pp.parent;
				pp.right.left = pp;
				pp.parent =pp.right;
				pp.right=null;
			}
		}
	
	}

	private void rotateRight(Node pp) {
	// 3-2) add your code...
		
		
		
		
		
		
		
	}
	
	private boolean isBalanced(Node node) {
		if (node==null)
			return true;
		else {
			return (Math.abs(height(node.left)-height(node.right))<2);
		}
	}
	private int height(Node node) {
		if (node==null)
			return 0;
		else 
			return 1+ Math.max(height(node.left), height(node.right));
	}

	public void insertWithRotate(int k) {
		if (root==null)
			root = new Node(k);
		else 
			insertWithRotate(root, k, root.parent);
	}

	private void insertWithRotate(Node node, int k, Node parent) {
	// 3-3) add your code...

		
		
		
		
		
		
		
		
		
		
		
		
	}

	public static void main(String[] args) {
		int [] keys = {5,4,3,2,1,0,6,7,8,9,10,11};
		
		BinarySearchTreeExam t = new BinarySearchTreeExam();

		System.out.println("\n\n<<< Normal Binary Search Tree >>>");
		for (int i=0; i<keys.length;i++) {
			t.insertIter(keys[i]);
			t.showLevel();
		}
		
		BinarySearchTreeExam tb = new BinarySearchTreeExam();
		System.out.println("\n\n\n<<< Partially-Balanced Binary Search Tree >>> ");
		for (int i=0; i<keys.length;i++) {
			tb.insertWithRotate(keys[i]);
			tb.showLevel();
		}
	}

}

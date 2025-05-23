
public class BST {

	class Node {
		int key;
		Node left, right;
		
		Node(int d){
			key = d;
			left=null;
			right=null;
		}
		
		public String toString() {
			return ""+key+" ";
		}
	}
	
	Node root;
	
	public BST() {
		root=null;
	}
	
	public void insert(int d) {


	}
	
	public void showTree() {
		System.out.println();
		showTree(root);
		System.out.println();
	}

	private void showTree(Node p) {
		

		}
	}
	
	public boolean search(int d) {




	}
	
	public void delete(int d) {





	}

	public static void main(String[] args) {
		int [] keys = {4,7,5,1,0,3,9,2,6,8};
		

		BST t = new BST();
		
		for (int i=0; i<keys.length;i++) {
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

package d11;

// 트리는 자체적으로 리컬시브하기 때문에 모든 로직을 그렇게 짜는 게 편하다
public class SimpleTree {

		class Node {
			char data;
			Node left;
			Node right;

			Node(char d){
				data=d;
				left=null;
				right=null;
			}

			public Node(char data, Node left, Node right) {
				this.data = data;
				this.left = left;
				this.right = right;
			}

			public String toString() {
				return ""+data;
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
			showTree(root);
			System.out.println();
		}

		private void showTree(Node p) {
			if (p!=null) {
				showTree(p.left);
				System.out.print(p.data);
				showTree(p.left);
			}
		}

		public void toArray() {
			toArray(root, 1);
			System.out.println("<Tree in Array>");
			for (int i=1; i<=7; i++) {
				System.out.print(array[i]+" ");
			}
			System.out.println();
		}

		public void toArray(Node p, int i) {
			if (p!=null) {
				array[i] = p.data;
				toArray(p.left, i*2);
				toArray(p.right, i*2+1);
			}
		}

		public int getNodeCount() {


			return 0;
		}

		public int getHeight() {
			return getHeight(root);
		}

		private int getHeight(Node p) {
			if (p==null) {
				return 0;
			} else {
				return 1+Math.max(getHeight(p.left), getHeight(p.right));
			}
		}

		public boolean contains(char d) {


			return true;
		}

		public static void main(String[] args) {
			// a*b+c%d

			SimpleTree t1= new SimpleTree(); t1.makeTree('a');
			SimpleTree t2= new SimpleTree(); t2.makeTree('b');
			SimpleTree t3= new SimpleTree(); t3.makeTree('c');
			SimpleTree t4= new SimpleTree(); t4.makeTree('d');

			SimpleTree t5= new SimpleTree(); t5.makeTree(t1, '*', t2);
			SimpleTree t6= new SimpleTree(); t6.makeTree(t3, '%', t4);

			SimpleTree t7= new SimpleTree(); t7.makeTree(t5, '+', t6);

			t7.showTree();
			t7.toArray();

			System.out.println(t7.getNodeCount());
			System.out.println(t7.getHeight());

			System.out.println(t7.contains('a'));
			System.out.println(t7.contains('k'));


		}

	}
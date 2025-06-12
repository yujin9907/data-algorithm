package d10;


// d9.MyLinkedList0 과 동일한 로직 : int -> string 으로만 변// 10:24분 스트링 결과

public class MyStringLinkedList {


	class Node {
		String data;
		Node next;

		public Node(String d) {
			this.data = d;
			next = null;
		}

		public String toString() {
			return ""+data;
		}
	}

	Node head;
	int size;

	public MyStringLinkedList() {
		head = null;
		size = 0;
	}

	public boolean isEmpty() {
		return (head==null);
	}

	public void add(String value) {
		addFirst(value);
	}

	private void addFirst(String value) {
		Node newNode = new Node(value);
		newNode.next=head;
		head=newNode;

		size++;
	}
	private void addLast(String value) {
		if (isEmpty()) {
			addFirst(value);
		} else {
			Node newNode = new Node(value);
			Node p = head;
			while (p.next != null) {
				p=p.next;
			}
			p.next = newNode;
			size++;
		}
	}

	public int indexOf(String value) {
		int index = 0;
		Node p = head;
		while (p != null) {
			if (p.data.equals(value)) {
				return index;
			}
			index++;
			p = p.next;
		}
		return -1;
	}

	public void add(int index, String value) {
		if (checkIndexRange(index)) {
			if (index == 0) {
				addFirst(value);
				return;
			}

			Node newNode = new Node(value);
			int i=1;
			Node p = head;

			while (p.next != null) {
				if (i==index) {
					newNode.next=p.next;
					p.next = newNode;
					size++;
					return;
				} else {
					i++;
					p=p.next;
				}
			}
		}
		else if (index==size()) {
			addLast(value);
		}
	}

	public int size() {
		return size;
	}

	public void clear() {
		head = null;
	}

	public boolean contains(String value) {
		return (indexOf(value) != -1);
	}

	public String get(int index) {
		int i = 0;
		Node p = head;

		while (p != null) {
			if (i==index) {
				return p.data;
			}
			i++;
			p=p.next;
		}
		return null;
	}

	public void set(int index, String value) {
		int i = 0;
		Node p = head;

		while (p != null) {
			if (i==index) {
				p.data = value;
			}
			i++;
			p=p.next;
		}
	}

	public String remove(int index) {
		String ret = null;

		if (checkIndexRange(index)) {
			if (index == 0) {
				ret = removeFirst();
			} else {
				int i=1;
				Node p=head;
				while(p.next!=null) {
					if (i==index) {
						ret=p.next.data;
						p.next=p.next.next;
						size--;
						break;
					}
					i++;
					p=p.next;
				}
			}
		}
		return ret;
	}

	private String removeLast() {
		if (!isEmpty()) {
			if (head.next==null) {
				return removeFirst();
			}
			else {
				Node p=head;
				Node q = p.next;
				while(q!=null) {
					if (q.next==null) {
						p.next=null;
						size--;
						return q.data;
					}
					else {
						p=q;
						q=q.next;
					}
				}
			}
		}
		return null;
	}

	public String remove(String value) {
		if (head != null) {
			if (head.data.equals(value)) {
				return removeFirst();
			}
			Node p = head;
			Node q = p.next;
			while (q!=null) {
				if (q.data.equals(value)) {
					p.next = q.next;
					size--;
					return q.data;
				}
				p=q;
				q=q.next;
			}
		}
		return null;
	}

	public String removeFirst() {
		String ret = null;

		if (head != null) {
			ret = head.data;
			head = head.next;
			size--;
		}

		return ret;
	}

	public boolean checkIndexRange(int index) {
		if (index>=0 && index<size()) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		String str="";
		Node p = head;
		while (p!=null) {
			str = str + p.data + " ";
			p=p.next;
		}
		return str;
	}

	public void showList() {
		System.out.println(toString());
	}

	
	public static void main(String[] args) {
		
		String [] data = {"kim","lee","park","choi","jung","kang","cho","yoon","jang"};
		
		MyStringLinkedList list = new MyStringLinkedList();

		for (int i=0;i<data.length; i++) {
			list.add(data[i]);
			list.showList();
		}
		
		System.out.println(list.get(0));
		System.out.println(list.get(5));
		System.out.println(list.get(11));
		
		list.add(0, "Lim");
		list.add(5, "han");
		list.add(list.size(), "oh");
		list.showList();

		System.out.println(list.indexOf("lee"));

		System.out.println(list.remove(0));
		list.showList();
		System.out.println(list.remove(5));
		list.showList();
		System.out.println(list.remove(list.size()-1));
		list.showList();
		
		System.out.println(list.remove("han"));
		list.showList();

		
	}

}

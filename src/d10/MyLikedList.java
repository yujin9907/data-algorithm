package d10;

// double linked list
// TODO week 10 과제, 더블링크드리스트 수업 때 한 싱글리스트처럼 전부 구현해서 제출하기
public class MyLikedList<T> {
    class Node {
        T data;
        Node prev;
        Node next;

        Node(T d) {
            data=d;
            prev=null;
            next=null;
        }

        public String toString() {
            return ""+data.toString();
        }
    }

    Node head, tail;
    int size;

    public MyLikedList() {
        head = null;
        tail = null;
    }

    public void add(T value) {
        addFirst(value);
    }
    public void addFirst(T value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
            tail = head;
        } else {
            newNode = head;
            head.prev = newNode;
        }
        size++;
    }

    private void addLast(T value) {

    }

    public void add(int index, T value) {
        if (checkIndexRange(index) || index == size()) {
            if (index == 0) addFirst(value);
            else if (index==size()) addLast(value);
            else {
                Node newNode = new Node(value);
                Node p=head;
                for (int i=0; i<index-1; i++) {
                    p=p.next;
                }
                newNode.prev = p;
                newNode.next = p.next;
                p.next.prev = newNode;
                p.next = newNode;
                size++;
            }
        }
    }


    public boolean checkIndexRange(int index) {
        if (index>=0 && index<size()) {
            return true;
        } else {
            return false;
        }
    }

    private int size() {
        return size;
    }

    private boolean isEmpty() {
        return head==null;
    }
}

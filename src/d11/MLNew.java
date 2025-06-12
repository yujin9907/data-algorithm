package d11;


//MyLikedList<T> 그대로 복사
public class MLNew<T> {
    class Node {
        T data;
        Node prev;
        Node next;

        Node(T d) {
            data = d;
            prev = null;
            next = null;
        }

        public String toString() {
            return "" + data.toString();
        }
    }

    Node head, tail;
    int size;


    public MLNew() {
        head = null;
        tail = null;
    }

    // add 는 깔끔하게 수정할 수 없다.
    // 그 자체로 새로운 것이라서... remove 처럼 변경할 게 없음
    // add 전부 public 으로 바꿈 -> 실제 자바 라이브러리처럼 사용 가능하게 하여 편의성을 높임
    public void add(T value) {
        addLast(value);
    }

    public void addFirst(T value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
            tail = head;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }



    public void addLast(T value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
            tail = head;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    private int size() {
        return size;
    }
    private int size(Node p) {
        // 리커전으로
        if (p==null) {
            return 0;
        } else {
            return 1+size(head.next);
        }
    }

    private boolean isEmpty() {
        return head == null;
    }

    public boolean checkIndexRange(int index) { // 변화 x
        if (index >= 0 && index < size()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean contains(T value) { // 변화 x
        return (indexOf(value) != -1);
    }

    public T get(int index) { // 변화 x
        int i = 0;
        Node p = head;

        while (p != null) {
            if (i == index) {
                return p.data;
            }
            i++;
            p = p.next;
        }
        return null;
    }

    public void set(int index, T value) { // 변화 x
        int i = 0;
        Node p = head;

        while (p != null) {
            if (i == index) {
                p.data = value;
                return;
            }
            i++;
            p = p.next;
        }
    }

    public int indexOf(T value) { // 변화 x
        int index = 0;
        Node p = head;
        while (p != null) {
            if (p.data.equals(value)) {
                return index;
            }
            index++;
            p = p.next;
        }
        return -999;
    }


    // 추가 (MyLinkedList 의 다른 접근방법)
    // 노드 하나 리무브하기 (자바 라이브러리 보다가 이거 함, 먼 라이브러리?)
    private T removeANode(Node p) {
        if (p==null) throw new RuntimeException("p 가 null 임");
        T ret = p.data;

        // 왼쪽
        if (p.prev == null) {
            head = p.next;
        } else {
            p.prev.next = p.next;
        }

        // 오른쪽
        if (p.next == null) {
            tail = p.prev;
        } else {
            p.next.prev = p.prev;
        }

        size--;
        return ret;
    }

    public T remove(int index) {
        if (checkIndexRange(index)) {
            Node p = head;

            for (int i = 0; i < index; i++) {
                p = p.next;
            }

            return removeANode(p);
        } else {
            return null;
        }
    }

    private T removeFirst() {
        if (head != null) {
            return removeANode(head);
        }
        return null;
    }

    private T removeLast() {
        if (tail != null) {
            return removeANode(tail);
        }
        return null;
    }

    public boolean remove(T value) {
        Node p = head;
        while (p != null) {
            if (p.data.equals(value)) {
                removeANode(p);
                return true;
            } else {
                p = p.next;
            }
        }

        return false;
    }


    public void showList() {
        System.out.println(toString());
    }


    public static void main(String[] args) {
    }
}
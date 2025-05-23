package d11;

// double linked list
// 변화x 주석 :  MyLinkedList2 복사만 한 것
public class MyLinkedList<T> {
    // 노드는 유지보수성과 사용자 특성을 배제하기 위해, 클래스를 따로 분리하지 않고 안에다 작성
    // 즉, 안쪽에 있는 게 맞음 (Node 안에는 의미를 갖는 메서드도 포함하지 않도록 함
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


    public MyLinkedList() {
        head = null;
        tail = null;
    }

    // addLast() / add First()?
    // 원래는 앞에 붙이는 게 성능에 제일 좋음으로 MyLiskedList1,2에서는 First 로 했으나, tail 이 추가되며 last 로 해도 됨
    // 실제 자바 구현체에서도 last 로 구현됨
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
            head=newNode;
        }
        size++;
    }

    private boolean isEmpty() {
        return head==null;
    }

    private void addLast(T value) {
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
                newNode.next = p;
                newNode.prev = p.prev;
                p.prev.next = newNode;
                p.prev = newNode;
                size++;
            }
        }
    }

    public boolean checkIndexRange(int index) { // 변화 x
        if (index>=0 && index<size()) {
            return true;
        } else {
            return false;
        }
    }

    private int size() {  // 변화 x
        return size;
    }

    public boolean contains(T value) { // 변화 x
        return (indexOf(value) != -1);
    }

    public T get(int index) { // 변화 x
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

    public void set(int index, T value) { // 변화 x
        int i = 0;
        Node p = head;

        while (p != null) {
            if (i==index) {
                p.data = value;
                return;
            }
            i++;
            p=p.next;
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

    public T remove(int index) {
        T ret = null;

        if (checkIndexRange(index)) {
            if (index == 0) {
                ret = removeFirst();
            } else if (index == (size-1)) {
                ret = removeLast();
            } else {
                Node p = head;

                for (int i=0; i<index; i++) {
                    p=p.next;
                }

                ret = p.data;


                p.next.prev = p.prev;
                p.prev.next = p.next;
                size--;
            }
        }
        return ret;
    }

    // 5.16 : TODO node 가 1개 일 때 removeFirst, removeLast 고려되어 있지않음
    private T removeFirst() {
//        T ret = null;
//
//        if (head != null) {
//            ret = head.data;
//            head.next.prev = null;
//            head = head.next;
//            size--;
//        }
//
//        return ret;
        T ret = null;
        if (head!=null) {
            ret = head.data;
            head = head.next;
            if (head!=null)
                head.prev=null;
            else
                tail=null;
            size--;
        }
        return ret;
    }
    private T removeLast() {
//        T ret = null;
//
//        if (tail != null) {
//            ret = tail.data;
//            tail.prev.next = null;
//            tail = tail.prev;
//            size--;
//        }
//
//        return ret;
        T ret = null;
        if (tail!=null) {
            ret = tail.data;
            tail = tail.prev;
            if (tail!=null)
                tail.next=null;
            else
                head=null;
            size--;
        }
        return ret;
    }

    public T remove(T value) {
        if (head != null) {
            if (head.data == value) {
                return removeFirst();
            } else if (tail.data == null) {
                return removeLast();
            } else {
                Node p = head.next;
                while (p!=null) {
                    if (p.data.equals(value)) {
                        T ret = p.data;
                        p.next.prev = p.prev; // 이런 표현들을 이해하고 자유롭게 사용할 수 있어야 한다
                        p.prev.next = p.next;
                        size--;
                        return ret;
                    }
                    p=p.next;
                }
            }
        }
        return null;
    }


    public void showList() {
        System.out.println(toString());
    }

    public void clear() {
        head = null;
        tail=null;
        size=0;
    }



    public static void main(String[] args) { // 변화 x

//		String [] data = {"kim","lee","park","choi","jung","kang","cho","yoon","jang"};
        Object [][] data = {{1,"kim"},{2,"lee"},{3,"park"},{4,"choi"},{5,"jung"},
                {6,"kang"},{7,"cho"},{8,"yoon"},{9,"jang"}};

        MyLinkedList<MyData> list = new MyLinkedList<>();

        for (int i=0;i<data.length; i++) {
            list.add(new MyData((int)data[i][0], (String)data[i][1]));
            list.showList();
        }

        System.out.println(list.get(0));
        System.out.println(list.get(5));
        System.out.println(list.get(8));

        list.add(0,new MyData(10, "Lim"));
        list.add(5,new MyData(11, "han"));
        list.add(list.size(),new MyData(12, "oh"));
        list.showList();

        System.out.println(list.indexOf(new MyData(2, "lee")));

        System.out.println(list.remove(0));
        list.showList();
        System.out.println(list.remove(5));
        list.showList();
        System.out.println(list.remove(list.size()-1));
        list.showList();

        System.out.println(list.indexOf(new MyData(11, "han")));
        System.out.println(list.remove(new MyData(11, "han")));
        list.showList();


    }
}

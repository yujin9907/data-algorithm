package d9;


public class MyLikedList0 {

    class Node {
        int data;
//        Node prev; // 더블리스트인 경우?? 먼데 이게
        Node next;

        public Node(int d) {
            this.data = d;
            next = null;
        }

        public String toString() {
            return ""+data;
        }
    }

    Node head;

    public MyLikedList0() {
        head = null;
    }

    public boolean isEmpty() {
        return (head==null);
    }

    public void add(int value) {
        addFirst(value);
        addLast(value);
    }

    private void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next=head;
        head=newNode;
    }
    private void addLast(int value) {
        if (isEmpty()) {
            addFirst(value);
        } else {
            Node newNode = new Node(value);
            Node p = head;
            while (p.next != null) {
                p=p.next;
            }
            p.next = newNode;
        }
    }

    public int indexOf(int value) {
        int index = -1;
        Node p = head;
        while (p!=null) {
            if (p.data == value) {
                return ++index;
            } else {
                index++;
                p=p.next;
            }
        }
        return -1;
    }

    public void add(int index, int value) {
        if (checkIndexRange(index)) {
            if (index == 0) {
                addFirst(value);
            }

            Node newNode = new Node(value);
            int i=1; // 위에서 0일때 addFirst 하고 내려오기 때문에 1부터 시작
            Node p = head;

            while (p.next != null) {
                if (i==index) {
                    newNode.next=p.next;
                    p.next = newNode;
                    return;
                } else {
                    i++;
                    p=p.next;
                }
            }
        }
        else if (index>=size()) {
            addLast(value);
        }
    }

    public int size() {
        int n=0;
        Node p = head;
        while (p!=null) {
            n++;
            p=p.next;
        }
        return n;
    }

    public String toString() { // 뭘하든 링크드리스트에서는 헤드로부터 쭉 따라가는 작업이 필요하다
        String str="";
        Node p = head;
        while (p!=null) {
            str = str + p.data + " ";
            p=p.next;
        }
        return str;
    }

    public boolean checkIndexRange(int index) {
        if (index>=0 && index<size()) {
            return true;
        } else {
            return false;
        }
    }

    public void showList() {
        System.out.println(toString());
    }

    // TODO 결과가 이게 맞나 확인
    public static void main(String[] args) {

        int [] data = {113,  336,  74,  71,  86,  176,  313,  80,  225,  342,
                170,  292,  275,  266 , 79,  16,  109,  175 , 245,  156,
                50,  61,  277,  167,  81,  24,  76,  186,  78,  101,
                301,  62,  152,  219,  294};

        MyLikedList0 list = new MyLikedList0();

        for (int i=0;i<10; i++)
            list.add(data[i]);  // cf :  list[i]=data[i]
        list.showList();
//
//        for (int i=4;i<10; i++)
//            list.add(data[i]);  // initial_capacity 확인하려고 위아래 두단계로 나눔
//        list.showList();
//
//        // get & set
//        list.set(5, 999);     // list[5]=999
//        int x =(int) list.get(5);  // cf : x = list[5]
//        System.out.println("\nx = "+x);
//
//        list.remove((Integer)336);
//        list.showList();
//
//        list.add(3, 111);
//        list.showList();
//        list.add(list.size(), 222);
//        list.showList();
//
//        list.clear();
//        list.showList();

    }
}

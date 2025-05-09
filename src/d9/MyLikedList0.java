package d9;


public class MyLikedList0 {

    // private : 구현을 하기 위한 구조체, 사용자는 몰라도 됨
    // equal, <, > : 비즈니스 업무에 의한 로직(라이브러리가 아니라 사용자 영역에서 정의할 것)
    class Node {
        // Node prev; // TODO 더블리스트인 경우
        Node next;
        int data;

        public Node(int d) {
            this.data = d;
            next = null;
        }

        public String toString() {
            return ""+data;
        }
    }

    Node head;
    int size;

    public MyLikedList0() {
        head = null;
    }

    public boolean isEmpty() {
        return (head==null);
    }
    // isFull() : 링크드리스트는 제한이 없음. 버추얼머신에서 허용하는한 무한히

    public void add(int value) {
        // 수업시간 임의로 지정 : 해드에 바로 붙은 게 first, 헤드에서 가장 먼 게 last
        // 성능면에 있어서 first 가좋음
        // 단, arrayList 는 last 로 구현되어 있음
        addFirst(value);
//        addLast(value);
    }

    private void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next=head;
        head=newNode;

        size++;
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

        size++;

    }

    public int indexOf(int value) {
        int index = 0;
        Node p = head;
        while (p != null) {
            if (p.data == value) {
                return index;
            }
            index++;
            p = p.next;
        }
        return -1;
    }

    // TODO 여기도 사이즈 들어가나? 확인
    public void add(int index, int value) {
        if (checkIndexRange(index)) {
            if (index == 0) {
                addFirst(value);
                return;
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
        // 이렇게 사용하거나, 전역변수 size 선언 (전역변수가 성능에서 유리함, 실제 라이브러리 구현)
//        int n=0;
//        Node p = head;
//        while (p!=null) {
//            n++;
//            p=p.next;
//        }
//        return n;
        return size;
    }

    public void clear() {
        head = null;
    }

    public boolean contains(int value) {
        return (indexOf(value) != -1);
    }

    public int get(int index) {
        int i = 0;
        Node p = head;

        while (p != null) { // p.next 가 아니어도 됨 TODO 왜?
            if (i==index) {
                return p.data;
            }
            i++;
            p=p.next;
        }
        return -999;
    }

    public void set(int index, int value) {
        int i = 0;
        Node p = head;

        while (p != null) { // p.next 가 아니어도 됨 TODO 왜?
            if (i==index) {
                p.data = value;
                return;
            }
            i++;
            p=p.next;
        }
        // error msg 또는 void
    }

    public int remove(int index) { // return the value (removed)
        int ret = -999; // = null

        if (checkIndexRange(index)) {
            if (index == 0) {
                ret = removeFirst();
            } else {
                int i = 1;
                Node p = head;
                Node q = p.next;
                while (q != null) {
                    if (i == index) {
                        ret = q.data;
                        p.next = q.next;
                        // 왜 이걸로 해야 되냐 : 싱글링크드는 한번 가면 앞으로 돌아올 방법이 없기 때문에 -> 이걸 보완해서 앞뒤로 움직이도록 더블링크드를 사용함
                        break;
                    }
                    i++;
                    p=q;
                    q=q.next;
                }
            }
        }
        return ret;
    }

    public int remove(Object value) {
        if (head != null) {
            if (head.data == (int) value) {
                return removeFirst();
            }
            Node p = head;
            Node q = p.next;
            while (q!=null) {
                if (q.data == (int) value) {
                    p.next = q.next;
                    return q.data;
                }
                p=q;
                q=q.next;
            }
        }
        return -999;
//
//
//        int index = indexOf((int) value);
//        return remove(index);
    }

    public int removeFirst() {
        int ret = -999; // = null

        if (head != null) {
            ret = head.data;
            head = head.next; // head remove
        }

        return ret;
    }

    public void remove() {

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

    // TODO 결과 확인
    public static void main(String[] args) {

        int [] data2 = {113,  336,  74,  71,  86,  176,  313,  80,  225,  342,
                170,  292,  275,  266 , 79,  16,  109,  175 , 245,  156,
                50,  61,  277,  167,  81,  24,  76,  186,  78,  101,
                301,  62,  152,  219,  294};

        MyLikedList0 list = new MyLikedList0();

        for (int i=0;i<10; i++) {
            list.add(data2[i]);  // cf :  list[i]=data[i]
        }

        list.showList();

    }
}

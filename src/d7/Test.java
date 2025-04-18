package d7;

public class Test {
    public static void main(String[] args) {
        // 이중중첩 예시
        MyArrayList2<MyArrayList1> list = new MyArrayList2<>();
//        MyArrayList2<MyArrayList2<MyData>> list = new MyArrayList2<>(); // 이런 것도 가능함. list.get.get.get...

        MyArrayList1 a = new MyArrayList1();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        MyArrayList1 b = new MyArrayList1();
        b.add(11);
        b.add(12);
        b.add(13);

        list.add(a);
        list.add(b);

        list.showList();
        list.get(0).get(2);
        list.get(0).set(2, 30);
    }
}

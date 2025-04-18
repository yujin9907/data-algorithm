package d7;

import java.util.Arrays;

/*
MyArrayList1 + 제너릭 적용
 */
public class MyArrayList2<T> {
    final int INITIAL_CAPACITY = 5; // final = 불변
    T[] array; // 저장공간 크기
    int capacity; // 전체 공간의 크기
    int size; // 현재 element 의 크기

    public MyArrayList2() {
        capacity = INITIAL_CAPACITY;
        array = (T[]) new Object[capacity]; // 크기가 고정돼야 하기 때문에 특정 타입 필요
        size = 0;
    }

    public boolean isEmpty() {
        return (size==0);
    }

    public int indexOf(T value) {
        for (int i=0; i<size; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1; // -1 means "not found"
    }

    public void add(T value) {
        if (isFull()) {
            grow();
        }
        array[size++] = value;
    }

    private boolean isFull() {
        return (size==capacity);
    }

    public void add(int index, T value) {
        if (checkIndexRange(index)) {
            if (isFull()) {
                grow();
            }

            System.arraycopy(array, index, array, index+1, size-index);
            array[index] = value;
            size++;

        } else if (index==size) {
            add(value);
        }
    }

    // 배열 크기 늘리기 (array 라이브러리 내에서도 해당 메서드명으로 이와 같이 구현됨)
    private void grow() {
        T[] tempArray = (T[]) new Object[capacity*2];
        for (int i=0; i<capacity; i++) {
            tempArray[i] = array[i];
        }
        array = tempArray;
        capacity *= 2;
    }

    private boolean checkIndexRange(int index) {
        if (index>= 0 && index<size) {
            return true;
        }
        return false;
    }

    public void clear() {
        Arrays.fill(array, null); // 모두 0으로 초기화와 같음
    }

    public boolean contains(T value) {
        return !(indexOf(value) ==-1);
    }

    public boolean remove(T value) {
        int index = indexOf(value);
        if (checkIndexRange(index)) {
            System.arraycopy(array, index+1, array, index, size-index-1);
            size--;
            return true;
        }
        return false;
    }

    public T remove(int index) {
        if (checkIndexRange(index)) {
            T returnValue = array[index];
            // 위와 같은 로직
            System.arraycopy(array, index+1, array, index, size-index-1);
            size--;
            return returnValue;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (checkIndexRange(index)) {
            return array[index];
        }
        return null; // return type object 이므로. 앞으로 결과가 없으면 null 을 자주 사용한다
    }

    public void set(int index, T value) {
        if (checkIndexRange(index)) {
            array[index] = value;
        }
    }

    public String toString() {
        // 오버라이드 안 하면 헥사코드로 리턴해서 재정의함
        String returnValue = "";
        // ret = ret+14 // 14도 string 으로 처리 되는 원리를 이용하여
        for (int i=0; i<size; i++) {
            if (array[i] == null) continue;
            returnValue = returnValue+array[i].toString()+" "; // T 타입에 오버라이드 된 tostring() 을 찍을 수 있도록(없으면 헥사코드)
        }

        return returnValue;
    }

    public void showList() {
        System.out.print("Current List Status : ");
        System.out.println(toString());
        System.out.println(">>> Current Capacity = " + capacity + "         Size = "+size);
    }

    public static void main(String[] args) {

        int [] data = {113,  336,  74,  71,  86,  176,  313,  80,  225,  342,
                170,  292,  275,  266 , 79,  16,  109,  175 , 245,  156,
                50,  61,  277,  167,  81,  24,  76,  186,  78,  101,
                301,  62,  152,  219,  294};

        MyArrayList2<Integer> list = new MyArrayList2<>(); // 뒤쪽 타입은 앞 선언부를 따라서 생략 가능

        for (int i=0;i<4; i++)
            list.add(data[i]);  // cf :  list[i]=data[i]
        list.showList();

        for (int i=4;i<10; i++)
            list.add(data[i]);  // initial_capacity 확인하려고 위아래 두단계로 나눔
        list.showList();

        // get & set
        list.set(5, 999);     // list[5]=999
        int x =(int) list.get(5);  // cf : x = list[5]
        System.out.println("\nx = "+x);

        list.remove((Integer)336);
        list.showList();

        list.add(3, 111);
        list.showList();
        list.add(list.size(), 222);
        list.showList();

        list.clear();
        list.showList();

        // 제너릭 리스트 사용 예시
        MyArrayList2<MyData> list2 = new MyArrayList2<>();
        MyData a = new MyData(1, "aaa");
        MyData b = new MyData(2, "bbb");
        MyData c = new MyData(3, "ccc");
        list2.add(a);
        list2.add(b);
        list2.add(c);
        list2.showList();

        // equal 을 정의해야 하는 이유(value 가 아니라 참조값을 확인함)
        System.out.println(list2.contains(a));
        System.out.println(list2.contains(new MyData(1, "aaa")));
    }
}

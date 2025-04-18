package d7;

import java.util.Arrays;

public class MyArrayList0 implements MyList {
    final int INITIAL_CAPACITY = 5; // final = 불변
    int[] array; // 저장공간 크기
    int capacity; // 전체 공간의 크기
    int size; // 현재 element 의 크기

    public MyArrayList0() {
        capacity = INITIAL_CAPACITY;
        array = new int[capacity];
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return (size==0);
    }

    @Override
    public int indexOf(Object value) {
        for (int i=0; i<size; i++) {
            if (array[i] == (int) value) {
                return i;
            }
        }
        return -1; // -1 means "not found"
    }

    @Override
    public void add(Object value) {
        if (isFull()) {
            grow();
        }
        array[size++] = (int) value;
    }

    private boolean isFull() {
        return (size==capacity);
    }

    @Override
    public void add(int index, Object value) {
        if (checkIndexRange(index)) {
            if (isFull()) {
                grow();
            }

            System.arraycopy(array, index, array, index+1, size-index);
            array[index] = (int) value;
            size++;

        } else if (index==size) {
            add(value);
        }
    }

    // 배열 크기 늘리기 (array 라이브러리 내에서도 해당 메서드명으로 이와 같이 구현됨)
    private void grow() {
        int[] tempArray = new int[capacity*2];
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

    @Override
    public void clear() {
        Arrays.fill(array, 0); // 모두 0으로 초기화와 같음
    }

    @Override
    public boolean contains(Object value) {
//        if ( int i = 0;i < size;i++) {
//            if (array[i] == ((int) value)) {
//                return true;
//            }
//        }
//        return false;

        return !(indexOf(value) ==-1);
    }

    @Override
    public boolean remove(Object value) {
        int index = indexOf(value);
//         remove(index); // remove(int index) 가 같은 코드를 구현하고 있으므로
        if (checkIndexRange(index)) {
//            for (int i=index+1; i<size; i++) {
//                array[i-1] = array[i];
//                size--;
//                return true;
//            }
            System.arraycopy(array, index+1, array, index, size-index-1);
            size--;
            return true;
        }
        return false;
    }

    @Override
    public Object remove(int index) {
        if (checkIndexRange(index)) {
//            for (int i=index+1; i<size; i++) {
//                array[i-1] = array[i];
//                size--;
//                return true;
//            }
            // 위와 같은 로직
            System.arraycopy(array, index+1, array, index, size-index-1);
            size--;
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int index) {
        if (checkIndexRange(index)) {
            return array[index];
        }
        return null; // return type object 이므로. 앞으로 결과가 없으면 null 을 자주 사용한다
    }

    @Override
    public void set(int index, Object value) {
        if (checkIndexRange(index)) {
            array[index] = (int) value;
        }
    }

    @Override
    public String toString() {
        // 오버라이드 안 하면 헥사코드로 리턴해서 재정의함
        String returnValue = "";
        // ret = ret+14 // 14도 string 으로 처리 되는 원리를 이용하여
        for (int i=0; i<size; i++) {
            returnValue = returnValue+array[i]+" ";
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

        MyArrayList0 list = new MyArrayList0();

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

    }

}

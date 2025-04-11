package d6;


public class MyArrayList0 {

    public MyArrayList0 (int n) {
    }

    private boolean isFull() {
        return false;
    }
    public boolean isEmpty() {
        return false;
    }

    public int indexOf(int value) {
        return -1;
    }

    public void add(int value) {
    }

    public void add(int index, int value) {
    }

    public void clear() {
    }


    public boolean contains(int  value) {
        return true;
    }

    public int remove(int index) {
        return -1;
    }

    public int removeWithValue(int value) {
        return -1;
    }

    public int size() {
        return -1;
    }

    public int get(int index) {
        return -1;
    }

    public void set(int index, int value) {
    }

    public void showList() {
//		System.out.println("\n[ Current List ] ");
//		System.out.println("Size is : "+size());
//		for (int i=0;i<currentSize; i++)
//			System.out.print(array[i]+"  ");
    }

    public static void main(String[] args) {

        int [] data = {113,  336,  74,  71,  86,  176,  313,  80,  225,  342,
                170,  292,  275,  266 , 79,  16,  109,  175 , 245,  156,
                50,  61,  277,  167,  81,  24,  76,  186,  78,  101,
                301,  62,  152,  219,  294};

        MyArrayList0 list = new MyArrayList0(20);

        for (int i=0;i<10; i++)
            list.add(data[i]);
        list.showList();

    }

}
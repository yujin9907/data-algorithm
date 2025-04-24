package d4;

// 삽입 버블
public class MySort {


    public static void main(String[] args) {
        int [] data = {113,  336,  74,  71,  86,  176,  313,  80,  225,  342,
                170,  292,  275,  266 , 79,  16,  109,  175 , 245,  156,
                50,  61,  277,  167,  81,  24,  76,  186,  78,  101,
                301,  62,  152,  219,  294};

        System.out.println("\n< Initial Data >");
        showData(data);

// deep copy data to another array, dataSorted, for argument...
// call each sort method
// showData(dataSorted)
//
//		MySort ms = new MySort();
//		int [] dataSorted = new int[data.length];
//
//		System.out.println("\n< ---- Sort >");
//		dataSorted=data.clone();
//		ms.----Sort(dataSorted);
//		showData(dataSorted);


        /*
        깊은 복사 : for 문으로 직접 data -> toBeSorted 로 옮기는 과정으로써
        얕은 복사 : 참조값을 가리키는 복사

         프로그램 필요 메모 할당을 위한 기본 구조
          1. 코드 저장하는 공간 : 기본자료형 메모리 할당됨
          2. 힙 공간 런타임스택 : 클래스 및 배열 할당(이 내부의 값(기본자료형)은 위 (1)을 참조함)
          3. 프로그램카운터(레지스터)

          즉, 아래와 같이 사용시, 참조값을 가리키기 때문에 toBeSorted, data 배열 둘 다 수정되는 것처럼 보임.
          int[] toBeSorted = data; // 얕은 복사
         */

        MySort ms = new MySort();

        System.out.println("------------------");
        int[] toBeSorted = data.clone(); // 깊은 복사
        ms.selectionSort2(toBeSorted, toBeSorted.length-1);
        showData(toBeSorted);

        System.out.println("2------------------");
        toBeSorted = data.clone(); // 깊은 복사
        ms.insertionSort(toBeSorted);
        showData(toBeSorted);

        System.out.println("3------------------");
        toBeSorted = data.clone(); // 깊은 복사
        ms.bubbleSort(toBeSorted);
        showData(ms.bubbleSort(toBeSorted));
    }

    // 선택정렬 반복
    public int[] selectionSort(int[] data) {
        // arg 위치와 return address 메모리에 올림. 즉, 참조값을 직접 변경하게 되므로 void 도 되고... 의미를 명확히하기 위해 int[] 로 함
        int n = data.length;

        for(int i=n-1; i>0; i--) {
            int maxIndex = i;
            for (int j=0; j<i-1; j++) {
                if (data[j]>data[maxIndex]) {
                    maxIndex = j;
                }
            }
            swap(data, maxIndex, i);
        }
        return data;
    }

    // 선택정렬 재귀
    public int[] selectionSort2(int[] data, int n) { // n = last index
        if (n==0) {
            return data;
        }

        int maxIndex = n;
        for (int j=0; j<n; j++) {
            if (data[j]>data[maxIndex]) {
                maxIndex = j;
            }
        }
        swap(data, maxIndex, n);

        return selectionSort2(data, n-1);
    }

    // 삽입정렬 반복
    // 삽입정렬 재귀는 피보처럼 부분 완성의 중복이 많아서 성능 문제
    public int[] insertionSort(int[] data) {
        int n = data.length;

        for (int i = 1; i<n; i++) {
            int value = data[i];

            int j=i-1;
            while (j>=0 && (data[j] > value)) {
                j--;
            }

            int myPosition = j+1;
            int k = i-1;
            while (k>=myPosition) {
                data[k+1] = data[k];
                k--;
            }
            data[myPosition] = value;
        }
        return data;
    }

    // bubble sort
    public int[] bubbleSort(int[] data) {
        int n = data.length;

        for (int i=n-1; i>=0 ; i--) {
            for (int j=0; j<=i-1; j++) {
                if (data[j] > data[j+1]) {
                    swap(data, j, j+1);
                }
            }
        }
        return data;
    }

    // swap (이것도 void 로 해도 됨)
    private int[] swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
        return data;
    }


    // 출력용
    private static void showData(int[] data) {
        int nData = data.length;
        int nPrinted=0;
        while(nPrinted<nData) {
            for (int i=0;(nPrinted<nData)&&(i<10); i++) {
                System.out.printf("%6d ",data[nPrinted++]);
            }
            System.out.println();
        }
    }
}

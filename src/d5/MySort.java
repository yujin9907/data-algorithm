package d5;

// 퀵, 머지
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
        MySort ms = new MySort();
        int [] dataSorted = new int[data.length];

        System.out.println("\n< Quick Sort >");
        dataSorted=data.clone(); // 깊은 복사
//		ms.quickSort(dataSorted, 0, data.length); // 리컬전 호출 시, 다만 구현 내부를 알아야 하기 때문에 좋지 않은 방법
        ms.quickSort(dataSorted);
        showData(dataSorted);

        System.out.println("\n< Merge Sort >");
        dataSorted=data.clone(); // 깊은 복사
        ms.mergeSort(dataSorted);
        showData(dataSorted);

    }

    // 퀵 정렬
    public int[] quickSort(int[] data) { // 앞 인덱스 끝 인덱스가 없어서 리컬시브하게 적용하기 힘듦
        return quickSort(data, 0, data.length-1);
    }

    // 퀵 (데이터, 시작인덱스, 끝인덱스)
    private int[] quickSort(int[] data, int p, int r) { // 사용자가 내부로직을 몰라도 되도록 오버로딩 (cf. 오버라이딩은 상속에서 재정의 시)
//        if (p==r) return data; { // base condition ; 아래와 같이 사용하여 간소화

        if (p < r) {
            int q = partition(data, p, r); // 파티션의 결과로 피벗 확정
            quickSort(data, p, q-1); // 왼쪽
            quickSort(data, q+1, r); // 오른쪽
        }
        return data;
    }

    // 퀵 1
    public int partition(int[] data, int p, int r) {
        int pivot = r; // 맨 뒤 피봇(기준값)
        int left = p;
        int right = r;

        // 전체를 피봇 기준 오른쪽 정렬(피봇보다 큰 거 모으기)
        while (left < right) {
            while (data[left] < data[pivot]) {
                left++;
            }
            while (data[right]>=data[pivot] && right>left) {
                right--;
            }
            if (left<right) {
                swap(data, left, right);
            }
        }
        swap(data, pivot, left); // 이미 피봇보다 다 큰 걸로 정렬됐으므로 피봇만 바꿔주면 됨
        return left;
    }

    // 퀵2 (간결한 방법)
    private int partition2(int[] data, int p, int r) {
        int x = data[r]; // 피봇 : 맨 뒤
        int k = p-1; // number of left subset, 피봇값보다 작은 것의 개수 카운트 = 인덱스 // k 는 인덱스이므로 p-r 범위인데 시작 전이니까 p-1로 설정함

        for (int i=p; i<r; i++) {
            if (data[i]<x) {
                swap(data, ++k, i);
            }
        }

        // k = 왼쪽 subset 의 개수(마지막 인덱스)
        swap(data, k+1, r);
        return k+1;
    }

    // merge sort
    public int[] mergeSort(int[] data) {
        return mergeSort(data, 0, data.length-1);
    }

    private int[] mergeSort(int[] data, int p, int r) { // 배열, 시작인덱스, 끝인덱스
        if (p < r) {
            int q=(p+r)/2;
            mergeSort(data, p, q);
            mergeSort(data, q+1, r);
            merge(data, p, q, r);
        }
        return data;
    }

    private int[] merge(int[] data, int p, int q, int r) {
        int[] temp = new int[data.length];

        // merge {data[p], ... data[q]} && {data[q+1], ... data[r]}
        int i=p; // 각배열 머지할 데이터들의 위치를 어디까지 비교했나1
        int j=q+1; // 각배열 머지할 데이터들의 위치를 어디까지 비교했나2
        int k=p; // temp 어디까지 썻나


        while (i<=q && j<=r) {
            if (data[i]<data[j]) {
//                temp[k] = data[i];
//                i++;
//                k++;
                temp[k++] = data[i++];
            } else {
                temp[k++] = data[j++];
            }
        }
        // j 는 끝났는데, i 가 남은 상황
        while (i<=q) {
            temp[k++] = data[i++]; // 쭉 붙여주면 됨
        }

        // i 는 끝났는데, j 가 남은 상황
        while (j<=r) {
            temp[k++] = data[j++]; // 쭉 붙여주면 됨
        }

        // temp 에 있는 정렬 결과 반영
        for (int l=p; l<=r; l++) {
            data[l] = temp[l];
        }

        return data;
    }

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

    private int[] swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
        return data;
    }

}

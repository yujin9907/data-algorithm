package d2;

// 순차 검색, 이진(바이너리) 검색
public class Search {

    public static void main(String[] args) {
        int[] data = {10, 45, 40, 20, 15, 25, 5, 30, 35, 55}; // 안정렬데이터
        int[] sData = {5, 0, 15, 20, 25, 30, 35, 40, 45, 50, 55}; // 정렬데이터

        Search s = new Search();
        // 순차
        System.out.println(s.seqS(data, 25)); // 정렬 X
        System.out.println(s.seqSortedS(sData, 25)); // 정렬 O
        System.out.println(s.seqSRec(data, data.length, 25)); // 재귀
        System.out.println(s.seqSRec(data, data.length-1, 25));
        // 이진
        System.out.println(s.binS(sData, 25, 0, (sData.length - 1)));
        System.out.println(s.binSIteration(sData, 25, 0, (sData.length - 1)));

    }



    // 순차검색 : avg, worst = O(N), best = O(1)
    public int seqS(int[] d, int key) {
        /* ver1
        for (int i=0; i<d.length; i++) {
            if (d[i]==key) {
                return i;
            }
        }
        */

        // ver2
        int index = 0;
        while (index < d.length) {
            if (d[index] == key) {
                return index;
            } else {
                index++;
            }
        }

        return -1;
    }

    // 정렬된 순차검색
    public int seqSortedS(int[] d, int key) {

        int index = 0;
        while (index < d.length) {
            if (d[index] == key) {
                return index;
            } else if (d[index] > key) { // 정렬이 돼있다면, 최악의 상황(찾는 수가 없을 때, ..)에서 더 빠르게 처리
                return -1;
            } else {
                index++;
            }
        }

        /* 조건문을 통해 더 간결하게 쓸 수 있음
        while (index<d.length && d[index]<= key) {
            if (d[index]==key) {
                return index;
            } else {
                index++;
            }
        }
        */

        return -1;
    }

    // 순차검색 재귀
    public int seqSRec(int[] d, int n, int key) {
        if (n==0) {
            return -1;
        } else if (d[n-1]==key) {
            return n-1;
        } else {
            return seqSRec(d, n-1, key);
        }
//         Arrays.binarySearch(); // 자바의 바이너리 서치 라이브러리 있다고 설명하심
    }

    // 이진검색 재귀 : best = O(1), worst, avg = O(n)
    public int binS(int[] d, int key, int start, int end) { // 데이터, 찾을값, 인덱스시작, 인덱스끝
        // valid
        if (start > end) return -1;

        // 로직
        int mid = (start + end) / 2;

        if (key == d[mid]) {
            return mid;
        } else if (key < d[mid]) {
            return binS(d, key, start, mid - 1);
        } else { // key>d[mid]
            return binS(d, key, mid + 1, end);
        }
    }

    // 이진검색 iteration
    public int binSIteration(int[] d, int key, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (key == d[mid]) {
                return mid;
            } else if (key < d[mid]) {
                end = mid - 1;
                continue;
            } else {
                start = mid + 1;
                continue;
            }
        }
        return -1;
    }

}

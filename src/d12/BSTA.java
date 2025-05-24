package d12;

import java.util.Arrays;

// BST 를 arr 로 구현
public class BSTA {
    int[] array;
    int numNode;

    public BSTA() {
        array = new int[100];
        Arrays.fill(array, -1);
        numNode = 0;
    }

    public void insert(int d) {
        if (numNode == 0) {
            array[1] = d;
            numNode++;
        } else {
            int i = 1;
            while (array[i]!=-1) {
                if (d<array[i]) {
                    i = i*2; // 왼쪽 자식 인덱스
                } else {
                    i = i*2+1; // 오른쪽 자식 인덱스
                }
            }
            array[i] = d;
            numNode++;
        }
    }

    public void showTree() {
        for(int i=1; i<=30; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        int[] keys = {1,2,3,4,5,...,9}; // 이런 경우 길이 오류. 즉, arr 낭비가 심하므로 linkedList 로 구현하는 게 맞음
        int[] keys = {4, 7, 5, 1, 0, 3, 9, 2, 6, 8};


        BSTA t = new BSTA();

        for (int i = 0; i < keys.length; i++) {
            t.insert(keys[i]);
            t.showTree();
        }
    }
}

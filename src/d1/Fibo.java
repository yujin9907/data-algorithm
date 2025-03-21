package d1;

import java.util.ArrayList;

// 과제 제출(이번주는 안함)
// 피보나치 알고리즘을 이터래셔널 vs 재귀를 비교하기 위함
public class Fibo {
    // 1. 이터래셔널 (어래이를  만들지 않아도 됨, 변수를 선언해서 계속 재할당해도 됨)
    public static int interater(int n) {
        int[] val = new int[n+1];

        val[0] = 0;
        val[1] = 1;

        for (int i =2; i<n; i++){
            val[i] = val[i-1]+val[i-2];
        }

        return val[n];
    }

    // 2. 재귀
    public static int rec(int n) {
        if (n<=2) {
            return 1;
        } else {
            return rec(n-1)+rec(n-2);
        }
    }


    public static void main(String[] args) {
        Fibo f = new Fibo();

        System.out.println("Iteration :"+interater(1));
        System.out.println("Recu..재귀 :"+rec(1));
    }


}

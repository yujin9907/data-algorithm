package d1;

import java.util.ArrayList;
import java.util.Arrays;

// 과제 제출(이번주는 안함)
// 피보나치 알고리즘을 이터래셔널 vs 재귀를 비교하기 위함
public class Fibo {
    int count = 0;


    // 1. 이터래셔널 (어래이를  만들지 않아도 됨, 변수를 선언해서 계속 재할당해도 됨)
    public int interater(int n) {
        int[] val = new int[n+1];

        val[0] = 0;
        val[1] = 1;

        for (int i =2; i<n; i++){
            count++;
            val[i] = val[i-1]+val[i-2];
        }

        return val[n];
    }

    // 2. 재귀
    public  int rec(int n) {
        count++;
        if (n<=2) {
            return 1;
        } else {
            return rec(n-1)+rec(n-2);
        }
    }

    // 3. 2025.03.28 Maze 동적계획법 복습
    int[] memo;

    public Fibo() {
        this.memo = new int[50]; // 입력값을 알 수 없음. (array 에서는 동적할당 불가능)
        Arrays.fill(memo, -1); // 값을 할당하는 내부로직은 for 로 maze 생성과 같음

        // 초기값
        memo[0] = 0;
        memo[1] = 1;
    }

    // 실행확인해야됨(25.03.28)
    public int fiboRecMemo(int n) {

        if (n<2) {
            return memo[n];
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        count++; // 25.03.28 카운트 위치 확인


        if (memo[n-1] == -1) {
            memo[n-1] = fiboRecMemo(n-1);
        }

        if (memo[n-2] == -1) {
            memo[n-2] = fiboRecMemo(n-2);
        }

        memo[n] = fiboRecMemo(n-1) + fiboRecMemo(n-2);
        return memo[n];
    }

    public void resetCount() {
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        Fibo f = new Fibo();

        f.resetCount();
        System.out.println("Iteration :"+f.interater(20));
        System.out.println("Iteration cnt :" +f.getCount());

        f.resetCount();
        System.out.println("Recu..재귀 :"+f.rec(20));
        System.out.println("Re :"+f.getCount());

        f.resetCount();
        System.out.println("Recursion + Memoization : "+f.fiboRecMemo(20));
        System.out.println("R+M count:" + f.getCount());
    }


}

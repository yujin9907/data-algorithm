package d1;

import java.util.*;

public class Euclid {

    // 왜 static 을 작성했는지 설명함
    // static 에 인스턴스를 별도로 생성해서 실행시켜야 하기 때문에, 귀찮으니 그냥 static 으로 메서드ㅡ 생성
    public static void main(String[] args) {
        int a = 1;
        int b = 2;

        while (true) {
            if (a<b) {
                int temp = a;
                a=b;
                b=temp;
            }
            int r = a%b;
            if (r==0) {
                System.out.println("GCD = " + GCDRec(a, b));
                break;
            } else {
                a=b;
                b=r;
            }
        }
    }

    // 재귀호출 예시
    public static int GCDRec(int a, int b) {
        if (a<b) {
            return GCDRec(b, a);
        } else {
            int r=a%b;
            if(r==0) {
                return b;
            } else {
                return GCDRec(b, r);
            }
        }
    }
}

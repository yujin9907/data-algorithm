package d6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyQueue {

    int[] queue;
    int front, rear, queueSize; // rear == 저장할 장소, 큐사이즈는 없어도 됨


    public MyQueue(int n) {
        queueSize = n;
        queue = new int[queueSize];
        front=0;
        rear=1;
    }
    public boolean isEmpty() {
        return ((front+1)%queueSize == rear);
    }
    public boolean isFull() {
        return front == rear;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println(">>> Queue Full...");
            return;
        }

        queue[rear] = value;
//        rear++;
        rear=(rear+1)%queueSize; // 왜 +1 대신 이거냐
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println(">>> Queue Empty...");
            return -999;
        }

        front = (front+1)%queueSize;
        return queue[front];
    }

    public void showQueue() {
//        for(int i=)
        System.out.println(Arrays.toString(queue));
    }


    public static void main(String[] args) {
        int [] data= {3,5,4,1,7,2,9,8,6,0};

        /* Interface
        list - arrayList, linkedList
        List() 를 new 할 수 없고, 추상화하 ㄴ거임. 구현체를 객체로 생성하여 사용해야 됨
        */
        List<Integer> list = new ArrayList<>();


        MyQueue queue = new MyQueue(10);

        // 출력결과 맨 앞 0 = 못 쓰는 한칸 -> 위 data 에서 마지막 0 은 넣지 못함 -> 그래서 어떻게 하라고
        for (int i=0; i<data.length;i++) {
            queue.enqueue(data[i]);
            queue.showQueue();
        }

        // 뺄 때도 끝이었던 0은 못 뺌
        for (int i=0; i<data.length;i++) {
            System.out.println(queue.dequeue());
//            queue.dequeue();
//            queue.showQueue();
        }
    }
}
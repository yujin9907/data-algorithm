package d6;

public class MyQueue {

    public MyQueue(int n) {

    }

    public void enqueue(int value) {

    }

    public int dequeue() {

        return 0;
    }

    public void showQueue() {

    }

    public static void main(String[] args) {
        int [] data= {3,5,4,1,7,2,9,8,6,0};


        MyQueue queue = new MyQueue(10);

        for (int i=0; i<data.length;i++) {
            queue.enqueue(data[i]);
            queue.showQueue();
        }

        for (int i=0; i<data.length;i++) {
            queue.dequeue();
            queue.showQueue();
        }
    }
}
package d6;


// Lib 에 이거 그대로 사용하려고 MyStack 만듦
public class MyStack0 {

    int[] stack;
    int top;
    int stackSize;

    public MyStack0(int n) { // 개수 n개인 스택 생성
        stackSize = n;
        stack = new int[n];
        top = 0;
    }

    public boolean isEmpty() {
        if (top==0) return true;
        return false;
    }

    public boolean isFull() {
        return top==stackSize;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println(">>> Stack Full...");
            return;
        }
//        stack[top+1] = value;
//        top++;
        stack[top++] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println(">>> Stack Empty...");
            return -999; // 그냥 에러코드로 지정
        }

        return stack[--top];
    }

    public void showStack() {
        for(int i=0; i<top; i++) {
            System.out.print("  " + stack[i]);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] data = {3, 5, 4, 1, 7, 2, 9, 8, 6, 0};


        MyStack0 stack = new MyStack0(10);

        for (int i = 0; i < data.length; i++) {
            stack.push(data[i]);
            stack.showStack();
        }

        for (int i = 0; i < data.length; i++) {
            stack.pop();
            stack.showStack();
        }

    }

}
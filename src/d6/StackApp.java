package d6;

import lib.MyStack;

public class StackApp {

    public static void main(String[] args) {
        int[] data = {3, 5, 4, 1, 7, 2, 9, 8, 6, 0};

        // 기본
        MyStack<Integer> stack = new MyStack<Integer>(10);

        for (int i = 0; i < data.length; i++) {
            stack.push(data[i]);
            stack.showStack();
        }

        for (int i = 0; i < data.length; i++) {
            stack.pop();
            stack.showStack();
        }

        // 2. 추가 : 다른 타입 가능하도록
//        MyStack stack2 = new MyStack(6);
//        stack2.push("aaa");
//        stack2.push("bbb");
//        stack2.showStack();

        // 3. 추가 : 타입을 받자
        MyStack<String> myStack3 = new MyStack<>(5);
        myStack3.push("3번 제네릭으로 타입을 받자");
        myStack3.showStack();
    }
}

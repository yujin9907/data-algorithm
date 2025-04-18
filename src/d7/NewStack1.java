package d7;

import lib.MyStack;

/*
MyArrayList2 활용
 */
public class NewStack1<T> {

    MyArrayList2<T> stack;

    public NewStack1() {

    }

    public void push (T value) {
        stack.add(value);
    }
    public T pop() {
        return stack.remove(stack.size -1 );
    }
    public T peak() {
        return stack.get(stack.size-1);
    }
    public void showStack() {
        stack.showList();
    }
    public static void main(String[] args) {

        int[] data = {3, 5, 4, 1, 7, 2, 9, 8, 6, 0};

        // 기본
        NewStack1<Integer> stack = new NewStack1<>();

        for (int i = 0; i < data.length; i++) {
            stack.push(data[i]);
            stack.showStack();
        }

        for (int i = 0; i < data.length; i++) {
            stack.pop();
            stack.showStack();
        }

        NewStack1<String> myStack3 = new NewStack1<>();
        myStack3.push("3번 제네릭으로 타입을 받자");
        myStack3.showStack();
    }
}

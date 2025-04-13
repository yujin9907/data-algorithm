package lib;


public class MyStack<T> {

//    int[] stack;
    Object[] stack;
    int top;
    int stackSize;

    public MyStack(int n) {
        stackSize = n;
        stack = new Object[n];
        top = 0;
    }

    public boolean isEmpty() {
        if (top==0) return true;
        return false;
    }

    public boolean isFull() {
        return top==stackSize;
    }

    public void push(T value) {
        if (isFull()) {
            System.out.println(">>> Stack Full...");
            return;
        }
        stack[top++] = value;
    }

//    // 오버라이딩해서 모든 타입을 지원하도록 (실제로 arraylist 같은 경우 이렇게 구현되어 있음) -> 근데 그럼 array 도 타입 별로? -> ㄴㄴ 오브젝트로
//    public void push(T value) {
//        if (isFull()) {
//            System.out.println(">>> Stack Full...");
//            return;
//        }
//        stack[top++] = value;
//    }

    public T pop() { // 오브젝트로 바꾸지 않고 그냥 보류함(라이브러리를 사용하기 위해 type object 변경 중)
        if (isEmpty()) {
            System.out.println(">>> Stack Empty...");
            return null;
        }

        return (T) stack[--top];
    }

    public void showStack() {
        for(int i=0; i<top; i++) {
            System.out.print("  " + stack[i].toString()); // 타입 객체 출력하면 해시코드 나와서 tostring
        }
        System.out.println();
    }



}
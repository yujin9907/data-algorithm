package finalExamStudy;

import java.util.ArrayList;
import java.util.List;

// 리스트 기반의 최소 힙 구조
public class ListMinHeap {

    List<Integer> heap;

    public ListMinHeap() {
        heap = new ArrayList<>();
        heap.add(null); // index 0은 사용 안 함
    }

    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    public int delete() {
        if (heap.size() <= 1) return -1;

        int min = heap.get(1);

        // 마지막 노드를 루트에 복사
        int lastIndex = heap.size() - 1;
        heap.set(1, heap.get(lastIndex));
        heap.remove(lastIndex);

        heapifyDown(1);
        return min;
    }

    private void heapifyUp(int i) {
        while (i > 1) {
            int parent = i / 2;
            if (heap.get(i) < heap.get(parent)) {
                swap(i, parent);
                i = parent;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int i) {
        int size = heap.size() - 1;
        while (2 * i <= size) {
            int left = 2 * i;
            int right = 2 * i + 1;
            int smaller = left;

            if (right <= size && heap.get(right) < heap.get(left)) {
                smaller = right;
            }

            if (heap.get(i) > heap.get(smaller)) {
                swap(i, smaller);
                i = smaller;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }

    public void showHeap() {
        System.out.print("Heap : ");
        for (int i = 1; i < heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListMinHeap heap = new ListMinHeap();
        int[] data = {5, 3, 8, 1, 9, 4};

        for (int x : data) {
            heap.insert(x);
            heap.showHeap();
        }

        System.out.println("Delete Min: " + heap.delete());
        heap.showHeap();
    }
}
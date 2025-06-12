package finalExamStudy;

import java.util.ArrayList;
import java.util.List;

public class ListMaxHeap {
    List<Integer> heap;

    public ListMaxHeap() {
        heap = new ArrayList<>();
        heap.add(null); // index 0은 사용 안 함
    }

    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    public int delete() {
        if (heap.size() <= 1) return -999;

        int max = heap.get(1);
        int lastIndex = heap.size() - 1;

        heap.set(1, heap.get(lastIndex));
        heap.remove(lastIndex);

        heapifyDown(1);
        return max;
    }

    private void heapifyUp(int i) {
        while (i > 1 && heap.get(i) > heap.get(i / 2)) {
            swap(i, i / 2);
            i = i / 2;
        }
    }

    private void heapifyDown(int i) {
        int size = heap.size() - 1;
        while (2 * i <= size) {
            int left = 2 * i;
            int right = 2 * i + 1;
            int larger = left;

            if (right <= size && heap.get(right) > heap.get(left)) {
                larger = right;
            }

            if (heap.get(i) < heap.get(larger)) {
                swap(i, larger);
                i = larger;
            } else break;
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void showHeap() {
        System.out.print("Heap: ");
        for (int i = 1; i < heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListMaxHeap heap = new ListMaxHeap();
        int[] data = {5, 3, 8, 1, 9, 4};

        for (int x : data) {
            heap.insert(x);
        }

        heap.showHeap(); // 최대값이 루트
        System.out.println("Delete Max: " + heap.delete());
        heap.showHeap(); // 삭제 후에도 여전히 최대 힙
    }
}
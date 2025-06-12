package finalExamStudy;

// 배열 기반의 최대 힙 구조
// 가장 큰 값이 루트가 되도록 구현
public class MaxHeap {

    int[] heap;
    int size;
    int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity + 1]; // heap[0]은 사용하지 않음
        size = 0;
    }

    public void insert(int value) {
        if (size == capacity) return;

        heap[++size] = value;
        int current = size;

        // 위로 올라가며 비교
        while (current > 1 && heap[current] > heap[current / 2]) {
            swap(current, current / 2);
            current = current / 2;
        }
    }

    public int delete() {
        if (size == 0) return -1;

        int max = heap[1];
        heap[1] = heap[size--];
        heapifyDown(1);

        return max;
    }

    private void heapifyDown(int i) {
        int left = 2 * i;
        int right = 2 * i + 1;
        int largest = i;

        if (left <= size && heap[left] > heap[largest]) {
            largest = left;
        }

        if (right <= size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            heapifyDown(largest);
        }
    }

    private void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    public void showHeap() {
        System.out.print("Heap : ");
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);
        int[] data = {5, 3, 8, 1, 9, 4};

        for (int x : data) {
            heap.insert(x);
            heap.showHeap();
        }

        System.out.println("Delete Max: " + heap.delete());
        heap.showHeap();
    }
}
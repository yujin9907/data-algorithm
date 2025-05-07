package midExam;

import java.util.Arrays;

public class Code1 {

	public int sum(int n) {
		int sum=0;
		for (int i=1;i<=n;i++)
			sum=sum+i;
		return sum;
	}

	//     Q1 : Complete sumRecursion		
	public int sumRecursion(int n) {
		if (n <= 1) return n;
		return n + sumRecursion(n - 1);
	}

	//	     Q2 : Complete merge in recursion				
	public int[] merge(int[] d1, int[] d2) {
		int [] result = new int[d1.length+d2.length];
		return merge(result, 0, d1, 0, d2, 0);
	}

	private int[] merge(int[] result,int k, int[] d1, int i, int[] d2, int j) { // (결과,전체-k,d1,d1-i,d2,d2-j)

		// d1이 없을 경우 d2 나머지 복사
		if (i == d1.length) {
			while (j < d2.length) {
				result[k++] = d2[j++];
			}
			return result;
		}

		// d2 없을 경우 d1 나머지 복사
		if (j == d2.length) {
			while (i < d1.length) {
				result[k++] = d1[i++];
			}
			return result;
		}

		// 둘 다 남을 경우, 작은값 비교
		if (d1[i] < d2[j]) {
			result[k] = d1[i];
			return merge(result, k + 1, d1, i + 1, d2, j);
		} else {
			result[k] = d2[j];
			return merge(result, k + 1, d1, i, d2, j + 1);
		}
	}

	//	     Q3 : Complete the methods of NewQueue class
	// TODO : 원형큐로?...
	public static class NewQueue {

		MyArrayList2<Integer> queue = new MyArrayList2<>();

		public void enqueue(int data) {
			queue.add(data); // 맨 끝 값 넣기
		}

		public int dequeue() {
			if (queue.size() == 0) {
				return -999;
			}
			int value = queue.get(0);
			queue.remove(0);
			return value;
		}

		public int peek() {
			if (queue.size() == 0) return -999;
			return queue.get(0);
		}

		public void showQueue() {
			System.out.println("Queue : "+queue.toString());
		}
	}

	public static void main(String[] args) {
		Code1 q1 = new Code1();
		System.out.println("\n<Q1> ");
		System.out.println("Sum Iteration : "+q1.sum(15));
		System.out.println("Sum Recursion : "+q1.sumRecursion(15));


		int [] d1= {10, 20, 55, 60, 80};
		int [] d2= {15, 30, 40, 75, 90};
		System.out.println("\n<Q2> ");
		System.out.println("Merge Result : "+ Arrays.toString(q1.merge(d1, d2)));

		int [] data= {3,5,4,1,7,2,9,8,0,6};
		NewQueue queue = new NewQueue();
		System.out.println("\n<Q3> ");

		for (int i=0; i<data.length;i++) {
			queue.enqueue(data[i]);
			queue.showQueue();
		}
		System.out.println("Peek Result : "+queue.peek());
		for (int i=0; i<data.length;i++) {
			queue.dequeue();
			queue.showQueue();
		}
	}
}

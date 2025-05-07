package midExam;

import java.util.Arrays;

public class Code1Review {

	public int sum(int n) {
		int sum=0;
		for (int i=1;i<=n;i++)
			sum=sum+i;
		return sum;
	}

	//     Q1 : Complete sumRecursion		
	public int sumRecursion(int n) {
		if (n <= 1)
			return n;
		else
			return n + sumRecursion(n - 1);
	}

	//	     Q2 : Complete merge in recursion				
	public int[] merge(int[] d1, int[] d2) {
		int [] result = new int[d1.length+d2.length];
		return merge(result, 0, d1, 0, d2, 0);
	}

	private int[] merge(int[] result,int k, int[] d1, int i, int[] d2, int j) { // (결과,전체-k,d1,d1-i,d2,d2-j)

		if (k==d1.length+d2.length) {
			return result;
		} if (i==d1.length) {
			if (j!=d2.length) { // 이미 위에서 걸러지기 때문에 없어도 되는 조건
				System.arraycopy(d2, j, result, k, d2.length-j);
				return result;
			}
//			return result;
		}
		if (j==d2.length) {
			System.arraycopy(d2, i, result, k, d1.length-i);
			return result;
		}
		else {
			if (d1[i] <= d2[j]) {
				result[k++] = d1[i++];
			} else {
				result[k++] = d2[j++];
			}
			return merge(result, k, d1, i, d2, j);
		}

	}

	//	     Q3 : Complete the methods of NewQueue class
	// 큐 구현이 아닌, 수업에서 만든 array-stack 연결과 같이 만듦이 목적
	public static class NewQueue {

		MyArrayList2<Integer> queue = new MyArrayList2<>();

		public void enqueue(int data) {
			queue.add(data); // 맨 끝 값 넣기
		}

		// TODO 감점된 부분
		public int dequeue() {
			// check Empty (있어도 되고 없어도 됨)
			return queue.remove(0);
		}

		public int peek() {
			// check Empty (있어도 되고 없어도 됨)
			if (queue.size() == 0) return -999;
			return queue.get(0);
		}

		public void showQueue() {
			System.out.println("Queue : "+queue.toString());
		}
	}

	public static void main(String[] args) {
		Code1Review q1 = new Code1Review();
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

package d10;


public class MyScheduler {

	// 링크드 리스트로 구현하는 구조체
	// Comparable.compareTo() 가 뭐하는 건지 설명함
	public static class Task implements Comparable<Task>{
		int time;
		String task;
		
		Task(int tm, String tk){
			time = tm;
			task =tk;
		}
		@Override
		public boolean equals(Object that) {
			return (this.time==((Task)that).time)&& (this.task.equals(((Task)that).task));
		}
		public String toString() {
			return ""+time + ":00 "+task;
		}
		@Override
		public int compareTo(Task that) {
			if ( this.time > that.time)
				return 1;
			else if (this.time < that.time)
				return -1;
			else 
				return 0;
		}
	}

	MyLinkedList2<Task> list;

	public MyScheduler(){
		list = new MyLinkedList2<>();
	}
	
	public void register(Task p) {  // add in time-based, ascending order
		if (list.isEmpty()) {
			list.add(0, p);
		} else {
			int i = 0;
			while (i<list.size() && list.get(i).compareTo(p) < 0) {
				i++;
			}
			list.add(i, p); // TODO 이게 무슨 문법인데 // 소팅을 위해
		}
	}
	public void done(Task p) {  // remove the given task
		list.remove(p);
	}
	
	public void showSchedule() {
		list.showList();
	}

	// 그 구조체 사용
	public static void main(String[] args) {
		MyScheduler ms = new MyScheduler();
		
		ms.showSchedule();
		
		ms.register(new Task(10, "Seminar"));
		ms.register(new Task(19, "Party"));
		ms.register(new Task(7, "Swimming"));
		ms.showSchedule();
		
		ms.register(new Task(9, "Tea Meeting"));
		ms.register(new Task(13, "Lunch"));
		ms.done(new Task(7, "Swimming"));
		ms.showSchedule();
		
		ms.done(new Task(9, "Tea Meeting"));
		ms.register(new Task(17, "Tennis"));
		ms.showSchedule();
		
		ms.done(new Task(9, "Seminar"));
		ms.showSchedule();
		ms.done(new Task(10, "Seminar"));
		ms.showSchedule();

	}

}

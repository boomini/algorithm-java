package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		System.out.println(queue.isEmpty() + "/" + queue.size());
		
		queue.offer("황선우");
		queue.offer("김연경");
		queue.offer("우상혁");
		queue.offer("여서정");
		queue.offer("이석훈");
		System.out.println(queue.isEmpty() + "/" + queue.size());
		System.out.println(queue.peek());
		System.out.println(queue.isEmpty() + "/" + queue.size());
		
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.isEmpty() + "/" + queue.size());
		System.out.println(queue.peek()); //비어있어도 에러 안발생 null값 반환
	}
}

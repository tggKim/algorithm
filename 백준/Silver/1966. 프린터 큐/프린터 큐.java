import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a1, a2) -> {
				return a2 - a1;
			});
			Deque<A> q = new ArrayDeque<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int priority = Integer.parseInt(st.nextToken());
				q.offer(new A(j, priority));
				priorityQueue.add(priority);
			}
			
			int count = 1;
			while(!q.isEmpty()) {
				A a = q.peek();
				int number = priorityQueue.peek();
				if(a.y >= number) {
					q.poll();
					priorityQueue.poll();
					if(a.x == M) {
						System.out.println(count);
						break;
					}
                    count++;
				} else {
					q.offer(q.poll());
				}
			}
		}
	}
	
	static class A {
		int x;
		int y;
		A(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
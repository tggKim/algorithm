import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int N = s.nextInt();
		int K = s.nextInt();
		
		Deque<Integer> q = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		int[] answer = new int[N];
		int index = 0;
		while(!q.isEmpty()) {
			for(int i = 0; i < K - 1; i++) {
				q.offer(q.poll());
			}
			answer[index++] = q.poll();
		}
		
		System.out.print("<");
		for(int i = 0; i < N - 1; i++) {
			System.out.print(answer[i] + ", ");
		}
		System.out.print(answer[N - 1] + ">");
	}
}
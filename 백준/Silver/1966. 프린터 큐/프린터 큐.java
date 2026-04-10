import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			PriorityQueue<Integer> pq = new PriorityQueue<>((a1, a2) -> {
				return a2 - a1;
			});
			Deque<Document> q = new ArrayDeque<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int priority = Integer.parseInt(st.nextToken());
				q.offer(new Document(j, priority));
				pq.add(priority);
			}
			
			int count = 1;
			while(!q.isEmpty()) {
				Document document = q.poll();
				if(document.priority == pq.peek()) {
					pq.poll();
					if(document.index == M) {
						System.out.println(count);
						break;
					}
                    count++;
				} else {
					q.offer(document);
				}
			}
		}
	}
	
	static class Document {
		int index;
		int priority;
		Document(int index, int priority) {
			this.index = index;
			this.priority = priority;
		}
	}
}
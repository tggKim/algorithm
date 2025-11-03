import java.util.*;
import java.io.*;

public class Main {

	static List<Node>[] list;
	static boolean[] visited;
	static int[] answer;

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[V + 1];
		visited = new boolean[V + 1];
		answer = new int[V + 1];
		for(int i = 0; i <= V; i++) {
			list[i] = new ArrayList<>();
			answer[i] = Integer.MAX_VALUE;
		}
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[u].add(new Node(v, w));
		}
		
		PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> a.weight - b.weight);
		
		q.add(new Node(K, 0));
		answer[K] = 0;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			if(visited[now.number]) {
				continue;
			}
			visited[now.number] = true;
			
			for(Node next : list[now.number]) {
				if(answer[next.number] > answer[now.number] + next.weight) {
					answer[next.number] = answer[now.number] + next.weight;
					q.add(new Node(next.number, answer[next.number]));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= V; i++) {
			if(answer[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			} else {
				sb.append(answer[i] + "\n");
			}
		}
		
		System.out.print(sb.toString());
		
	}
	
	static class Node {
		int number;
		int weight;
		
		public Node(int number, int weight) {
			this.number = number;
			this.weight = weight;
		}
	}
}
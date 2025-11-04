import java.util.*;
import java.io.*;

public class Main {
	
	static List<Node>[] list;
	static boolean[] visited;
	static long[] answer;
	static int[] path;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		answer = new long[n + 1];
		path = new int[n + 1];
		for(int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
			answer[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b, c, 0));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> Long.compare(a.weight, b.weight));
		q.add(new Node(start, 0, start));
		answer[start] = 0;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			if(visited[now.number]) {
				continue;
			}
			visited[now.number] = true;
			path[now.number] = now.before;
			
			for(Node next : list[now.number]) {
				if(answer[next.number] > answer[now.number] + next.weight) {
					answer[next.number] = answer[now.number] + next.weight;
					q.add(new Node(next.number, answer[next.number], now.number));
				}
			}
		}
		
        // 경로 복원
        List<Integer> route = new ArrayList<>();
        for (int cur = end; cur != start; cur = path[cur]) {
            route.add(cur);
        }
        route.add(start);
        Collections.reverse(route);

        // 출력
        System.out.println(answer[end]);
        System.out.println(route.size());
        for (int city : route) {
            System.out.print(city + " ");
        }
		
	}
	
	static class Node {
		int number;
		long weight;
		int before;
		
		Node(int number, long weight, int before) {
			this.number = number;
			this.weight = weight;
			this.before = before;
		}
	}
}
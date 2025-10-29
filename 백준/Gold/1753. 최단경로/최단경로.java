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
        int K = Integer.parseInt(br.readLine());        

        list = new ArrayList[V+1];
        visited = new boolean[V+1];
        answer = new int[V+1];
        for(int i=0;i<=V;i++) {
            list[i] = new ArrayList<>();
            answer[i] = Integer.MAX_VALUE;
        }
        
        for(int i=0;i<E;i++) {
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
            
            if(visited[now.point]){
                continue;
            }
            visited[now.point] = true;
            
            for(Node next : list[now.point]) {
                if(answer[next.point] > answer[now.point] + next.weight) {
                    answer[next.point] = answer[now.point] + next.weight;
                    q.add(new Node(next.point, answer[next.point]));
                }
            }
         
        }
        
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (answer[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(answer[i]).append("\n");
        }
        System.out.print(sb);
    }
    
    static class Node {
        int point;
        int weight;
        
        Node(int point, int weight) {
            this.point = point;
            this.weight = weight;
        }
    }
}
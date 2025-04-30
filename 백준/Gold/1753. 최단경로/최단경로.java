import java.util.*;
import java.io.*;

public class Main{
    
    static ArrayList<Node>[] arr;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        
        arr = new ArrayList[V+1];
        boolean[] visited = new boolean[V+1];
        int[] result = new int[V+1];
        for(int i=0;i<=V;i++){
            arr[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }
        
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[u].add(new Node(v, w));
        }
        
        PriorityQueue<Node> q = new PriorityQueue<>((a,b)->a.weight-b.weight);
        result[K]=0;
        q.add(new Node(K,0));
        while(!q.isEmpty()){
            Node now = q.poll();
            visited[now.end]=true;
            for(Node next : arr[now.end]){
                if(!visited[next.end] && now.weight + next.weight < result[next.end]){
                    result[next.end] = now.weight + next.weight;
                    q.add(new Node(next.end, result[next.end]));
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=V;i++){
            if(result[i]==Integer.MAX_VALUE){
                sb.append("INF\n");
            }
            else{
                sb.append(result[i]+"\n");
            }
        }
        System.out.println(sb);
    }
    
    static class Node{
        int weight;
        int end;
        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
    }
}
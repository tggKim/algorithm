import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        ArrayList<Node>[] arr = new ArrayList[N+1];
        boolean[] visited = new boolean[N+1];
        int[] answer = new int[N+1];
        for(int i=0;i<=N;i++){
            arr[i] = new ArrayList<>();
            answer[i] = Integer.MAX_VALUE;
        }
        
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            
            arr[x].add(new Node(y, z));
        }
        
        st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Node> q = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        q.add(new Node(startCity, 0));
        while(!q.isEmpty()){
            Node now = q.poll();
            visited[now.end] = true;
            if(answer[now.end] < now.weight){
                continue;
            }
            for(Node next : arr[now.end]){
                if(!visited[next.end] && now.weight + next.weight < answer[next.end]){
                    answer[next.end] = now.weight + next.weight;
                    q.add(new Node(next.end, answer[next.end]));
                }
            }
        }
        
        System.out.println(answer[endCity]);
    }
    
    static class Node{
        int end;
        int weight;
        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
    }
}
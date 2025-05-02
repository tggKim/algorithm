import java.util.*;
import java.io.*;

public class Main{
   
    static final int INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        ArrayList<Node>[] arr1 = new ArrayList[N+1];
        ArrayList<Node>[] arr2 = new ArrayList[N+1];
        int[] answer1 = new int[N+1];
        int[] answer2 = new int[N+1];
        boolean[] visited1 = new boolean[N+1];
        boolean[] visited2 = new boolean[N+1];
        
        for(int i=0;i<=N;i++){
            arr1[i] = new ArrayList<>();
            arr2[i] = new ArrayList<>();
            answer1[i] = INF;
            answer2[i] = INF;
        }
        
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr1[a].add(new Node(b,c));
            arr2[b].add(new Node(a,c));
        }
        
        int[] start = method(arr1, answer1, visited1, X);
        int[] backword = method(arr2, answer2, visited2, X);
        
        int max = 0;
        for(int i=1;i<=N;i++){
            max = Math.max(max, start[i] + backword[i]);
        }
        
        System.out.println(max);
    }
    
    static int[] method(ArrayList<Node>[] arr, int[] answer, boolean[] visited, int X){
        PriorityQueue<Node> q = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        answer[X] = 0;
        q.add(new Node(X,0));
        while(!q.isEmpty()){
            Node now = q.poll();
            if(visited[now.end]){
                continue;
            }
            visited[now.end] = true;
            for(Node next : arr[now.end]){
                if(answer[next.end] > now.weight + next.weight){
                    answer[next.end] = now.weight + next.weight;
                    q.add(new Node(next.end, answer[next.end]));
                }
            }
        }
        return answer;
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
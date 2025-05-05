import java.util.*;
import java.io.*;

public class Main{
    
    static List<Node> arr = new ArrayList<>();
    static long[] answer;
    static int INF = 50000000;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        answer = new long[N+1];
        Arrays.fill(answer, INF);
        answer[1] = 0;
        
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            arr.add(new Node(a, b, c));
        }
        
        for(int i=1;i<N;i++){
            for(Node e : arr){
                if(answer[e.from] != INF && answer[e.to] > answer[e.from] + e.weight){
                    answer[e.to] = answer[e.from] + e.weight;
                }
            }
        }
        
        for(Node e : arr){
            if(answer[e.from] != INF && answer[e.to] > answer[e.from] + e.weight){
                System.out.println(-1);
                return;
            }
        }
        
        for(int i=2;i<=N;i++){
            bw.write(answer[i] == INF ? "-1\n" : String.valueOf(answer[i]) + "\n");
        }
        
        bw.flush();
    }
    
    static class Node{
        int from;
        int to;
        int weight;
        public Node(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
import java.util.*;
import java.io.*;

public class Main{
    
    static ArrayList<Integer>[] vec;
    static int[] answer;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        vec = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            vec[i] = new ArrayList<>();
        }
        answer = new int[N+1];
        
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            vec[y].add(x);
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=N;i++){
            int count=0;
            boolean[] visited = new boolean[N+1];
            visited[i] = true;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while(!q.isEmpty()){
                int pollNumber = q.poll();
                for(int node : vec[pollNumber]){
                    if(!visited[node]){
                        visited[node] = true;
                        count++;
                        q.add(node);
                    }
                }
            }
            
            answer[i]=count;
            max = Math.max(max, count);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++){
            if(answer[i] == max){
                sb.append(i+" ");
            }
        }
        System.out.println(sb);
    }
}
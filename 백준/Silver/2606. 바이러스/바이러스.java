import java.util.*;
import java.io.*;

public class Main{
    
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int count;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        arr = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = new ArrayList();
        }
        visited = new boolean[N+1];
        
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }
        
        dfs(1);
        
        System.out.println(count);
    }
    
    static void dfs(int x){
        visited[x] = true;
        for(int number : arr[x]){
            if(!visited[number]){
                count++;
                dfs(number);
            }
        }
    }
}
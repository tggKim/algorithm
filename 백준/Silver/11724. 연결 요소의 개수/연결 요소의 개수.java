import java.util.*;
import java.io.*;

public class Main {
    
    static List<Integer>[] arr;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        arr = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=0;i<arr.length;i++) {
            arr[i] = new ArrayList<>();
        }
        
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            arr[v].add(u);
        }
        
        int count = 0;
        for(int i=1;i<arr.length;i++) {
            if(!visited[i]){
                count++;
                dfs(i);
            }
        }
        
        System.out.print(count);
    }
    
    static void dfs(int x) {
        visited[x] = true;
        for(Integer number : arr[x]) {
            if(!visited[number]) {
                dfs(number);
            }
        }
    }
}
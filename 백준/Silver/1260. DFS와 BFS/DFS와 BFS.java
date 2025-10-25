import java.util.*;
import java.io.*;

public class Main {
   
    static List<Integer>[] list;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=0;i<N+1;i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }
        
        for(int i=0;i<list.length;i++){
            Collections.sort(list[i]);
        }
        
        dfs(V);
        
        visited = new boolean[N+1];
        System.out.println();
        
        bfs(V);
        
    }
    
    static void dfs(int x) {
        visited[x] = true;
        System.out.print(x + " ");
        for(Integer number : list[x]) {
            if(!visited[number]) {
                dfs(number);
            }
        }
    }
    
    static void bfs(int x) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(x);
        System.out.print(x + " ");
        visited[x] = true;
        while(!queue.isEmpty()) {
            int qx = queue.removeFirst();
            for(Integer number : list[qx]) {
                if(!visited[number]) {
                    System.out.print(number + " ");
                    queue.addLast(number);
                    visited[number] = true;
                }
            }
        }
    }
}
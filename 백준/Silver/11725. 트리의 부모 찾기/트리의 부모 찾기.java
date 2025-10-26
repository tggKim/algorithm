import java.util.*;
import java.io.*;

public class Main {
    
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        
        list = new ArrayList[N+1];
        for(int i=0;i<=N;i++) {
            list[i] = new ArrayList<>();
        }
        visited = new boolean[N+1];
        answer = new int[N+1];

        String str = br.readLine();
        while(str != null && !str.equals("")){

            StringTokenizer st = new StringTokenizer(str);
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            list[x].add(y);
            list[y].add(x);

            str = br.readLine();
        }
        
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(1);
        visited[1] = true;
        while(!q.isEmpty()) {
            int number = q.removeFirst();
            for(Integer qx : list[number]) {
                if(!visited[qx]) {
                    q.addLast(qx);
                    visited[qx] = true;
                    answer[qx] = number;
                }   
            }
        }
        
        for(int i=2;i<answer.length;i++) {
            bw.write(answer[i]+"\n");
        }
        
        bw.flush();
    }
}
import java.util.*;
import java.io.*;

public class Main{
    
    static boolean[][] visited;
    static int[][] arr;
    
    static int[] calx = {0,0,1,-1};
    static int[] caly = {1,-1,0,0};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                arr[i][j] = str.charAt(j) - '0'; 
            }
        }
        
        bfs(0, 0);
    }
    
    static void bfs(int x, int y){
        visited[x][y] = true;
        Queue<A> q = new LinkedList<>();
        q.add(new A(x, y, 1));
                
        while(!q.isEmpty()){
            A a = q.poll();
            int qx = a.x;
            int qy = a.y;
            
            for(int i=0;i<4;i++){
                int newX = qx + calx[i];
                int newY = qy + caly[i];
                if(newX>=0 && newY>=0 && newX<arr.length && newY<arr[0].length && !visited[newX][newY] && arr[newX][newY] == 1){
                    if(newX == arr.length-1 && newY == arr[0].length-1){
                        System.out.println(a.count+1);
                        return;
                    }
                    visited[newX][newY] = true;
                    q.add(new A(newX, newY, a.count+1));
                }
            }
        }
    }
    
    static class A{
        public int x;
        public int y;
        public int count;
        
        public A(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
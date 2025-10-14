import java.util.*;
import java.io.*;

public class Main{
    
    static int[][] arr;
    static int[] calx = {0, 0, 1, -1};
    static int[] caly = {1, -1, 0, 0};
    static boolean[][] visited;
    static int maxInt = 0;
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        visited = new boolean[n][m];
        arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int count = 0;
        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && arr[i][j] == 1) {
                    count++;
                    dfs(i, j); 
                    max = Math.max(max, maxInt);
                    maxInt = 0;
                }
            }
        }
        
        System.out.println(count);
        System.out.println(max);
        
    }
    
     static void dfs(int x, int y) {
         visited[x][y] = true;
         maxInt++;
         for(int i = 0; i < 4; i++) {
             int dx = x + calx[i];
             int dy = y + caly[i];
             if(dx >= 0 && dy >= 0 && dx < arr.length && dy < arr[0].length && !visited[dx][dy] && arr[dx][dy] == 1) {
                 dfs(dx, dy);
             }
         }
     }

}
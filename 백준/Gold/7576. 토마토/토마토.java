import java.util.*;
import java.io.*;

public class Main {
    
    static int[][] arr;
    static boolean[][] visited;
    static int[] calx = {0, 0, 1, -1};
    static int[] caly = {1, -1, 0, 0};
    static Deque<Integer> queueX = new ArrayDeque<>();
    static Deque<Integer> queueY = new ArrayDeque<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int number = Integer.parseInt(st.nextToken());
                arr[i][j] = number;
                
                if(number == 1) {
                    queueX.addLast(i);
                    queueY.addLast(j);
                    visited[i][j] = true;
                }
            }
        }
        
        bfs();
        
        int max = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, arr[i][j]);
            }
        }
        
        System.out.println(max-1);
    }
    
    static void bfs() {
        while(!queueX.isEmpty()) {
            int qx = queueX.removeFirst();
            int qy = queueY.removeFirst();
            for(int i = 0; i < 4; i++) {
                int cx = qx + calx[i];
                int cy = qy + caly[i];
                if(cx >= 0 && cx < arr.length && cy >= 0 && cy < arr[0].length && !visited[cx][cy] && arr[cx][cy] != -1 && arr[cx][cy] == 0) {
                    queueX.addLast(cx);
                    queueY.addLast(cy);
                    arr[cx][cy] = arr[qx][qy] + 1;
                    visited[cx][cy] = true;
                }
            }
        }
    }
    
}
import java.util.*;
import java.io.*;

public class Main {
    
    static int[][] arr;
    static boolean[][] visited;
    static int[] calx = {0, 0, 1, -1};
    static int[] caly = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];
        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
        
        bfs(0,0);
    }
    
    static void bfs(int x, int y) {
        Deque<Integer> dequeX = new ArrayDeque<>();
        Deque<Integer> dequeY = new ArrayDeque<>();
        dequeX.addLast(x);
        dequeY.addLast(y);
        visited[x][y] = true;
        
        while(!dequeX.isEmpty()) {
            int firstX = dequeX.removeFirst();
            int firstY = dequeY.removeFirst();
            
            for(int i = 0; i < 4; i++) {
                int resultX = firstX + calx[i];
                int resultY = firstY + caly[i];
                
                if(resultX >= 0 && resultX < arr.length && resultY >= 0 && resultY < arr[0].length && arr[resultX][resultY] != 0 && !visited[resultX][resultY]) {
                    dequeX.addLast(resultX);
                    dequeY.addLast(resultY);
                    arr[resultX][resultY] = arr[firstX][firstY] + 1;
                    visited[resultX][resultY] = true;

                    if(resultX == arr.length - 1 && resultY == arr[0].length - 1) {
                        System.out.println(arr[firstX][firstY] + 1);
                        return;
                    }
                }
                
            }
        }
        
    }
    
}
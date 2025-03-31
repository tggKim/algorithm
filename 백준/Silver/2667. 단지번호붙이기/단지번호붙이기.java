import java.util.*;
import java.io.*;

public class Main{
    
    static int[][] arr;
    static boolean[][] visited;
    static int count;
    
    static int[] calx = {0,0,1,-1};
    static int[] caly = {1,-1,0,0};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        arr = new int[N][N];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<str.length();j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        visited = new boolean[N][N];
        
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j] && arr[i][j] == 1){
                    count = 1;
                    dfs(i,j);
                    list.add(count);
                }
            }
        }
        
        System.out.println(list.size());
        Collections.sort(list);
        for(int i : list){
            System.out.println(i);
        }
    }
    
    static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i=0;i<4;i++){
            int newX = x+calx[i];
            int newY = y+caly[i];
            if(newX>=0 && newX<arr.length && newY>=0 && newY<arr.length && !visited[newX][newY] && arr[newX][newY] == 1){
                count++;
                dfs(newX, newY);
            }
        }
    }
}
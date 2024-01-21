import java.util.*;
import java.io.*;
public class Main{
    static int[][] arr;
    static boolean[][] visited;
    static int[] calx= {0,0,1,-1};
    static int[] caly={1,-1,0,0};
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        bfs(0,0);
    }
    static void bfs(int y,int x){
        if(y==arr.length-1&&x==arr[0].length-1){
            System.out.println(0);
            return;
        }
        PriorityQueue<P> q = new PriorityQueue<>((a,b)->a.count-b.count);
        q.add(new P(x,y));
        visited[y][x]=true;
        while(!q.isEmpty()){
            P now = q.poll();
            for(int i=0;i<4;i++){
                int ny=now.y+caly[i];
                int nx=now.x+calx[i];
                if(ny>=0&&ny<arr.length&&nx>=0&&nx<arr[0].length&&!visited[ny][nx]){
                    if(arr[ny][nx]==1){
                        if(ny==arr.length-1&&nx==arr[0].length-1){
                            System.out.println(now.count+1);
                            return;
                        }
                        P p = new P(nx,ny);
                        p.count=now.count+1;
                        visited[ny][nx]=true;
                        q.add(p);
                    }
                    else{
                        if(ny==arr.length-1&&nx==arr[0].length-1){
                            System.out.println(now.count);
                            return;
                        }
                        P p = new P(nx,ny);
                        p.count=now.count;
                        visited[ny][nx]=true;
                        q.add(p);
                    }
                }
            }
        }
    }
    static class P{
        int x;
        int y;
        int count=0;
        P(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}